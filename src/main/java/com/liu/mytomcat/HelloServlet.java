package com.liu.mytomcat;

import java.io.IOException;

public class HelloServlet extends MyServlet {

    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("这是get方法的Hello page");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("这是post方法的Hello page");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
