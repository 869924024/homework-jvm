package com.huang.service;

import com.huang.pojo.Bread;
import com.huang.pojo.ShoppingBread;
import com.huang.service.vo.ShoppingVo;

import java.util.List;


public interface ShoppingService {
    //获取所有面包(过期面包按照过期规则处理)
    List<Bread> getAllBread();
    //判断购买的面包id是否符合
    boolean isTrueBread(List<ShoppingBread> breads);
    //购买面包
    ShoppingVo shoppingBraed(List<ShoppingBread> breads);
}
