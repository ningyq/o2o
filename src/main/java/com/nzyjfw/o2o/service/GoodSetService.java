package com.nzyjfw.o2o.service;

import com.nzyjfw.o2o.entity.GoodSet;

import java.util.List;

/**
 * (GoodSet)表服务接口
 *
 * @author makejava
 * @since 2020-03-05 09:53:22
 */
public interface GoodSetService {

    /**
     * 购物车信息
     *
     * @param userId 用户ID
     * @return 购物车商品信息
     */
    List<GoodSet> findByUserId(int userId);

    /**
     * 订单信息
     *
     * @param orderId 订单编号
     * @return 订单商品信息
     */
    List<GoodSet> findByOrderId(String orderId);

    /**
     * 加入购物车
     *
     * @param goodSet 加入购物车商品
     * @return 加入数量
     */
    boolean addCart(GoodSet goodSet);

    /**
     * 删除购物车
     *
     * @param goodSets 删除商品
     * @return 加入数量
     */
    boolean deleteCart(List<GoodSet> goodSets);

    /**
     * 更新购物车
     *
     * @param goodSet 更新商品
     * @return 影响数量
     */
    boolean updateCart(GoodSet goodSet);

    /**
     * 订单
     *
     * @param goodSets 订单商品信息
     * @return 加入数量
     */
    boolean addAllOrder(List<GoodSet> goodSets);

}