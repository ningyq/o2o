package com.nzyjfw.o2o.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * (GoodSet)实体类
 *
 * @author makejava
 * @since 2020-03-04 22:16:33
 */
@Data
public class GoodSet implements Serializable {
    private static final long serialVersionUID = 126263098895905718L;
    /**
     * 商品集ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 商品编号
     */
    private Integer goodsId;
    /**
     * 商品数量
     */
    private Integer num;
    /**
     * 商品集
     */
    @Transient
    private Goods goods;

}