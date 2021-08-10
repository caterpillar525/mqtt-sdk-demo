package com.easemob.mqtt;

/**
 * 主函数
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //创建配置类
        Config config = new Config();
        config.setAppClientId("YXA6hGwCB0UHSPOV1lp_SAClEQ")
                .setAppClientSecret("YXA6BqIXJjAqnKF4pD3pNSj1VAWTq5E")
                .setRestApi("https://api.cn1.mqtt.chat/app/gtsne0");
        //实例化客户端
        Client client = new Client(config);
        //订阅主题
        client.subscribe("myTopic1", "myTopic2");
        //设置消息回调
        client.setListener(messages -> {
            System.out.println("receive " + messages.size() + " messages");
            messages.forEach(message -> {
                System.out.println("receive message: " + message.getPayload() + ", topic is " + message.getTopic());
            });
        });
        //启动客户端
        client.start();
        //等待1秒，模拟获取消息
        Thread.sleep(1000);
        //关闭客户端
        client.shutdown();
    }
}
