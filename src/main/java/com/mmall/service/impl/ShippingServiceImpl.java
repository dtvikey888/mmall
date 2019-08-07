package com.mmall.service.impl;

import com.google.common.collect.Maps;
import com.mmall.common.ServerResponse;
import com.mmall.dao.ShippingMapper;
import com.mmall.pojo.Shipping;
import com.mmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * @Author: dtvikey
 * @Date: 01/08/19 上午 11:03
 * @Version 1.0
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    public ServerResponse add(Integer userId, Shipping shipping){

        shipping.setUserId(userId);
        int rowCount=shippingMapper.insert(shipping);
        if (rowCount>0){
            Map result = Maps.newHashMap();
            result.put("shippingId",shipping.getId());
            return ServerResponse.createBySuccess("新建地址成功",result);
        }

        return ServerResponse.createByErrorMessage("新建地址失败");

    }

    public ServerResponse del(Integer userId,Integer shippingId){
        int resultCount = shippingMapper.deleteByShippingIdUserId(userId,shippingId);
        if (resultCount>0){
            ServerResponse.createBySuccess("删除地址成功");
        }
        return ServerResponse.createByErrorMessage("删除地址失败");
    }


    public ServerResponse update(Integer userId, Shipping shipping){

        shipping.setUserId(userId);
        int rowCount=shippingMapper.insert(shipping);
        if (rowCount>0){
            return ServerResponse.createBySuccess("更新地址成功");
        }

        return ServerResponse.createByErrorMessage("更新地址失败");

    }

}