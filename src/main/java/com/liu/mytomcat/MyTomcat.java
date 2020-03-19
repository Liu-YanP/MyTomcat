package com.liu.mytomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MyTomcat {
    private int port = 8080;
    private Map<String,Class> urlServletMap = new HashMap<String, Class>();

    public MyTomcat(){}

    public MyTomcat(int port){
        this.port = port;
    }

    public void start(){
        initServletMapping();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("MyTomcat is startr......");
            while (true){
                Socket socket = serverSocket.accept();//监听端口
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);

                dispathch(myRequest,myResponse);

                socket.close();

            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private void dispathch(MyRequest myRequest, MyResponse myResponse) {
        Class clazz = urlServletMap.get(myRequest.getUrl());
        if (clazz!=null){
            try {
                MyServlet myServlet = (MyServlet) clazz.newInstance();
                myServlet.service(myRequest,myResponse);
            } catch (InstantiationException e){
                e.printStackTrace();
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }else {
            System.out.println(myRequest.getUrl()+"未找到该资源！");

        }
    }

    private void initServletMapping() {
        for (ServletMapping servletMapping:ServletMappingConfig.servletMappingList){
            urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }

     public static void main(String[] args) {
        new MyTomcat().start();
    }
}
