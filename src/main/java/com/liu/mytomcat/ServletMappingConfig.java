package com.liu.mytomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置servlet的映射关系
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();

    static {
        servletMappingList.add(new ServletMapping("hello","/hello",HelloServlet.class));
    }
}
