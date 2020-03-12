package com.nzyjfw.o2o.dao;

import com.nzyjfw.o2o.entity.Shops;
import com.nzyjfw.o2o.utils.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

/**
 * (Shops)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
public interface ShopsDao extends BaseMapper<Shops> {

    @Select("select * from shops where id = #{id}")
    Shops findById(int id);

    @Select("select count(*) from shops")
    int count();

    @Delete("delete from shops where id = #{id}")
    boolean deleteById(int id);
}