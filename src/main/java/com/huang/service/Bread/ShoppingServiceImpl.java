package com.huang.service.Bread;

import com.huang.mapper.BreadMapper;
import com.huang.pojo.Bread;
import com.huang.pojo.ShoppingBread;
import com.huang.service.Bread.vo.ShoppingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author hjj
 * @ClassName ShoppingServiceImpl
 * @description: TODO
 * @datetime 2022年 07月 28日 11:21
 * @version: 1.0
 */
@Service
public class ShoppingServiceImpl implements ShoppingService{
    @Autowired
    BreadMapper breadMapper;
    @Override
    public List<Bread> getAllBread() {
        Calendar calendar = Calendar.getInstance(); //伪造用户当前时间，真是业务使用系统时间判断
        calendar.set(2022,6,28,8,0,0);
        Date currentTime = calendar.getTime();
        List<Bread> allBreads = breadMapper.getAllBreads();
        for (Bread bread:allBreads) {
            int dif = Math.abs((int) ((currentTime.getTime() - bread.getManufactureTime().getTime()) / (1000 * 3600 * 24)));
            if (dif>=bread.getQualityDay()) {  //判断过期
               // System.out.println("过期"+(dif-bread.getQualityDay())+"天的商品当前的状态:"+bread); //0为当天
                switch (bread.getType()) {
                    case 1: {//有肉面包过期，销毁
                        allBreads.remove(bread);
                        break;
                    }
                    case 2:{ //全面面包过期当天可以半价出售
                        if (dif-bread.getQualityDay()>=1){
                            allBreads.remove(bread);
                        }else{
                            bread.setPrice(bread.getPrice()/2);
                        }
                        break;
                    }
                    case 3:{ //杂粮面包,过期当天的早上7:00-9:00免费领取
                        if (dif-bread.getQualityDay()==0&&currentTime.getHours()>=7&&currentTime.getHours()<9){
                            bread.setPrice(0);
                        }else{
                            allBreads.remove(bread);
                        }
                        break;
                    }
                }
            }
        }
        return allBreads;
    }

    @Override
    public List<Bread> getOverBread() {
        Calendar calendar = Calendar.getInstance(); //伪造用户当前时间，真是业务使用系统时间判断
        calendar.set(2022,6,28,8,0,0);
        Date currentTime = calendar.getTime();
        List<Bread> overBreads = breadMapper.getOverBreads();
        for (Bread bread:overBreads) {
            int dif = Math.abs((int) ((currentTime.getTime() - bread.getManufactureTime().getTime()) / (1000 * 3600 * 24)));
            if (dif>=bread.getQualityDay()) {  //判断过期
                // System.out.println("过期"+(dif-bread.getQualityDay())+"天的商品当前的状态:"+bread); //0为当天
                switch (bread.getType()) {
                    case 1: {//有肉面包过期，销毁
                        overBreads.remove(bread);
                        break;
                    }
                    case 2:{ //全面面包过期当天可以半价出售
                        if (dif-bread.getQualityDay()>=1){
                            overBreads.remove(bread);
                        }else{
                            bread.setPrice(bread.getPrice()/2);
                        }
                        break;
                    }
                    case 3:{ //杂粮面包,过期当天的早上7:00-9:00免费领取
                        if (dif-bread.getQualityDay()==0&&currentTime.getHours()>=7&&currentTime.getHours()<9){
                            bread.setPrice(0);
                        }else{
                            overBreads.remove(bread);
                        }
                        break;
                    }
                }
            }
        }
        return overBreads;
    }

    @Override
    public boolean isTrueBread(List<ShoppingBread> breads) {
        List<Bread> allBread = getAllBread();
        for (ShoppingBread shoppingBread:breads) {
            boolean flag=true;
            for (Bread bread:allBread) {
                if (shoppingBread.getId()==bread.getId()){
                    flag=false;
                    if (shoppingBread.getShoppingNumber() > bread.getNumber()) {
                        System.out.println("购买数量不符!");
                        return false;
                    }
                }
            }
            if (flag) {
                System.out.println("选择面包出错!");
                return false;
            }
        }
        return true;
    }

    @Override
    public ShoppingVo shoppingBraed(List<ShoppingBread> breads) {
        ShoppingVo shoppingVo = new ShoppingVo();
        List<Bread> allBread = getAllBread();
        for (ShoppingBread shoppingBread:breads) {
            for (Bread bread:allBread) {
                if (shoppingBread.getId()==bread.getId()){
                    shoppingVo.setSunPrime(shoppingVo.getSunPrime()+getTotalPrice(shoppingBread.getShoppingNumber(),bread.getPrice()));
                }
            }
        }
        return shoppingVo; //返回业务实体前端可以转json
    }

    private static double getTotalPrice(long nums, double price) {
        BigDecimal numsDeci = new BigDecimal(nums);
        BigDecimal PriceDeci = new BigDecimal(price);

        BigDecimal result = numsDeci.multiply(PriceDeci);

        // 四舍五入，取小数点后两位
        BigDecimal bigDecimal = result.setScale(2, RoundingMode.HALF_UP);

        return bigDecimal.doubleValue();
    }
}
