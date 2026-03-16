package fr.univpoitiers.backrooms.model;

import mvc.Model;

public class MenuModel implements Model {
    private String videoPath = null;

    public MenuModel() {
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    @Override
    public void run(){
        System.out.println("Le menu est actif.");
    }
}
