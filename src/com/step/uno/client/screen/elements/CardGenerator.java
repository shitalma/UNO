package com.step.uno.client.screen.elements;

import com.step.uno.model.Card;
import com.step.uno.model.Colour;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CardGenerator {
    Map<Color,Colour> colorMap = new HashMap<>();
    String signNumber = "0123456789";
    private Color cardColor;
    private String sign;

    public CardGenerator(Color cardColor, String sign) {
        this.cardColor = cardColor;
        this.sign = sign;
        addColorsToMap();
    }
    public void addColorsToMap() {
        colorMap.put(new Color(255,100,100),Colour.Red);
        colorMap.put(new Color(225,255,100),Colour.Yellow);
        colorMap.put(new Color(100,255,100),Colour.Green);
        colorMap.put(Color.BLACK,Colour.Black);
        colorMap.put(new Color(100,100,255),Colour.Blue);
    }

    public Card createCard() {
        if(signNumber.contains(this.sign)) this.sign = "_"+this.sign;
        return Card.createCard(colorMap.get(this.cardColor),this.sign);
    }
}
