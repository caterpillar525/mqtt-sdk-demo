package com.easemob.mqtt;

/**
 * 公共配置类
 *
 * @author vimin
 * @since 2021-08-09
 */
public class Config {
    /**
     * Client ID，console后台获取
     */
    private String appClientId;
    /**
     * ClientSecret，console后台获取
     */
    private String appClientSecret;
    /**
     * REST API地址，console后台->mqtt服务概览获取
     */
    private String restApi;

    public Config setAppClientId(String appClientId) {
        this.appClientId = appClientId;
        return this;
    }

    public Config setAppClientSecret(String appClientSecret) {
        this.appClientSecret = appClientSecret;
        return this;
    }

    public Config setRestApi(String restApi) {
        this.restApi = restApi;
        return this;
    }

    public String getAppClientId() {
        return appClientId;
    }

    public String getAppClientSecret() {
        return appClientSecret;
    }

    public String getRestApi() {
        return restApi;
    }
}
