package com.qingge.springboot.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qingge.springboot.entity.Menu;
import com.qingge.springboot.mapper.MenuMapper;
import com.qingge.springboot.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 青哥哥
 * @since 2022-02-10
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public List<Menu> findMenus(String name) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort_num");
        if (StrUtil.isNotBlank(name)) {
            queryWrapper.like("name", name);
        }
        // 查询所有数据
        List<Menu> list = list(queryWrapper);
        // 找出pid为null的一级菜单
        List<Menu> parentNodes = list.stream().filter(menu -> menu.getPid() == null).collect(Collectors.toList());
        // 找出一级菜单的子菜单
        for (Menu menu : parentNodes) {
            // 筛选所有数据中pid=父级id的数据就是二级菜单
            menu.setChildren(list.stream().filter(m -> menu.getId().equals(m.getPid())).collect(Collectors.toList()));
        }
        return parentNodes;
    }
}
