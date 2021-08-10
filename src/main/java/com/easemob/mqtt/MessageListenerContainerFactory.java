package com.easemob.mqtt;

public class MessageListenerContainerFactory {
    public MessageListenerContainer createContainer(String... topic) {
        return new MessageListenerContainer();
    }
}
