package com.nzyjfw.o2o.service;

import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.entity.Goods;

import java.util.List;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
public interface GoodsService {

    /**
     * 根据ID查找
     *
     * @param id 需要查找的ID
     * @return 查找到的实体
     */
    Goods findById(int id);

    /**
     * 根据名称模糊查找
     *
     * @param name 需要查找的ID
     * @return 查找到的实体
     */
    List<Goods> findByName(String name);

    /**
     * 根据分类查找
     *
     * @param classifyName 需要查找的分类
     * @return 查找到的实体
     */
    List<Goods> findByClassify(String classifyName);

    /**
     * 查询库存大于0的商品
     *
     * @return 查找到的实体
     */
    List<Goods> findByStock();

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
    PageInfo<Goods> selectAll(int pageNum, int pageSize);

    /**
     * 增加商品
     *
     * @param goods 添加实体
     * @return 影响行数
     */
    boolean add(Goods goods);

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
     * @param goods 实体
     * @return 影响行数
     */
    boolean update(Goods goods);
}