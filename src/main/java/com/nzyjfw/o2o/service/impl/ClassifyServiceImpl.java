package com.nzyjfw.o2o.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.entity.Classify;
import com.nzyjfw.o2o.dao.ClassifyDao;
import com.nzyjfw.o2o.service.ClassifyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (Classify)表服务实现类
 *
 * @author makejava
 * @since 2020-03-04 16:41:03
 */
@Service("classifyService")
@Transactional(rollbackFor=Exception.class)
public class ClassifyServiceImpl implements ClassifyService {
    @Resource
    private ClassifyDao classifyDao;

    @Override
    public Classify findById(int id) {

        return classifyDao.findById(id);
    }

    @Override
    public PageInfo<Classify> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(classifyDao.selectAll());
    }

    @Override
    public boolean add(Classify classify) {
        return classifyDao.insertSelective(classify) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        return classifyDao.deleteById(id);
    }

    @Override
    public boolean update(Classify classify) {
        return classifyDao.updateByPrimaryKeySelective(classify) > 0;
    }
}