package com.nzyjfw.o2o.service;

import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.entity.Shops;

/**
 * (Shops)表服务接口
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
public interface ShopsService {

    /**
     * 根据ID查找
     *
     * @param id 需要查找的ID
     * @return 查找到的实体
     */
    Shops findById(int id);

    /**
     * 分页查询所有
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 查询列表
     */
    PageInfo<Shops> selectAll(int pageNum, int pageSize);

    /**
     * 查询总数
     *
     * @return 查询列表
     */
    int selectCount();

    /**
     * 增加
     *
     * @param shops 添加实体
     * @return 影响行数
     */
    boolean add(Shops shops);

    /**
     * 根据ID删除
     *
     * @param id 需要删除的ID
     * @return 是否成功
     */
    boolean deleteById(int id);

    /**
     * 更新
     *
     * @param shops 实体
     * @return 影响行数
     */
    boolean update(Shops shops);
}