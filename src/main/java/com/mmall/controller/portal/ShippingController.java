package com.mmall.controller.portal;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;
import com.mmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

/**
 * @Author: dtvikey
 * @Date: 01/08/19 上午 11:02
 * @Version 1.0
 */
@Controller
@RequestMapping("/shipping/")
public class ShippingController {

    @Autowired
    private IShippingService iShippingService;

    public ServerResponse add(HttpSession session, Shipping shipping){

    }

}
