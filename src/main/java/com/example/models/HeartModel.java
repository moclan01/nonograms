package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class HeartModel implements Observable {
    public static final int DEFAULT_QUANTITY = 3;
    private String heartFillUrl = new ImgFile("heart").load();
    private String heartOutlineUrl = new ImgFile("heart_outline").load();
    private int quantity;
    private String[] hearts = new String[DEFAULT_QUANTITY];
    private List<InvalidationListener> listeners = new ArrayList<InvalidationListener>();

    public HeartModel(int quantity) {

        for(int i = 0; i < hearts.length; i++)
            hearts[i] = heartOutlineUrl;

        this.quantity = quantity;
        for (int i = 0; i < quantity; i++)
            hearts[i] = heartFillUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void minusOne() {
        int oldValue = this.getQuantity();
        setQuantity(oldValue - 1);
        int newValue = this.getQuantity();
        hearts[newValue] = heartOutlineUrl;
        notifyAllListeners();
    }

    public void reinitialize() {
        setQuantity(DEFAULT_QUANTITY);
        for (int i = 0; i < hearts.length; i++)
            hearts[i] = heartFillUrl;
        notifyAllListeners();
    }

    public boolean isQuantityEqualZero() {
        return getQuantity() == 0;
    }

    public String[] getHearts() {
        return hearts;
    }

    public void setHearts(String[] hearts) {
        this.hearts = hearts;
    }

    public static int getDefaultQuantity() {
        return DEFAULT_QUANTITY;
    }

    public String getHeartFillUrl() {
        return heartFillUrl;
    }

    public void setHeartFillUrl(String heartFillUrl) {
        this.heartFillUrl = heartFillUrl;
    }

    public String getHeartOutlineUrl() {
        return heartOutlineUrl;
    }

    public void setHeartOutlineUrl(String heartOutlineUrl) {
        this.heartOutlineUrl = heartOutlineUrl;
    }

    public String getHeartImageAt(int index) {
        return this.hearts[index];
    }

    @Override
    public void addListener(InvalidationListener listener) {
        if(!listeners.contains(listener))
            listeners.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        if(listeners.contains(listener))
            listeners.remove(listener);
    }

    public void notifyAllListeners() {
        for(InvalidationListener listener : listeners)
            listener.invalidated(this);
    }
}
