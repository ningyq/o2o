package com.nzyjfw.o2o.controller;

import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.dto.Result;
import com.nzyjfw.o2o.entity.Goods;
import com.nzyjfw.o2o.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Goods)表控制层
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

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
        PageInfo<Goods> goodList = goodsService.selectAll(pageNum, pageSize);

        return Result.success("获取成功！", goodList);
    }

    /**
     * 查询
     *
     * @param id 商品ID
     * @return 查询结果
     */
    @GetMapping("/id")
    public Result getOne(int id) {
        Goods goods = goodsService.findById(id);

        return Result.success("获取成功！", goods);
    }

    /**
     * 查询
     *
     * @param classifyName 分类名
     * @return 查询结果
     */
    @GetMapping("/classify")
    public Result getByClassifyName(String classifyName) {
        List<Goods> goodsList = goodsService.findByClassify(classifyName);

        return Result.success("获取成功！", goodsList);
    }

    /**
     * 查询
     *
     * @param name 分类名
     * @return 查询结果
     */
    @GetMapping("/name")
    public Result getByName(String name) {
        List<Goods> goodsList = goodsService.findByName(name);

        return Result.success("获取成功！", goodsList);
    }

    /**
     * 查询库存大于0的商品
     *
     * @return 查询结果
     */
    @GetMapping("/stock")
    public Result getByStock() {
        List<Goods> goodsList = goodsService.findByStock();

        return Result.success("获取成功！", goodsList);
    }

    /**
     * 查询总数
     *
     * @return 查询结果
     */
    @GetMapping("/count")
    public Result count() {
        int count = goodsService.selectCount();
        return Result.success("获取成功！", count);
    }

    /**
     * 添加
     *
     * @param goods 实体
     * @return 是否成功
     */
    @PostMapping("/add")
    public Result add(@RequestBody Goods goods) {
        boolean tag = goodsService.add(goods);
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
        boolean tag = goodsService.deleteById(id);
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
     * @param goods 实体
     * @return 是否成功
     */
    @PostMapping("/update")
    public Result update(@RequestBody Goods goods) {
        boolean tag = goodsService.update(goods);
        if (tag) {
            return Result.success("更新成功！");
        } else {
            return Result.error("更新失败");
        }
    }
}