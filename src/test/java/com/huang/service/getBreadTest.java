package com.huang.service;

import com.huang.pojo.Bread;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author hjj
 * @ClassName getBreadTest
 * @description: TODO
 * @datetime 2022年 07月 28日 11:42
 * @version: 1.0
 */
@SpringBootTest
public class getBreadTest {
    @Autowired
    ShoppingService shoppingService;

    @Test
    public void getBread(){
        System.out.println("AllBread：");
        List<Bread> allBread = shoppingService.getAllBread();
        for (Bread bread:allBread) {
            System.out.println(bread);
        }
        System.out.println("notOverBread：");
        List<Bread> breads = shoppingService.getBread();
        for (Bread bread:breads) {
            System.out.println(bread);
        }
        System.out.println("overBread过期面包：");
        List<Bread> overBreads = shoppingService.getOverBread();
        for (Bread bread:overBreads) {
            System.out.println(bread);
        }
    }
}
