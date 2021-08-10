package com.easemob.mqtt;

import lombok.Data;

/**
 * mqtt消息载体
 *
 * @author vimin
 * @since 2021-08-09
 */
@Data
public class MqttMessage {
    /**
     * 主题名称
     */
    private String topic;

    /**
     * 客户端ID
     */
    private String clientid;

    /**
     * 消息体
     */
    private String payload;

    /**
     * 消息编码
     */
    private String encoding;

    /**
     * 是否保留消息
     */
    private int retain;
    /**
     * 消息最大保留时间
     */
    private Integer expire;

    /**
     * 6位数appID
     */
    private String appid;

    /**
     * 消息qos等级，默认0
     */
    private int qos;
}
