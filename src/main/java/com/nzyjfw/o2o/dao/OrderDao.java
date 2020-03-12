package com.nzyjfw.o2o.dao;

import com.nzyjfw.o2o.entity.Order;
import com.nzyjfw.o2o.utils.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Order)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
public interface OrderDao extends BaseMapper<Order> {

    @Select("select count(*) from order_table")
    int count();

    List<Order> all();

    Order findByOrderId(String orderId);

    List<Order> findByUserId(int userId);
}