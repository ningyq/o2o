package com.nzyjfw.o2o.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.dao.GoodsDao;
import com.nzyjfw.o2o.entity.Goods;
import com.nzyjfw.o2o.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
@Service("goodsService")
@Transactional(rollbackFor=Exception.class)
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    @Override
    public Goods findById(int id) {
        return goodsDao.findById(id);
    }

    @Override
    public List<Goods> findByName(String name) {
        return goodsDao.findByName(name);
    }

    @Override
    public List<Goods> findByClassify(String classifyName) {
        return goodsDao.findByClassify(classifyName);
    }

    @Override
    public List<Goods> findByStock() {
        return goodsDao.findByStock();
    }

    @Override
    public int selectCount() {
        return goodsDao.count();
    }

    @Override
    public PageInfo<Goods> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(goodsDao.findAll());
    }

    @Override
    public boolean add(Goods goods) {
        return goodsDao.insertSelective(goods) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        return goodsDao.deleteById(id);
    }

    @Override
    public boolean update(Goods goods) {
        return goodsDao.updateByPrimaryKey(goods) > 0;
    }
}