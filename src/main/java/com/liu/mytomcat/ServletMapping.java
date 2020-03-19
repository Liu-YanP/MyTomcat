package com.liu.mytomcat;

public class ServletMapping {
    private String servletName;
    private String url;
    private Class clazz;

    public ServletMapping(String servletName,String url,Class clazz){
        this.servletName = servletName;
        this.clazz = clazz;
        this.url = url;
    }

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
