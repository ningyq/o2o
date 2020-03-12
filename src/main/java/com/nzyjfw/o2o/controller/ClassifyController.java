package com.nzyjfw.o2o.controller;

import com.github.pagehelper.PageInfo;
import com.nzyjfw.o2o.dto.Result;
import com.nzyjfw.o2o.entity.Classify;
import com.nzyjfw.o2o.service.ClassifyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Classify)表控制层
 *
 * @author makejava
 * @since 2020-03-04 16:41:04
 */
@RestController
@RequestMapping("/classify")
public class ClassifyController {
    /**
     * 服务对象
     */
    @Resource
    private ClassifyService classifyService;

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
        PageInfo<Classify> classifyList = classifyService.selectAll(pageNum, pageSize);

        return Result.success("获取成功！", classifyList);
    }

    /**
     * 查询
     *
     * @param id 页数
     * @return 查询结果
     */
    @GetMapping("/id")
    public Result getOne(int id) {
        Classify classify = classifyService.findById(id);

        return Result.success("获取成功！", classify);
    }

    /**
     * 添加
     *
     * @param classify 实体
     * @return 是否成功
     */
    @PostMapping("/add")
    public Result add(@RequestBody Classify classify) {
        boolean tag = classifyService.add(classify);
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
        boolean tag = classifyService.deleteById(id);
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
     * @param classify 实体
     * @return 是否成功
     */
    @PostMapping("/update")
    public Result update(@RequestBody Classify classify) {
        boolean tag = classifyService.update(classify);
        if (tag) {
            return Result.success("更新成功！");
        } else {
            return Result.error("更新失败");
        }
    }
}