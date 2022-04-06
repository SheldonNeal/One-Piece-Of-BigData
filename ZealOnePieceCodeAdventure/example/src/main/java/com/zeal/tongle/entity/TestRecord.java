package com.zeal.tongle.entity;

/**
 * @authorTongle
 * Created on 2020-05-19
 */
public class TestRecord {

    String useragent;
    /**
     * Device
     */
    String deviceClass;
    String deviceName;//ua_device
    String deviceBrand;//
    /**
     * Operating System
     */
    String operatingSystemName;//ua_platform
    String operatingSystemClass;
    String operatingSystemVersion;//ua_os_version
    String operatingSystemVersionMajor;//ua_os_major_version
    String operatingSystemVersionMinor;//  ua_os_minor_version
    String operatingSystemNameVersion;
    String operatingSystemNameVersionMajor;
    String operatingSystemVersionBuild;

    /**
     *Agent
     */

    String agentClass;
    String agentName;//ua_browser
    String agentVersion;//ua_browser_version
    String agentVersionMajor;//ua_browser_major_version
    String agentVersionMinor;//ua_browser_minor_version
    String agentNameVersion;//
    String agentNameVersionMajor;

    /**
     *快手app
     */

    String webviewAppName;
    String webviewAppVersion;//app_minor_version
    String webviewAppVersionMajor ;//app_major_version
    String webviewAppNameVersionMajor;

    /**
     * old 解析字段
     */
    String  ua_device;
    String  ua_browser;
    String  ua_platform;
    String  ua_browser_version;
    String  app_minor_version;
    String  ua_browser_major_version;
    String ua_browser_minor_version;
    String ua_os_version;
    String ua_os_major_version;
    String ua_os_minor_version;
    public TestRecord() {
    }

    public TestRecord(String useragent) {
        this.useragent = useragent;
    }

    public TestRecord(String useragent, String ua_device, String ua_browser, String ua_platform,
            String ua_browser_version, String ua_browser_major_version,
            String ua_browser_minor_version, String ua_os_version, String ua_os_major_version,
            String ua_os_minor_version) {
        this.useragent = useragent;
        this.ua_device = ua_device;
        this.ua_browser = ua_browser;
        this.ua_platform = ua_platform;
        this.ua_browser_version = ua_browser_version;
        this.ua_browser_major_version = ua_browser_major_version;
        this.ua_browser_minor_version = ua_browser_minor_version;
        this.ua_os_version = ua_os_version;
        this.ua_os_major_version = ua_os_major_version;
        this.ua_os_minor_version = ua_os_minor_version;
    }

    @Override
    public String toString() {
        return 
                "" + useragent + "\t"
                + ifEquals(deviceName,ua_device) + '\t' +
                     ifEquals(agentName,ua_browser) + '\t' +
                     ifEquals(operatingSystemName,ua_platform) + '\t' +
                     ifEquals(agentVersion,ua_browser_version) +'\t' +
                     ifEquals(agentVersionMajor,ua_browser_major_version) +'\t' +
                     ifEquals(agentVersionMinor,ua_browser_minor_version) +'\t' +
                     ifEquals(operatingSystemVersion ,ua_os_version)+'\t' +
                     ifEquals(operatingSystemVersionMajor,ua_os_major_version) +'\t' +
                     ifEquals(operatingSystemVersionMinor,ua_os_minor_version)
                ;
    }

