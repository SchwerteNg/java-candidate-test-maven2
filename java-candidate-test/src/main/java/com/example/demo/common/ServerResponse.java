package com.example.demo.common;


import java.io.Serializable;


public class ServerResponse<T> implements Serializable {

    private int status ;
    private String msg ;
    private T data ;

    private ServerResponse(int status){
        this.status = status ;
    }
    private ServerResponse(int status, T data){
        this.status = status ;
        this.data = data ;
    }
    private ServerResponse(int status, String msg, T data){
        this.status = status ;
        this.msg = msg ;
        this.data = data ;
    }
    private ServerResponse(int status, String msg){
        this.status = status ;
        this.msg = msg ;
    }

    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode() ;
    }

    public int getStatus(){
        return status ;
    }

    public T getdata() {
        return data;
    }

    public String getMsg() {
        return msg;
    }


    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> ServerResponse<T> createByErrorDetail(int errorcode,String msg,T data){
        return new ServerResponse<T>(errorcode,msg,data);
    }

    public static <T> ServerResponse<T> createByErrorMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }




}
