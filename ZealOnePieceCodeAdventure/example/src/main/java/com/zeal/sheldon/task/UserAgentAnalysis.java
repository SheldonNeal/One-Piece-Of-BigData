package com.zeal.sheldon.task;

import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.runtime.util.EnvironmentInformation;

import com.zeal.sheldon.entity.TestRecord;

import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;



/**
 * @author zhangjiale <zjlsmiles@126.com>
 * @Description 第三方工具解析UA 测试 效率测试 准确性测试
 * Created on 2020-05-18
 */
public class UserAgentAnalysis {
    public static void main(String[] args) throws Exception {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<String> dataSet = env.readTextFile("/Users/zhangjiale/Desktop/aa").setParallelism(1);

        long start = System.currentTimeMillis();
        UserAgentAnalyzer uaa = UserAgentAnalyzer
                .newBuilder()
                .hideMatcherLoadStats()
                .withCache(10000)
                .build();
        dataSet.map(new MapFunction<String, String>() {
            @Override
            public String map(String s) throws Exception {
                String[] split = s.split("\t");
                String ua = split[0];
                String ua_device = split[1];
                String ua_browser = split[2];
                String ua_platform = split[3];
                String ua_browser_version = split[4];
                String ua_browser_major_version = split[5];
                String ua_browser_minor_version = split[6];
                String ua_os_version = split[7];
                String ua_os_major_version = split[8];
                String ua_os_minor_version = split[9];

                TestRecord testRecord = new TestRecord(ua, ua_device, ua_browser, ua_platform, ua_browser_version,
                        ua_browser_major_version,
                        ua_browser_minor_version, ua_os_version, ua_os_major_version, ua_os_minor_version);
//                TestRecord testRecord1 = parseUserAgent2(uaa, ua, testRecord);
                String userAgent = parseUserAgent(uaa, ua);
                return userAgent.toString();
            }
        }).print();//.writeAsText("/Users/zhangjiale/Desktop/t2");

        long end = System.currentTimeMillis();
        System.out.println(end -start);
//        env.execute();
    }

    /**
     * 格式化版本
     * 主要针对于详细版本和次版本
     * 详细版本：最多只保留3个数字
     * minor次版本：最多只保留2个数字
     * @param version
     * @return
     */
    public  static  String getFormatVersion (String version,int threshold){
        String[] split = version.split("\\.");
        int length = split.length>threshold? threshold:split.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(zeroIfEmpty(split[i])).append(".");
        }
        return sb.length() < 1 ? EnvironmentInformation.UNKNOWN : sb.substring(0, sb.length() - 1);
    }

    public static String zeroIfEmpty(String str){
        return StringUtils.isBlank(str) ? "0" : str;
    }


    private  static String parseUserAgent(UserAgentAnalyzer uaa,String agentStr){
        UserAgent agent = uaa.parse(agentStr);
        StringBuilder sb = new StringBuilder();
        sb.append(agentStr).append("\t")
        .append( agent.getValue("DeviceName")).append("\t")//ua_device
        .append(agent.getValue("AgentName")).append("\t")//ua_browser
        .append( agent.getValue("OperatingSystemName")).append("\t")//ua_platform
        .append(getFormatVersion(agent.getValue("AgentVersion"),3)).append("\t")//ua_browser_version
        .append(agent.getValue("AgentVersionMajor")).append("\t")//ua_browser_major_version
        .append(getFormatVersion(agent.getValue("AgentVersion"),2)).append("\t")//ua_browser_minor_version
        .append(getFormatVersion(agent.getValue("OperatingSystemVersion"),3)).append("\t")//ua_os_version
        .append(agent.getValue("OperatingSystemVersionMajor")).append("\t")//ua_os_major_version
        .append(getFormatVersion(agent.getValue("OperatingSystemVersion"),2)).append("\t");//ua_os_minor_version

        return sb.toString();
    }

    private  static TestRecord parseUserAgent2(UserAgentAnalyzer uaa,String agentStr,TestRecord testRecord){
        UserAgent agent = uaa.parse(agentStr);
        testRecord.setDeviceName( agent.getValue("DeviceName"));
        testRecord.setAgentName(agent.getValue("AgentName"));
        testRecord.setOperatingSystemName(agent.getValue("OperatingSystemName"));
        testRecord.setAgentVersion(getFormatVersion(agent.getValue("AgentVersion"),3));
        testRecord.setAgentVersionMajor(agent.getValue("AgentVersionMajor"));
        testRecord.setAgentVersionMinor(getFormatVersion(agent.getValue("AgentVersion"),2));
        testRecord.setOperatingSystemVersion(getFormatVersion(agent.getValue("OperatingSystemVersion"),3));
        testRecord.setOperatingSystemVersionMajor(agent.getValue("OperatingSystemVersionMajor"));
        testRecord.setOperatingSystemVersionMinor(getFormatVersion(agent.getValue("OperatingSystemVersion"),2));

        return testRecord;
    }
}
