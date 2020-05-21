package com.zeal.sheldon.task;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

/**
 * @author yourname <zhangjiale@kuaishou.com>
 * Created on 2020-05-15
 */
public class UserAgentAnalysis2 {

    public static void main(String[] args) throws FileNotFoundException {
        String path ="";

        String str ="Mozilla/5.0 (iPhone; CPU iPhone OS 13_3_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/39.0.2171.99 Mobile/15E148 Kwai/7.4.10.20555 /WKWebView WebViewType/WK NetType/WIFI Yoda/1.0.12 TitleHT/44 StatusHT/44";

        long start = System.currentTimeMillis();
        test2(str);

        long end = System.currentTimeMillis();
       // System.out.println("***********************"+ (end -start));
    }

    public static void test2(String agentStr){

        UserAgentAnalyzer uaa = UserAgentAnalyzer.newBuilder()
                .hideMatcherLoadStats()
                .withCache(10000)
                .build();
        UserAgent agent = uaa.parse(agentStr);
        System.out.println(agent.toJson());



    }


}
