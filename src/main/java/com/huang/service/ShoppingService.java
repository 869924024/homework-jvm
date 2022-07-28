package com.huang.service;

import com.huang.pojo.Bread;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ShoppingService {
    //获取所有面包
    List<Bread> getAllBread();
    //获取还没过期面包
    List<Bread> getBread();
    // 获取过期面包
    List<Bread> getOverBread();

}
