package com.qingge.springboot.service;

import com.qingge.springboot.controller.dto.UserDTO;
import com.qingge.springboot.controller.dto.UserPasswordDTO;
import com.qingge.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 青哥哥
 * @since 2022-01-26
 */
public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);

    void updatePassword(UserPasswordDTO userPasswordDTO);
}
