package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * @Author: dtvikey
 * @Date: 05/06/19 上午 08:48
 * @Version 1.0
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);

}
