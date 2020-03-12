package com.nzyjfw.o2o.service.impl;

import com.nzyjfw.o2o.dao.GoodsDao;
import com.nzyjfw.o2o.entity.GoodSet;
import com.nzyjfw.o2o.dao.GoodSetDao;
import com.nzyjfw.o2o.service.GoodSetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (GoodSet)表服务实现类
 *
 * @author makejava
 * @since 2020-03-05 09:53:22
 */
@Service("goodSetService")
@Transactional(rollbackFor=Exception.class)
public class GoodSetServiceImpl implements GoodSetService {
    @Resource
    private GoodSetDao goodSetDao;

    @Resource
    private GoodsDao goodsDao;

    @Override
    public List<GoodSet> findByUserId(int userId) {
        List<GoodSet> goodSetList = goodSetDao.findByUserId(userId);
        for (GoodSet goodSet : goodSetList) {
            goodSet.setGoods(goodsDao.findById(goodSet.getGoodsId()));
        }
        return goodSetList;
    }

    @Override
    public List<GoodSet> findByOrderId(String orderId) {
        List<GoodSet> goodSetList = goodSetDao.findByOrderId(orderId);
        for (GoodSet goodSet : goodSetList) {
            goodSet.setGoods(goodsDao.findById(goodSet.getGoodsId()));
        }
        return goodSetList;
    }

    @Override
    public boolean addCart(GoodSet goodSet) {
        GoodSet gs = goodSetDao.selectOneByUserIdAndGoodsId(goodSet.getUserId(),goodSet.getGoodsId());
        if (gs != null) {
            gs.setNum(gs.getNum() + goodSet.getNum());
            return updateCart(gs);
        }
        return goodSetDao.insertSelective(goodSet) > 0;
    }

    @Override
    public boolean deleteCart(List<GoodSet> goodSets) {
        int num = 0;

        for (GoodSet goodSet : goodSets) {
            num += goodSetDao.deleteByPrimaryKey(goodSet.getId());
        }

        return num > 0;
    }

    @Override
    public boolean updateCart(GoodSet goodSet) {
        int num = goodSetDao.updateByPrimaryKey(goodSet);
        goodSetDao.deleteByNum();
        return num > 0;
    }

    @Override
    public boolean addAllOrder(List<GoodSet> goodSets) {
        return goodSetDao.insertList(goodSets) > 0;
    }
}