package com.shaw.demo.util;

import javax.servlet.http.HttpServletRequest;

public class BrowserUtil {

    public static String getBrowserInfo(HttpServletRequest request){
        String browserDetail = request.getHeader("User-Agent");
        String user = browserDetail.toLowerCase();

        String operationSystem = "";
        String browser = "";

        if(user.indexOf("windows") >= 0){
            operationSystem = "Windows";
        } else if(user.indexOf("mac") >= 0){
            operationSystem = "Mac";
        } else if(user.indexOf("x11") >= 0){
            operationSystem = "Unix";
        } else if(user.indexOf("linux") >= 0){
            operationSystem = "Linux";
        } else if(user.indexOf("android") >= 0){
            operationSystem = "Android";
        } else if(user.indexOf("iphone") >= 0){
            operationSystem = "IOS";
        } else{
            operationSystem = "Unknown" + user;
        }

        if(user.contains("chrome")){
            browser = "Google Chrome";
        }else if(user.contains("msie")){
            browser = "IE";
        }else if(user.contains("firefox")){
            browser = "FireFox";
        }
        return operationSystem + " " + browser;
    }
}
