package com.nzyjfw.o2o.dao;

import com.nzyjfw.o2o.entity.Goods;
import com.nzyjfw.o2o.utils.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Goods)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
public interface GoodsDao extends BaseMapper<Goods> {
    List<Goods> findByName(String name);

    List<Goods> findByShopsId(int shopsId);

    Goods findById(int id);

    List<Goods> findByClassify(String classifyName);

    List<Goods> findByStock();

    List<Goods> findAll();

    @Select("select count(*) from goods")
    int count();

    @Delete("delete from goods where id = #{id}")
    boolean deleteById(int id);
}