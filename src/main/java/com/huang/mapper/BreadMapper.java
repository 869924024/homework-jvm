package com.huang.mapper;

import com.huang.pojo.Bread;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hjj
 * @ClassName Shopingmapper
 * @description: 直接实现dao，伪造数据，不查询数据库
 * @datetime 2022年 07月 28日 11:20
 * @version: 1.0
 */
@Repository
public class BreadMapper {
    //伪装查询所有面包
    public List<Bread> getAllBreads(){
        Calendar calendar = Calendar.getInstance();
        LinkedList<Bread> breads = new LinkedList<>();
        //伪造还没过期面包(时间设定是2022/7/28)
        calendar.set(2022,6,28,7,00,01);
        breads.add(new Bread(1,"全麦面包",12,10,2,2,calendar.getTime()));
        breads.add(new Bread(2,"杂粮面包",10,10,3,3,calendar.getTime()));
        breads.add(new Bread(3,"金枪鱼三明治",12,10,1,1,calendar.getTime()));
        //伪造过期面包
        calendar.set(2022,6,26,7,00,00);
        breads.add(new Bread(4,"全麦面包",12,5,2,2,calendar.getTime()));
        calendar.set(2022,6,25,7,00,00);
        breads.add(new Bread(5,"杂粮面包",10,5,3,3,calendar.getTime()));
        calendar.set(2022,6,27,7,00,00);
        breads.add(new Bread(6,"金枪鱼三明治",12,5,1,1,calendar.getTime()));
        return breads;
    }
    //伪装查询没过期面包
    public List<Bread> getBreads(){
        Calendar calendar = Calendar.getInstance();
        LinkedList<Bread> breads = new LinkedList<>();
        //伪造还没过期面包
        calendar.set(2022,6,28,7,00,00);
        breads.add(new Bread(1,"全麦面包",12,10,2,2,calendar.getTime()));
        breads.add(new Bread(2,"杂粮面包",10,10,3,3,calendar.getTime()));
        breads.add(new Bread(3,"金枪鱼三明治",12,10,1,1,calendar.getTime()));
        return breads;
    }
    //伪装查询过期面包
    public List<Bread> getOverBreads(){
        Calendar calendar = Calendar.getInstance();
        LinkedList<Bread> breads = new LinkedList<>();
        //伪造过期面包
        calendar.set(2022,6,26,7,00,00);
        breads.add(new Bread(4,"全麦面包",12,5,2,2,calendar.getTime()));
        calendar.set(2022,6,25,7,00,00);
        breads.add(new Bread(5,"杂粮面包",10,5,3,3,calendar.getTime()));
        calendar.set(2022,6,27,7,00,00);
        breads.add(new Bread(6,"金枪鱼三明治",12,5,1,1,calendar.getTime()));
        return breads;
    }
}
