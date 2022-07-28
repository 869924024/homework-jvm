package com.huang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @author hjj
 * @ClassName Bread
 * @description: TODO
 * @datetime 2022年 07月 28日 10:59
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bread {
    private long id;
    private String name;
    private double price;
    private long number;
    private int type; //1-有肉 2-全面 3-杂粮
    private long qualityDay;
    private Date manufacture;
}
