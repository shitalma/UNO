package com.tw.uno.dependencies;

public interface MessageChannelListener {
    void onError(MessageChannel client, Exception e);
    void onMessage(MessageChannel client, Object message);
    void onConnectionClosed(MessageChannel client);
}
