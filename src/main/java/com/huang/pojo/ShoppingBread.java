package com.huang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hjj
 * @ClassName ShoppringBread
 * @description: 业务实体类
 * @datetime 2022年 07月 28日 14:13
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingBread {
    private long id;
    private long shoppingNumber;//购买数量
}
