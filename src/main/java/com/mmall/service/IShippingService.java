package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;

import javax.servlet.http.HttpSession;

/**
 * @Author: dtvikey
 * @Date: 01/08/19 上午 11:03
 * @Version 1.0
 */
public interface IShippingService {
    ServerResponse add(Integer userId, Shipping shipping);
    ServerResponse del(Integer userId,Integer shippingId);
}
