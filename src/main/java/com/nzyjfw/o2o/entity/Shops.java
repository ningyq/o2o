package com.nzyjfw.o2o.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * (Shops)实体类
 *
 * @author makejava
 * @since 2020-03-04 22:20:20
 */
@Data
public class Shops implements Serializable {
    private static final long serialVersionUID = 834931155922494388L;
    /**
     * 商铺ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 商铺名
     */
    private String name;
    /**
     * 商铺运费
     */
    private Double freight;
    /**
     * 商铺描述
     */
    private String description;
    /**
     * 商品集
     */
    @Transient
    private List<Goods> goodsList;
}