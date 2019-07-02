package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

/**
 * @Author: dtvikey
 * @Date: 14/06/19 上午 10:36
 * @Version 1.0
 */
public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);
    ServerResponse<String> setSaleStatus(Integer productId,Integer status);
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);
    ServerResponse<PageInfo> getProductList(int pageNum,int pageSize);
    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);
}
