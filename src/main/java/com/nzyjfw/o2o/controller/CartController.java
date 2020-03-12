package com.nzyjfw.o2o.controller;

import com.nzyjfw.o2o.dto.Result;
import com.nzyjfw.o2o.entity.GoodSet;
import com.nzyjfw.o2o.service.GoodSetService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ningyinqiang
 * @date 2020/3/5 20:30
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    /**
     * 服务对象
     */
    @Resource
    private GoodSetService goodSetService;

    /**
     * 查询用户购物车所有商品
     *
     * @param userId 用户ID
     * @return 列表
     */
    @GetMapping("/all")
    public Result all(int userId) {
        List<GoodSet> goodSetList = goodSetService.findByUserId(userId);

        return Result.success("获取成功！", goodSetList);
    }

    /**
     * 修改数量
     *
     * @param goodSet 实体
     * @return 是否成功
     */
    @PostMapping("/update")
    public Result update(@RequestBody GoodSet goodSet) {
        boolean tag = goodSetService.updateCart(goodSet);
        if (tag) {
            return Result.success("更新成功！");
        } else {
            return Result.error("更新失败！");
        }
    }

    /**
     * 加入购物车
     *
     * @param goodSet 实体
     * @return 是否成功
     */
    @PostMapping("/add")
    public Result add(@RequestBody GoodSet goodSet) {
        boolean tag = goodSetService.addCart(goodSet);
        if (tag) {
            return Result.success("添加成功！");
        } else {
            return Result.error("添加失败");
        }
    }

    /**
     * 删除
     *
     * @param goodSetList 需要删除的实体
     * @return 是否成功
     */
    @PostMapping("/delete")
    public Result delete(@RequestBody List<GoodSet> goodSetList) {
        boolean tag = goodSetService.deleteCart(goodSetList);
        if (tag) {
            return Result.success("删除成功！");
        } else {
            return Result.error("删除失败");
        }
    }
}
