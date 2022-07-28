package com.huang.controller;

import com.huang.pojo.ShoppingBread;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

/**
 * @author hjj
 * @ClassName ShoppingContollerTest
 * @description: TODO
 * @datetime 2022�� 07�� 28�� 16:28
 * @version: 1.0
 */
@SpringBootTest
public class ShoppingContollerTest {
    @Autowired
    ShoppingContoller shoppingContoller;
    @Test
    public void shoppingBreadTest(){
        LinkedList<ShoppingBread> shoppingBreads = new LinkedList<>();
        ShoppingBread bread1=new ShoppingBread(); //(1*12=12)
        bread1.setId(1);
        bread1.setShoppingNumber(1);
        shoppingBreads.add(bread1);
        ShoppingBread bread2=new ShoppingBread();  //���ڵ���Ӧ�ð��(3*6=18)
        bread2.setId(4);
        bread2.setShoppingNumber(3);
        shoppingBreads.add(bread2);
        ShoppingBread bread3=new ShoppingBread(); //���ڵ���7-9��Ӧ��0Ԫ���(0*5=0)
        bread3.setId(5);
        bread3.setShoppingNumber(5);
        shoppingBreads.add(bread3);
        System.out.println(shoppingContoller.shoppingBread(shoppingBreads));
    }
}
