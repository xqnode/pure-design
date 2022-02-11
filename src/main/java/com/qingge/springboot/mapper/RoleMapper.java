package com.qingge.springboot.mapper;

import com.qingge.springboot.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 青哥哥
 * @since 2022-02-10
 */
public interface RoleMapper extends BaseMapper<Role> {

    @Select("select id from sys_role where flag = #{flag}")
    Integer selectByFlag(@Param("flag") String flag);
}
