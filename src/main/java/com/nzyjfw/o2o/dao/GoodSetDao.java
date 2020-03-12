package com.nzyjfw.o2o.dao;

import com.nzyjfw.o2o.entity.GoodSet;
import com.nzyjfw.o2o.utils.BaseMapper;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * (GoodSet)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
public interface GoodSetDao extends BaseMapper<GoodSet> {

    @Delete("delete from good_set where num = 0")
    int deleteByNum();

    List<GoodSet> findByUserId(int userId);

    List<GoodSet> findByOrderId(String orderId);

    GoodSet selectOneByUserIdAndGoodsId(int userId, int goodsId);
}