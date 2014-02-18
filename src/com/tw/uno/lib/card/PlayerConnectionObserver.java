package com.tw.uno.lib.card;

import com.tw.uno.lib.LoginObserver;
import com.tw.uno.ui.screen.LoginScreen;
import com.tw.uno.ui.screen.WaitingScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerConnectionObserver implements ActionListener{
    private LoginObserver loginObserver;

    public PlayerConnectionObserver(LoginObserver loginObserver) {

        this.loginObserver = loginObserver;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new WaitingScreen();
        System.out.println(e.paramString());
        LoginScreen source = (LoginScreen)e.getSource();
        System.out.println(source.getName());
//        loginObserver.onJoin(masterAddress.getText(), player.getText());
    }
}
