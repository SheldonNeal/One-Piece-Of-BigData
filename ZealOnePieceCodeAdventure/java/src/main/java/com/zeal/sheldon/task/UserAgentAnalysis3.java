//package com.zeal.sheldon.task;
//
//
//import java.io.IOException;
//
//import ua_parser.Client;
//import ua_parser.Parser;
//
///**
// * @author yourname <zhangjiale@kuaishou.com>
// * Created on 2020-05-15
// */
//public class UserAgentAnalysis3 {
//    public static void main(String[] args) throws IOException {
//        String str ="Mozilla/5.0 (iPhone; CPU iPhone OS 13_3_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/39.0.2171.99 Mobile/15E148 Kwai/7.4.10.20555 /WKWebView WebViewType/WK NetType/WIFI Yoda/1.0.12 TitleHT/44 StatusHT/44";
//
//        long start = System.currentTimeMillis();
//
//        test3(str);
//        long end = System.currentTimeMillis();
//        System.out.println("***********************"+ (end -start));
//
//
//    }
//
//    public static void test3(String agentStr) throws IOException {
//        Parser parser = new Parser();
//        Client client = parser.parse(agentStr);
//        System.out.println("ua_browser: "+client.userAgent.family +"\n" +
//                "ua_browser_version: " +  client.userAgent.major +"," + client.userAgent.minor +"," + client.userAgent.patch +"\n" +
//                "ua_browser_major_version: " + client.userAgent.major+"\n" +
//                "ua_browser_minor_version: " + client.userAgent.major + "," +client.userAgent.minor +"\n" +
//                "ua_platform: " + client.os.family+"\n" +
//                "ua_os_version: "+ client.os.major +"," + client.os.minor +"," +  client.os.patch+"," + client.os.patchMinor +"\n" +
//                "ua_os_major_version: " + client.os.major +"\n" +
//                "ua_os_minor_version: " + client.os.major  +"," + client.os.minor   +"\n" +
//                "ua_device: " + client.device.family
//        );
//
//    }
//
//
//}
