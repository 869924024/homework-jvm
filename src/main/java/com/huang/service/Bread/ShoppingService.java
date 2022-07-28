package com.huang.service.Bread;

import com.huang.pojo.Bread;
import com.huang.pojo.ShoppingBread;
import com.huang.service.Bread.vo.ShoppingVo;

import java.util.List;


public interface ShoppingService {
    //获取所有面包(过期面包按照过期规则处理)
    List<Bread> getAllBread();
    //获取过期面包
    List<Bread> getOverBread();
    //判断购买的面包id是否符合
    boolean isTrueBread(List<ShoppingBread> breads);
    //购买面包
    ShoppingVo shoppingBraed(List<ShoppingBread> breads);
}
