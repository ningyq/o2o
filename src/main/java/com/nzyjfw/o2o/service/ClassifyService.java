package com.nzyjfw.o2o.service;

import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.entity.Classify;

/**
 * (Classify)表服务接口
 *
 * @author makejava
 * @since 2020-03-04 16:41:03
 */
public interface ClassifyService {

    /**
     * 根据ID查找
     *
     * @param id 需要查找的ID
     * @return 查找到的实体
     */
    Classify findById(int id);

    /**
     * 分页查询所有
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 查询列表
     */
    PageInfo<Classify> selectAll(int pageNum, int pageSize);

    /**
     * 增加分类
     *
     * @param classify 添加实体
     * @return 影响行数
     */
    boolean add(Classify classify);

    /**
     * 根据ID删除分类
     *
     * @param id 需要删除的ID
     * @return 是否成功
     */
    boolean deleteById(int id);

    /**
     * 更新
     *
     * @param classify 实体
     * @return 影响行数
     */
    boolean update(Classify classify);
}