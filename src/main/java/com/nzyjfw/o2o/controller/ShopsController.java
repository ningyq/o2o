package com.nzyjfw.o2o.controller;

import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.dto.Result;
import com.nzyjfw.o2o.entity.Shops;
import com.nzyjfw.o2o.service.ShopsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Shops)表控制层
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
@RestController
@RequestMapping("/shops")
public class ShopsController {
    /**
     * 服务对象
     */
    @Resource
    private ShopsService shopsService;

    /**
     * 查询所有
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 查询结果
     */
    @GetMapping("/all")
    public Result all(@RequestParam(defaultValue = "0") int pageNum,
                      @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Shops> shopList = shopsService.selectAll(pageNum, pageSize);

        return Result.success("获取成功！", shopList);
    }

    /**
     * 查询
     *
     * @param id ID
     * @return 查询结果
     */
    @GetMapping("/id")
    public Result getOne(int id) {
        Shops shops = shopsService.findById(id);

        return Result.success("获取成功！", shops);
    }

    /**
     * 查询总数
     *
     * @return 查询结果
     */
    @GetMapping("/count")
    public Result count() {
        int count = shopsService.selectCount();
        return Result.success("获取成功！", count);
    }

    /**
     * 添加
     *
     * @param shops 实体
     * @return 是否成功
     */
    @PostMapping("/add")
    public Result add(@RequestBody Shops shops) {
        boolean tag = shopsService.add(shops);
        if (tag) {
            return Result.success("添加成功！");
        } else {
            return Result.error("添加失败");
        }
    }

    /**
     * 删除
     *
     * @param id 实体ID
     * @return 是否成功
     */
    @PostMapping("/delete")
    public Result delete(int id) {
        boolean tag = shopsService.deleteById(id);
        ;
        if (tag) {
            return Result.success("删除成功！");
        } else {
            return Result.error("删除失败");
        }
    }

    /**
     * 更新
     *
     * @param shops 实体
     * @return 是否成功
     */
    @PostMapping("/update")
    public Result update(@RequestBody Shops shops) {
        boolean tag = shopsService.update(shops);
        if (tag) {
            return Result.success("更新成功！");
        } else {
            return Result.error("更新失败");
        }
    }

}