package com.zzp.phone.stage.service.impl;

import com.zzp.phone.stage.domain.PhoneInfo;
import com.zzp.phone.stage.domain.PhoneSpecs;
import com.zzp.phone.stage.enums.ResultEnum;
import com.zzp.phone.stage.exception.PhoneException;
import com.zzp.phone.stage.mapper.PhoneCategoryMapper;
import com.zzp.phone.stage.mapper.PhoneInfoMapper;
import com.zzp.phone.stage.mapper.PhoneSpecsMapper;
import com.zzp.phone.stage.service.PhoneService;
import com.zzp.phone.stage.util.PhoneUtil;
import com.zzp.phone.stage.vo.DataVo;
import com.zzp.phone.stage.vo.PhoneCategoryVo;
import com.zzp.phone.stage.vo.PhoneInfoVo;
import com.zzp.phone.stage.vo.PhoneSpecsCasVo;
import com.zzp.phone.stage.vo.PhoneSpecsVo;
import com.zzp.phone.stage.vo.SkuVo;
import com.zzp.phone.stage.vo.SpecsPackageVo;
import com.zzp.phone.stage.vo.TreeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Phone服务实现
 * <p>
 * //TODO
 * PhoneServiceImpl.java
 * </p>
 *
 * @author 佐斯特勒
 * @version v1.0.0
 * @date 2020/5/25 21:23
 * @see PhoneServiceImpl
 **/
@Service
@Slf4j
@Transactional(rollbackFor = PhoneException.class)
public class PhoneServiceImpl implements PhoneService {

    @Resource
    private PhoneCategoryMapper phoneCategoryMapper;
    @Resource
    private PhoneInfoMapper phoneInfoMapper;
    @Resource
    private PhoneSpecsMapper phoneSpecsMapper;

    @Override
    public DataVo findDataVo() {
        var dataVo = new DataVo();
        // 查找手机类别
        var phoneCategoryList = phoneCategoryMapper.selectAll();

        var phoneCategoryVOList = phoneCategoryList.stream()
                .map(e -> new PhoneCategoryVo(
                        e.getCategoryName(),
                        e.getCategoryType()
                )).collect(Collectors.toList());

        dataVo.setCategories(phoneCategoryVOList);

        // 获取手机信息
        var categoryType = phoneCategoryList.get(0).getCategoryType();
        var phoneInfoList = getPhoneInfoListByCategoryType(categoryType);
        dataVo.setPhones(phoneInfoList);

        return dataVo;
    }

    @Override
    public List<PhoneInfoVo> findPhoneInfoVoByCategoryType(Integer categoryType) {
        return getPhoneInfoListByCategoryType(categoryType);
    }

    @Override
    public SpecsPackageVo findSpecsByPhoneId(Integer phoneId) {
        var phoneInfo = new PhoneInfo();
        phoneInfo.setPhoneId(phoneId);
        // 对应的单条手机信息
        phoneInfo = phoneInfoMapper.selectOne(phoneInfo);
        var example = new Example(PhoneSpecs.class);
        example.createCriteria().andEqualTo("phoneId", phoneId);
        // 通过手机id得到手机规格
        var phoneSpecsList = phoneSpecsMapper.selectByExample(example);

        var phoneSpecsVoList = new ArrayList<PhoneSpecsVo>();
        var phoneSpecsCasVoList = new ArrayList<PhoneSpecsCasVo>();
        phoneSpecsList.forEach(phoneSpecs -> {
            var phoneSpecsVo = new PhoneSpecsVo();
            var phoneSpecsCasVo = new PhoneSpecsCasVo();
            BeanUtils.copyProperties(phoneSpecs, phoneSpecsVo);
            BeanUtils.copyProperties(phoneSpecs, phoneSpecsCasVo);
            phoneSpecsVoList.add(phoneSpecsVo);
            phoneSpecsCasVoList.add(phoneSpecsCasVo);
        });
        // 放入自定义sku信息中
        var treeVO = new TreeVo();
        treeVO.setV(phoneSpecsVoList);
        var treeVOList = new ArrayList<TreeVo>();
        treeVOList.add(treeVO);

        // sku结构数据
        var skuVO = new SkuVo();
        var price = phoneInfo.getPhonePrice().intValue();
        skuVO.setPrice(price + ".00");
        skuVO.setStock_num(phoneInfo.getPhoneStock());
        skuVO.setTree(treeVOList);
        skuVO.setList(phoneSpecsCasVoList);

        var specsPackageVo = new SpecsPackageVo();
        specsPackageVo.setSku(skuVO);
        var goods = new HashMap<String, String>(16);
        goods.put("picture", phoneInfo.getPhoneIcon());
        specsPackageVo.setGoods(goods);

        return specsPackageVo;
    }

    @Override
    public void subStock(Integer specsId, Integer quantity) {
        // 根据规格id找phone_specs的库存和phoneId
        var e1 = Example.builder(PhoneSpecs.class)
                .select("specsStock","phoneId","specsId")
                .andWhere(Sqls.custom().andEqualTo("specsId", specsId))
                .build();
        var phoneSpecs = phoneSpecsMapper.selectOneByExample(e1);

        // 根据规格对应的phoneId找PhoneInfo的库存
        var e2 = Example.builder(PhoneInfo.class)
                .select("phoneStock","phoneId")
                .andWhere(Sqls.custom().andEqualTo("phoneId", phoneSpecs.getPhoneId()))
                .build();
        var phoneInfo = phoneInfoMapper.selectOneByExample(e2);

        // 货存减购买量
        var result = Optional.of(phoneSpecs)
                .map(ps->ps.getSpecsStock()-quantity).filter(ss->ss>0)
                .orElseThrow(()->{
            log.error("【扣库存】库存不足");
            return new PhoneException(ResultEnum.PHONE_STOCK_ERROR);
        });
        // 更新库存
        phoneSpecs.setSpecsStock(result);
        phoneSpecs.setPhoneId(null);
        phoneSpecsMapper.updateByPrimaryKeySelective(phoneSpecs);

        // 货存货存减购买量
        result = phoneInfo.getPhoneStock() - quantity;
        if (result < 0) {
            log.error("【扣库存】库存不足");
            throw new PhoneException(ResultEnum.PHONE_STOCK_ERROR);
        }
        //更新货存
        phoneInfo.setPhoneStock(result);
        phoneInfoMapper.updateByPrimaryKeySelective(phoneInfo);
    }

    /**
     * 通过手机类别数查询手机列表信息
     *
     * @param categoryType 类别数
     * @return {@link List<PhoneInfoVo>}
     */
    private List<PhoneInfoVo> getPhoneInfoListByCategoryType(Integer categoryType) {
        var example = new Example(PhoneInfo.class);
        example.createCriteria().andEqualTo("categoryType", categoryType);
        var phoneInfoList = phoneInfoMapper.selectByExample(example);
        return phoneInfoList.stream()
                .map(e -> new PhoneInfoVo(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice() + ".00",
                        e.getPhoneDescription(),
                        PhoneUtil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()
                )).collect(Collectors.toList());
    }
}
