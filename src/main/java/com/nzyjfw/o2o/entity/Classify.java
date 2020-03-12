package com.nzyjfw.o2o.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * (Classify)实体类
 *
 * @author makejava
 * @since 2020-03-04 22:16:30
 */
@Data
public class Classify implements Serializable {
    private static final long serialVersionUID = -98364214981919912L;
    /**
     * 分类ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类描述
     */
    private String description;

}