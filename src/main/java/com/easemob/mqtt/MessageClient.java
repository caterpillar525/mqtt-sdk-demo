package com.easemob.mqtt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MessageClient {
    public List<MqttMessage> pollMessage(String[] topics, Config config) {
        //此处模拟去MQTT服务器获取消息，客户端将等待最多500条消息，或者500ms时间，来返回消息
        String restapi = config.getRestApi() + "/openapi/rm/message/poll";
        List<MqttMessage> messages = new ArrayList<>(500);
        int size = 0;
        long start = System.currentTimeMillis();
        long end;
        Random random = new Random();
        while (size++ < 500) {
            MqttMessage message = new MqttMessage();
            message.setPayload("this is message " + size);
            message.setTopic(topics[random.nextInt(topics.length)]);
            messages.add(message);
            end = System.currentTimeMillis();
            if (end - start > 500) {
                break;
            }
        }
        return messages;
    }
}
