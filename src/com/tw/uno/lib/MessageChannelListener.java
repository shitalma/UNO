package com.tw.uno.lib;

/**
 * This is for listening to message channel.
 */

public interface MessageChannelListener {
    void onError(MessageChannel client, Exception e);
    void onMessage(MessageChannel client, Object message);
    void onConnectionClosed(MessageChannel client);
}