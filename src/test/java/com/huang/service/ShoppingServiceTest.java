package com.huang.service;

import com.huang.pojo.Bread;
import com.huang.pojo.ShoppingBread;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hjj
 * @ClassName ShoppingServiceTest
 * @description: TODO
 * @datetime 2022年 07月 28日 13:19
 * @version: 1.0
 */
@SpringBootTest
public class ShoppingServiceTest {
    @Autowired
    ShoppingService shoppingService;

    @Test
    public void getAllBreadTest(){  //查询所有可购面包
        List<Bread> allBread = shoppingService.getAllBread();
        System.out.println("Bread on sale:");
        for (Bread bread:allBread) {
            System.out.println(bread);
        }
    }

    @Test
    public void isTrueBread(){ //判断传入参数是否满足购买条件(id是否相同、数量是否足够)
        //正常的（id-数量正确的）
//        LinkedList<ShoppingBread> shoppingBreads = new LinkedList<>();
//        ShoppingBread bread1=new ShoppingBread();
//        bread1.setId(1);
//        bread1.setShoppingNumber(10);
//        shoppingBreads.add(bread1);
//        ShoppingBread bread2=new ShoppingBread();
//        bread2.setId(2);
//        bread2.setShoppingNumber(10);
//        shoppingBreads.add(bread2);
//        ShoppingBread bread3=new ShoppingBread();
//        bread3.setId(3);
//        bread3.setShoppingNumber(10);
//        ShoppingBread bread4=new ShoppingBread();
//        bread4.setId(4);
//        bread4.setShoppingNumber(5);
//        shoppingBreads.add(bread4);
//        ShoppingBread bread5=new ShoppingBread();
//        bread5.setId(5);
//        bread5.setShoppingNumber(5);
//        shoppingBreads.add(bread5);
//        System.out.println(shoppingService.isTrueBread(shoppingBreads));

        //id不存在的
//        LinkedList<ShoppingBread> shoppingBreads = new LinkedList<>();
//        ShoppingBread bread1=new ShoppingBread();
//        bread1.setId(10);
//        bread1.setShoppingNumber(10);
//        shoppingBreads.add(bread1);
//        System.out.println(shoppingService.isTrueBread(shoppingBreads));

        //数量不足的
        LinkedList<ShoppingBread> shoppingBreads = new LinkedList<>();
        ShoppingBread bread1=new ShoppingBread();
        bread1.setId(1);
        bread1.setShoppingNumber(100);
        shoppingBreads.add(bread1);
        System.out.println(shoppingService.isTrueBread(shoppingBreads));
    }
    @Test
    public void shoppingBraedTest(){
        LinkedList<ShoppingBread> shoppingBreads = new LinkedList<>();
        ShoppingBread bread1=new ShoppingBread(); //(1*12=12)
        bread1.setId(1);
        bread1.setShoppingNumber(1);
        shoppingBreads.add(bread1);
        ShoppingBread bread2=new ShoppingBread();  //过期当天应该半价(3*6=18)
        bread2.setId(4);
        bread2.setShoppingNumber(3);
        shoppingBreads.add(bread2);
        ShoppingBread bread3=new ShoppingBread(); //过期当天7-9点应该0元免费(0*5=0)
        bread3.setId(5);
        bread3.setShoppingNumber(5);
        shoppingBreads.add(bread3);
        System.out.println(shoppingService.shoppingBraed(shoppingBreads));
    }
}
