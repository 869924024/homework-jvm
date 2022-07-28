package com.huang.mapper;

import com.huang.pojo.Bread;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author hjj
 * @ClassName getBreadMapper
 * @description: TODO
 * @datetime 2022年 07月 28日 12:42
 * @version: 1.0
 */
@SpringBootTest
public class BreadMapperTest {

    @Autowired
    BreadMapper mapper;

    @Test
    public void getBread(){
        System.out.println("notOverBread：");
        List<Bread> breads = mapper.getBreads();
        for (Bread bread:breads) {
            System.out.println(bread);
        }
    }
    @Test
    public void getAllBread(){
        System.out.println("AllBread：");
        List<Bread> allBreads = mapper.getAllBreads();
        for (Bread bread:allBreads) {
            System.out.println(bread);
        }
    }
    @Test
    public void overBread(){
        System.out.println("overBread过期面包：");
        List<Bread> overBreads = mapper.getOverBreads();
        for (Bread bread:overBreads) {
            System.out.println(bread);
        }
    }
}
