package com.zeal.sheldon.task;

import java.util.Set;

import avro.shaded.com.google.common.collect.ImmutableSet;
import sun.net.util.IPAddressUtil;

/**
 * @Author zhangjiale<zjlsmiles@126.com>
 * @Description TODO
 * Created on 2020-05-26
 */
public class InternalIp {
    public static void main(String[] args) {
        String ip = "10.1.91.142";
        System.out.println("是否内网ip："+isInternalIp(ip)+"\t" + isInternalIP(ip));

        System.out.println(0xFFFFFFFF);

    }

    /**
     * 内网ip网段
     * (IDC)10.0.0.0/8：10.0.0.0～10.255.255.255
     * (IT)172.16.0.0/12：172.16.0.0～172.31.255.255
     * (IT)192.168.0.0/16：192.168.0.0～192.168.255.255
     * @param ip
     * @returns
     */
    private static boolean isInternalIp(String ip) {
        byte[] addr = IPAddressUtil.textToNumericFormatV4(ip);
        final byte b0 = addr[0];
        final byte b1 = addr[1];
        //10.x.x.x/8
        final byte SECTION_1 = 0x0A;
        //172.16.x.x/12
        final byte SECTION_2 = (byte) 0xAC;
        final byte SECTION_3 = (byte) 0x10;
        final byte SECTION_4 = (byte) 0x1F;
        //192.168.x.x/16
        final byte SECTION_5 = (byte) 0xC0;
        final byte SECTION_6 = (byte) 0xA8;
        switch (b0) {
            case SECTION_1:
                return true;
            case SECTION_2:
                if (b1 >= SECTION_3 && b1 <= SECTION_4) {
                    return true;
                }
            case SECTION_5:
                switch (b1) {
                    case SECTION_6:
                        return true;
                }
            default:
                return false;
        }
    }


    private static final Set<String> INTERNAL_CIDR = ImmutableSet.of("10.0.0.0/8", "172.16.0.0/12",
            "192.168.0.0/16");

    public static boolean isInternalIP(String ip) {
        try{
            return INTERNAL_CIDR.stream().anyMatch(x -> isOneOfCidr(ip, x));
        } catch (Exception e){
            return false;
        }
    }

    private static boolean isOneOfCidr(String ip, String cidr) {
        String[] ipSegments = ip.split("\\.");

        int ipNum = (Integer.parseInt(ipSegments[0]) << 24)
                | (Integer.parseInt(ipSegments[1]) << 16) | (Integer.parseInt(ipSegments[2]) << 8)
                | Integer.parseInt(ipSegments[3]);
        System.out.println(ipNum);
        int index = cidr.indexOf("/");
        if (index < 0 || index + 1 >= cidr.length()) {
            return false;
        }
        int type = Integer.parseInt(cidr.substring(index + 1));
        int mask = 0xFFFFFFFF << (32 - type);
        String cidrIp = cidr.substring(0, index);
        String[] cidrIpSegments = cidrIp.split("\\.");
        int cidrIpNum = (Integer.parseInt(cidrIpSegments[0]) << 24)
                | (Integer.parseInt(cidrIpSegments[1]) << 16)
                | (Integer.parseInt(cidrIpSegments[2]) << 8) | Integer.parseInt(cidrIpSegments[3]);

        return (ipNum & mask) == (cidrIpNum & mask);
    }
}
