package com.zzp.phone.stage.service;

import com.zzp.phone.stage.vo.DataVo;
import com.zzp.phone.stage.vo.PhoneInfoVo;
import com.zzp.phone.stage.vo.SpecsPackageVo;

import java.util.List;
/**
 * 手机服务接口
 * <p>
 *  //TODO
 *  PhoneService.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 21:16
 * @see  PhoneService
 **/
public interface PhoneService {
    /**
     * 查找手机信息
     * @return {@link DataVo}
     */
    DataVo findDataVo();

    /**
     * 通过货品类型查询手机信息
     * @param categoryType 货品类型
     * @return {@link List<PhoneInfoVo>}
     */
    List<PhoneInfoVo> findPhoneInfoVoByCategoryType(Integer categoryType);

    /**
     * 通过手机id查找价格规格
     * @param phoneId 手机id
     * @return {@link SpecsPackageVo}
     */
    SpecsPackageVo findSpecsByPhoneId(Integer phoneId);

    /**
     * 扣除库存
     * @param specsId 价格id
     * @param quantity 数量
     */
    void subStock(Integer specsId,Integer quantity);
}