package com.easemob.mqtt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MessageClient {
    public List<MqttMessage> pollMessage(String[] topics) {
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
