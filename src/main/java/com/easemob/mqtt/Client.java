package com.easemob.mqtt;

import java.util.List;

/**
 * SDK客户端，负责从MQTT后台接收消息
 *
 * @author vimin
 * @since 2021-08-09
 */
public class Client extends Thread {
    private MessageListener listener;
    private String[] topics;
    private volatile boolean shutdown;
    private MessageClient messageClient;
    private Config config;
    /**
     * 启动线程个数
     */
    private int threadsCount;

    public Client(Config config) {
        this.config = config;
    }

    /**
     * 生命周期初始化方法
     */
    private void init() {
        this.shutdown = false;
        this.messageClient = new MessageClient();
        if (this.threadsCount == 0) {
            this.threadsCount = 1;
        }
    }

    /**
     * 设置消息监听器，每次来消息都会触发消息回调
     *
     * @param listener 监听器类
     */
    public void setListener(MessageListener listener) {
        this.listener = listener;
    }

    /**
     * 订阅主题列表
     *
     * @param topics 主题列表
     */
    public void subscribe(String... topics) {
        this.topics = topics;
        System.out.println("subscribe a topic -> " + topics);
    }

    public void setThreadsCount(int threadsCount) {
        this.threadsCount = threadsCount;
    }

    /**
     * 调用消息客户端方法获取消息
     */
    private List<MqttMessage> receiveMessage() {
        //有消息继续运行，没有消息阻塞线程
        List<MqttMessage> messages = this.messageClient.pollMessage(this.topics);
        return messages;
    }

    public void shutdown() {
        this.shutdown = true;
    }

    @Override
    public void run() {
        this.init();
        while (!shutdown) {
            /**
             * 从消息客户端接收消息
             */
            List<MqttMessage> messages = receiveMessage();
            /**
             * 调用回调函数处理消息
             */
            this.listener.receive(messages);
        }
    }
}
