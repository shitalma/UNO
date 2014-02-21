package com.step.communication.channel;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class MessageChannel {
    private final Socket socket;
    private MessageChannelListener listener;
    private boolean keepRunning = false;
    private Thread readThread;
    private final Runnable infiniteReadLoop = new Runnable() {
        @Override
        public void run() {
            keepRunning = true;
            while (keepRunning)
                checkForMessage();
        }
    };

    public MessageChannel(Socket socket) {
        this.socket = socket;
    }

    public void startListeningForMessages(MessageChannelListener listener) {
        stopRunningThread();
        this.listener = listener;
        readThread = new Thread(infiniteReadLoop);
        readThread.start();
    }

    private void checkForMessage() {

        try {
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            listener.onMessage(this, objectInputStream.readObject());
        } catch (SocketTimeoutException ste) {
        } catch (SocketException se) {
            if (se.getMessage().contains("Connection reset"))
                listener.onConnectionClosed(this);
        } catch (EOFException eofe) {
            listener.onConnectionClosed(this);
        } catch (IOException e) {
            listener.onError(this, e);
        } catch (ClassNotFoundException e) {
            listener.onError(this, e);
        }
    }

    public void send(Object message) {
        try {
            new ObjectOutputStream(socket.getOutputStream()).writeObject(message);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Sorry you can't join.Specified no of players already joined game");
//            throw new RuntimeException("Could not send message ");
        }
    }

    private void stopRunningThread() {
        if (!keepRunning) return;
        keepRunning = false;
        try {
            if(!Thread.currentThread().equals(readThread))
                readThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        stopRunningThread();
        try {
            socket.close();
        } catch (IOException e) {
            listener.onError(this, e);
        }
    }
}
