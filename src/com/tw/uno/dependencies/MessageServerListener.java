package com.tw.uno.dependencies;

public interface MessageServerListener {
    void onNewConnection(MessageChannel channel);
    void onError(Exception e);
}