    public String ifEquals(String newValue,String oldValue){
        String flag = "1";
        String newValue2 = newValue.toLowerCase().replaceAll(" ","");
        String oldValue2 = oldValue.toLowerCase().replaceAll(" ","");
        if(!newValue2.equals(oldValue2) && !newValue2.contains(oldValue2)){
            flag = newValue + "--" + oldValue;
        }
        return flag;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    public String getDeviceClass() {
        return deviceClass;
    }

    public void setDeviceClass(String deviceClass) {
        this.deviceClass = deviceClass;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    public void setOperatingSystemName(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    public String getOperatingSystemClass() {
        return operatingSystemClass;
    }

    public void setOperatingSystemClass(String operatingSystemClass) {
        this.operatingSystemClass = operatingSystemClass;
    }

    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }

    public String getOperatingSystemVersionMajor() {
        return operatingSystemVersionMajor;
    }

    public void setOperatingSystemVersionMajor(String operatingSystemVersionMajor) {
        this.operatingSystemVersionMajor = operatingSystemVersionMajor;
    }

    public String getOperatingSystemVersionMinor() {
        return operatingSystemVersionMinor;
    }

    public void setOperatingSystemVersionMinor(String operatingSystemVersionMinor) {
        this.operatingSystemVersionMinor = operatingSystemVersionMinor;
    }

    public String getOperatingSystemNameVersion() {
        return operatingSystemNameVersion;
    }

    public void setOperatingSystemNameVersion(String operatingSystemNameVersion) {
        this.operatingSystemNameVersion = operatingSystemNameVersion;
    }

    public String getOperatingSystemNameVersionMajor() {
        return operatingSystemNameVersionMajor;
    }

    public void setOperatingSystemNameVersionMajor(String operatingSystemNameVersionMajor) {
        this.operatingSystemNameVersionMajor = operatingSystemNameVersionMajor;
    }

    public String getOperatingSystemVersionBuild() {
        return operatingSystemVersionBuild;
    }

    public void setOperatingSystemVersionBuild(String operatingSystemVersionBuild) {
        this.operatingSystemVersionBuild = operatingSystemVersionBuild;
    }

    public String getAgentClass() {
        return agentClass;
    }

    public void setAgentClass(String agentClass) {
        this.agentClass = agentClass;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentVersion() {
        return agentVersion;
    }

    public void setAgentVersion(String agentVersion) {
        this.agentVersion = agentVersion;
    }

    public String getAgentVersionMajor() {
        return agentVersionMajor;
    }

    public void setAgentVersionMajor(String agentVersionMajor) {
        this.agentVersionMajor = agentVersionMajor;
    }

    public String getAgentVersionMinor() {
        return agentVersionMinor;
    }

    public void setAgentVersionMinor(String agentVersionMinor) {
        this.agentVersionMinor = agentVersionMinor;
    }

    public String getAgentNameVersion() {
        return agentNameVersion;
    }

    public void setAgentNameVersion(String agentNameVersion) {
        this.agentNameVersion = agentNameVersion;
    }

    public String getAgentNameVersionMajor() {
        return agentNameVersionMajor;
    }

    public void setAgentNameVersionMajor(String agentNameVersionMajor) {
        this.agentNameVersionMajor = agentNameVersionMajor;
    }

    public String getWebviewAppName() {
        return webviewAppName;
    }

    public void setWebviewAppName(String webviewAppName) {
        this.webviewAppName = webviewAppName;
    }

    public String getWebviewAppVersion() {
        return webviewAppVersion;
    }

    public void setWebviewAppVersion(String webviewAppVersion) {
        this.webviewAppVersion = webviewAppVersion;
    }

    public String getWebviewAppVersionMajor() {
        return webviewAppVersionMajor;
    }

    public void setWebviewAppVersionMajor(String webviewAppVersionMajor) {
        this.webviewAppVersionMajor = webviewAppVersionMajor;
    }

    public String getWebviewAppNameVersionMajor() {
        return webviewAppNameVersionMajor;
    }

    public void setWebviewAppNameVersionMajor(String webviewAppNameVersionMajor) {
        this.webviewAppNameVersionMajor = webviewAppNameVersionMajor;
    }

    public String getUa_device() {
        return ua_device;
    }

    public void setUa_device(String ua_device) {
        this.ua_device = ua_device;
    }

    public String getUa_browser() {
        return ua_browser;
    }

    public void setUa_browser(String ua_browser) {
        this.ua_browser = ua_browser;
    }

    public String getUa_platform() {
        return ua_platform;
    }

    public void setUa_platform(String ua_platform) {
        this.ua_platform = ua_platform;
    }

    public String getUa_browser_version() {
        return ua_browser_version;
    }

    public void setUa_browser_version(String ua_browser_version) {
        this.ua_browser_version = ua_browser_version;
    }

    public String getApp_minor_version() {
        return app_minor_version;
    }

    public void setApp_minor_version(String app_minor_version) {
        this.app_minor_version = app_minor_version;
    }

    public String getUa_browser_major_version() {
        return ua_browser_major_version;
    }

    public void setUa_browser_major_version(String ua_browser_major_version) {
        this.ua_browser_major_version = ua_browser_major_version;
    }

    public String getUa_browser_minor_version() {
        return ua_browser_minor_version;
    }

    public void setUa_browser_minor_version(String ua_browser_minor_version) {
        this.ua_browser_minor_version = ua_browser_minor_version;
    }

    public String getUa_os_version() {
        return ua_os_version;
    }

    public void setUa_os_version(String ua_os_version) {
        this.ua_os_version = ua_os_version;
    }

    public String getUa_os_major_version() {
        return ua_os_major_version;
    }

    public void setUa_os_major_version(String ua_os_major_version) {
        this.ua_os_major_version = ua_os_major_version;
    }

    public String getUa_os_minor_version() {
        return ua_os_minor_version;
    }

    public void setUa_os_minor_version(String ua_os_minor_version) {
        this.ua_os_minor_version = ua_os_minor_version;
    }
}
