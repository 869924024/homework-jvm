package com.huang.controller;

import com.huang.pojo.ShoppingBread;
import com.huang.service.ShoppingService;
import com.huang.service.vo.ResponseVo;
import com.huang.service.vo.ShoppingVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hjj
 * @ClassName ShoppingContoller
 * @description: TODO
 * @datetime 2022年 07月 28日 14:45
 * @version: 1.0
 */
public class ShoppingContoller {
    @Autowired
    ShoppingService shoppingService;

    public ResponseVo shoppingBread(List<ShoppingBread> breads){
        //判断输入的参数是否正确
        boolean trueBread = shoppingService.isTrueBread(breads);
        if (!trueBread){
            return ResponseVo.serviceFail("面包或数量不正确！");
        }
        ShoppingVo shoppingVo = shoppingService.shoppingBraed(breads);
        if (shoppingVo == null) {
            return ResponseVo.serviceFail("购买业务异常");
        }
        return ResponseVo.success(shoppingVo);
    }
}
