//package com.zeal.sheldon.task;
//
//
//import java.io.IOException;
//
//import eu.bitwalker.useragentutils.Browser;
//import eu.bitwalker.useragentutils.OperatingSystem;
//import eu.bitwalker.useragentutils.UserAgent;
//
///**
// * @author yourname <zhangjiale@kuaishou.com>
// * Created on 2020-05-15
// */
//public class UserAgentAnalysis {
//    public static void main(String[] args) throws IOException {
//        String str ="Mozilla/5.0 (iPhone; CPU iPhone OS 13_3_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/39.0.2171.99 Mobile/15E148 Kwai/7.4.10.20555 /WKWebView WebViewType/WK NetType/WIFI Yoda/1.0.12 TitleHT/44 StatusHT/44";
//
//        long start = System.currentTimeMillis();
//        test1(str);
//
//        long end = System.currentTimeMillis();
//        System.out.println("***********************"+ (end -start));
//
//
//    }
//    public static void test1(String agentStr){
//                UserAgent userAgent = UserAgent.parseUserAgentString(agentStr);
//                Browser browser = userAgent.getBrowser();
//                OperatingSystem operatingSystem = userAgent.getOperatingSystem();
//
//                System.out.println(
//                        "浏览器名:"+browser.getName() +"\n" +
//                        "浏览器类型:"+browser.getBrowserType()+"\n" +
//                        "浏览器家族:"+browser.getGroup() +"\n" +
//                        "浏览器生产厂商:"+browser.getManufacturer() + "\n" +
//                        "浏览器使用的渲染引擎:"+browser.getRenderingEngine() + "\n" +
//                        "浏览器版本:"+browser.getVersion(agentStr)  + "\n" +
//                        "操作系统名:"+operatingSystem.getName() + "\n" +
//                        "访问设备类型:"+operatingSystem.getDeviceType() + "\n" +
//                        "操作系统家族:"+operatingSystem.getGroup() + "\n" +
//                        "操作系统生产厂商:"+operatingSystem.getManufacturer()) ;
//    }
//
//
//
//
//}
