package com.nzyjfw.o2o.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2020-03-04 22:16:35
 */
@Data
@Table(name = "order_table")
public class Order implements Serializable {
    private static final long serialVersionUID = 123231708838167637L;
    /**
     * 订单编号
     */
    @Id
    private String id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 订单金额
     */
    private Double money;
    /**
     * 订单生成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;
    /**
     * 运费
     */
    private Double freight;
    /**
     * 订单状态（-1：已取消；0：已下单；1：配送中；2：配送完成）
     */
    private Integer status;
    /**
     * 商品集
     */
    @Transient
    private List<GoodSet> goodSetList;

}