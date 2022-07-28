package com.huang.service.Bread.vo;

import lombok.Data;

@Data
public class ResponseVo<T>{
    //返回状态 0-成功，1-业务失败，999-系统异常
    private int state;
    //返回信息
    private String msg;
    //返回数据实体
    private T date;

    public static<T> ResponseVo success(T m){
        ResponseVo responseVo=new ResponseVo();
        responseVo.setState(0);
        responseVo.setDate(m);
        return responseVo;
    }
    public static<T> ResponseVo serviceFail(String msg){
        ResponseVo responseVo=new ResponseVo();
        responseVo.setState(1);
        responseVo.setMsg(msg);
        return responseVo;
    }

}
