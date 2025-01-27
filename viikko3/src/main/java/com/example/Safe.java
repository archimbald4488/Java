package com.example;

import java.util.ArrayList;

public class Safe {
    private String pinCode;
    private ArrayList<String> safeFolder;
    
    public Safe(String pinCode) {
        this.pinCode = pinCode;
        this.safeFolder = new ArrayList<>();
    }

    public void addItem(String item) {
        safeFolder.add(item);

    }

    public void uusiPIN(String code) {
        this.pinCode = code;
    }

    public ArrayList<String> listItems(String code) {
        if (this.pinCode.equals(code)) {
            return new ArrayList<>(safeFolder);
        } else {
            return null;
        }
    }
}
