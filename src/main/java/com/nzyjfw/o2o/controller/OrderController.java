package com.nzyjfw.o2o.controller;

import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.dto.Result;
import com.nzyjfw.o2o.entity.Order;
import com.nzyjfw.o2o.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2020-03-04 16:41:05
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

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
        PageInfo<Order> orderList = orderService.selectAll(pageNum, pageSize);

        return Result.success("获取成功！", orderList);
    }

    /**
     * 查询
     *
     * @param id 编号
     * @return 查询结果
     */
    @GetMapping("/id")
    public Result getOne(String id) {
        Order order = orderService.findByOrderId(id);

        return Result.success("获取成功！", order);
    }

    /**
     * 查询
     *
     * @param userId 用户名
     * @return 查询结果
     */
    @GetMapping("/user")
    public Result getByUsername(int userId) {
        List<Order> orderList = orderService.findByUserId(userId);

        return Result.success("获取成功！", orderList);
    }

    /**
     * 查询总数
     *
     * @return 查询结果
     */
    @GetMapping("/count")
    public Result count() {
        int count = orderService.selectCount();
        return Result.success("获取成功！", count);
    }

    /**
     * 添加
     *
     * @param order 实体
     * @return 是否成功
     */
    @PostMapping("/add")
    public Result add(@RequestBody Order order) {
        boolean tag = orderService.add(order);
        if (tag) {
            return Result.success("添加成功！");
        } else {
            return Result.error("添加失败");
        }
    }

    /**
     * 取消订单
     *
     * @param orderId 订单编号
     * @return 是否成功
     */
    @PostMapping("/cancel")
    public Result cancel(String orderId) {
        boolean tag = orderService.cancel(orderId);
        if (tag) {
            return Result.success("取消成功！");
        } else {
            return Result.error("取消失败");
        }
    }

    /**
     * 更新订单状态
     *
     * @param order 实体
     * @return 是否成功
     */
    @PostMapping("/update")
    public Result update(@RequestBody Order order) {
        boolean tag = orderService.update(order);
        if (tag) {
            return Result.success("更新成功！");
        } else {
            return Result.error("更新失败");
        }
    }
}