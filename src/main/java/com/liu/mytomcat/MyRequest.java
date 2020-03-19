package com.liu.mytomcat;


import java.io.IOException;
import java.io.InputStream;

/**
 * 根据http协议的格式，提取出url以及请求方法
 */
public class MyRequest {
    public String url;
    public String method;

    public String getUrl() {
        return url;
    }


    public String getMethod() {
        return method;
    }


    //构造方法
    public MyRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if ((length=inputStream.read(httpRequestBytes))>0){
            httpRequest = new String(httpRequestBytes,0,length);
        }

//        http请求协议
//        GET /url HTTP/1.1
//        Accept: */*
//        Accept-Encoding:utf-8
//        User- Agent:Mozila/5.0(windows NT 6.1)
//        Host:localhost
//        Connection:Keep-Alive
        String httpHead = httpRequest.split("\n")[0]; //获取第一行请求头
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
        System.out.println(this);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MyRequest{");
        sb.append("url='").append(url).append('\'');
        sb.append(", method='").append(method).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
