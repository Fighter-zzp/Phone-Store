package com.zzp.phone.stage.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;

/**
 * 商品规格表
 *
 * @author ZZP
 */
@Data
@Table(name = "phone_specs")
public class PhoneSpecs implements Serializable {
    @Id
    @Column(name = "specs_id")
    @GeneratedValue(generator = "JDBC")
    private Integer specsId;

    @Column(name = "phone_id")
    private String phoneId;

    /**
     * 规格名称
     */
    @Column(name = "specs_name")
    private String specsName;

    /**
     * 库存
     */
    @Column(name = "specs_stock")
    private Integer specsStock;

    /**
     * 单价
     */
    @Column(name = "specs_price")
    private BigDecimal specsPrice;

    /**
     * 小图
     */
    @Column(name = "specs_icon")
    private String specsIcon;

    /**
     * 预览图
     */
    @Column(name = "specs_preview")
    private String specsPreview;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}