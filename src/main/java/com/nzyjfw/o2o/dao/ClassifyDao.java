package com.nzyjfw.o2o.dao;

import com.nzyjfw.o2o.entity.Classify;
import com.nzyjfw.o2o.entity.Goods;
import com.nzyjfw.o2o.utils.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

/**
 * (Classify)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-04 16:41:02
 */
public interface ClassifyDao extends BaseMapper<Classify> {

    @Select("select * from classify where id = #{id}")
    Classify findById(int id);

    @Delete("delete from classify where id = #{id}")
    boolean deleteById(int id);
}