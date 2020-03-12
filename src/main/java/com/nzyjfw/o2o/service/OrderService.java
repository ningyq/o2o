package com.nzyjfw.o2o.service;

import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.entity.Order;

import java.util.List;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
public interface OrderService {

    /**
     * 查找订单
     *
     * @param orderId 订单编号
     * @return 订单
     */
    Order findByOrderId(String orderId);

    /**
     * 查找订单
     *
     * @param userId 用户ID
     * @return 订单
     */
    List<Order> findByUserId(int userId);

    /**
     * 添加订单
     *
     * @param order 订单
     * @return 是否添加成功
     */
    boolean add(Order order);

    /**
     * 查询总数
     *
     * @return 查询列表
     */
    int selectCount();

    /**
     * 分页查询所有
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 查询列表
     */
    PageInfo<Order> selectAll(int pageNum, int pageSize);

    /**
     * 取消订单
     *
     * @param orderId 订单编号
     * @return 订单
     */
    boolean cancel(String orderId);

    /**
     * 修改订单
     *
     * @param order 订单实体
     * @return 订单
     */
    boolean update(Order order);

}