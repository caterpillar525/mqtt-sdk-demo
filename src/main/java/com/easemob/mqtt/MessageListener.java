package com.easemob.mqtt;

import java.util.List;

/**
 * 消息监听器
 *
 * @author vimin
 * @since 2021-08-09
 */
public interface MessageListener {
    /**
     * 接收消息处理方法
     *
     * @param messages 消息载体
     */
    void receive(List<MqttMessage> messages);
}
