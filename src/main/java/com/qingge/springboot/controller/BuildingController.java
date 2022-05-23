package com.qingge.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingge.springboot.common.Result;

import com.qingge.springboot.service.IBuildingService;
import com.qingge.springboot.entity.Building;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 青哥哥
 * @since 2022-05-23
 */
@RestController
@RequestMapping("/building")
public class BuildingController {

    @Resource
    private IBuildingService buildingService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Building building) {
        buildingService.saveOrUpdate(building);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        buildingService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        buildingService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(buildingService.list());
    }

    @GetMapping("/tree")
    public Result tree() {
        List<Building> list = buildingService.list();
        // 筛选出第一级
        List<Building> listLevel1 = list.stream().filter(building -> building.getPid() == null).collect(Collectors.toList());
        for (Building building : listLevel1) {
            Integer idLevel1 = building.getId();
            List<Building> listLevel2 = list.stream().filter(building2 -> idLevel1.equals(building2.getPid())).collect(Collectors.toList());
            building.setChildren(listLevel2);

            for (Building building2 : listLevel2) {
                Integer idLevel2 = building2.getId();
                List<Building> listLevel3 = list.stream().filter(building3 -> idLevel2.equals(building3.getPid())).collect(Collectors.toList());
                building2.setChildren(listLevel3);
            }
        }
        return Result.success(listLevel1);
    }

    @GetMapping("/house")
    public Result tree(@RequestParam String building, @RequestParam String unit, @RequestParam String house) {
        System.out.println(building);
        System.out.println(unit);
        System.out.println(house);
        // 构建查询条件
//        QueryWrapper<Building> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("", building);
//        queryWrapper.eq("", unit);
//        queryWrapper.eq("", house);

        // 查询
//        buildingService.list(queryWrapper);
        // 返回数据
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(buildingService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize) {
        QueryWrapper<Building> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(buildingService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

}

