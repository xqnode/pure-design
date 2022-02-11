package com.qingge.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_role_menu")
@Data
public class RoleMenu {

    private Integer roleId;
    private Integer menuId;

}
