package fr.univpoitiers.backrooms.model;

import mvc.Model;

public class MenuModel implements Model {
    public MenuModel() {}

    @Override
    public void run(){
        System.out.println("Le menu est actif.");
    }
}
