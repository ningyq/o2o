package com.nzyjfw.o2o.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.dao.GoodsDao;
import com.nzyjfw.o2o.entity.Shops;
import com.nzyjfw.o2o.dao.ShopsDao;
import com.nzyjfw.o2o.service.ShopsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (Shops)表服务实现类
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
@Service("shopsService")
@Transactional(rollbackFor=Exception.class)
public class ShopsServiceImpl implements ShopsService {
    @Resource
    private ShopsDao shopsDao;

    @Resource
    private GoodsDao goodsDao;

    @Override
    public Shops findById(int id) {
        Shops shop = shopsDao.findById(id);
        if (shop != null) {
            shop.setGoodsList(goodsDao.findByShopsId(id));
        }
        return shop;
    }

    @Override
    public PageInfo<Shops> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(shopsDao.selectAll());
    }

    @Override
    public int selectCount() {
        return shopsDao.count();
    }

    @Override
    public boolean add(Shops shops) {
        return shopsDao.insertSelective(shops) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        return shopsDao.deleteById(id);
    }

    @Override
    public boolean update(Shops shops) {
        return shopsDao.updateByPrimaryKeySelective(shops) > 0;
    }
}