package com.nzyjfw.o2o.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2020-03-04 22:16:34
 */
@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = 381139609788471470L;
    /**
     * 商品编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 店铺ID
     */
    private Integer shopsId;
    /**
     * 名称
     */
    private String name;
    /**
     * 照片
     */
    private String photo;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 描述
     */
    private String description;
    /**
     * 月销量
     */
    private Integer salesVolume;
    /**
     * 单位
     */
    private String unit;
    /**
     * 单价
     */
    private Double price;
    /**
     * 分类ID
     */
    private Integer classifyId;
    /**
     * 分类实体
     */
    @Transient
    private Classify classify;
    /**
     * 店铺
     */
    @Transient
    private Shops shop;

}