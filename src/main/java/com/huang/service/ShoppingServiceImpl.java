package com.huang.service;

import com.huang.mapper.ShoppingMapper;
import com.huang.pojo.Bread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    ShoppingMapper shoppingMapper;
    @Override
    public List<Bread> getAllBread() {
        return shoppingMapper.getAllBreads();
    }

    @Override
    public List<Bread> getBread() {
        return shoppingMapper.getBreads();
    }

    @Override
    public List<Bread> getOverBread() {
        return shoppingMapper.getOverBreads();
    }
}
