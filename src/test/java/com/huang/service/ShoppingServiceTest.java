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
 * @datetime 2022�� 07�� 28�� 13:19
 * @version: 1.0
 */
@SpringBootTest
public class ShoppingServiceTest {
    @Autowired
    ShoppingService shoppingService;

    @Test
    public void getAllBreadTest(){  //��ѯ���пɹ����
        List<Bread> allBread = shoppingService.getAllBread();
        System.out.println("Bread on sale:");
        for (Bread bread:allBread) {
            System.out.println(bread);
        }
    }

    @Test
    public void isTrueBread(){ //�жϴ�������Ƿ����㹺������(id�Ƿ���ͬ�������Ƿ��㹻)
        //�����ģ�id-������ȷ�ģ�
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

        //id�����ڵ�
//        LinkedList<ShoppingBread> shoppingBreads = new LinkedList<>();
//        ShoppingBread bread1=new ShoppingBread();
//        bread1.setId(10);
//        bread1.setShoppingNumber(10);
//        shoppingBreads.add(bread1);
//        System.out.println(shoppingService.isTrueBread(shoppingBreads));

        //���������
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
        ShoppingBread bread2=new ShoppingBread();  //���ڵ���Ӧ�ð��(3*6=18)
        bread2.setId(4);
        bread2.setShoppingNumber(3);
        shoppingBreads.add(bread2);
        ShoppingBread bread3=new ShoppingBread(); //���ڵ���7-9��Ӧ��0Ԫ���(0*5=0)
        bread3.setId(5);
        bread3.setShoppingNumber(5);
        shoppingBreads.add(bread3);
        System.out.println(shoppingService.shoppingBraed(shoppingBreads));
    }
}
