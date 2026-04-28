package fr.univpoitiers.backrooms.model;

import mvc.Model;

public class ButtonModel implements Model {
    private String text;

    public ButtonModel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void run() {
        System.out.println("Le bouton est actif.");
    }
}
