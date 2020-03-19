package com.liu.mytomcat;

import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {
    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    /**
     * 将返回内容按照http返回协议，写入输出流
     * @param content 返回的内容
     */
    public void write(String content) throws IOException {
//        http返回协议
//        http/1.1 200 OK
//        content-Type:text/html

//        <html><body></body></html>
        StringBuffer httpResponse = new StringBuffer();
        httpResponse.append("HTTP/1.1 200 OK\n")
                .append("content-Type:text/html;charset=UTF-8\n").append("\n")   //需要设置返回内容的编码
                .append("<html><body>\n")
                .append(content)
                .append("</body></html>\n");

        this.outputStream.write(httpResponse.toString().getBytes("utf-8"));
        outputStream.close();
    }
}
