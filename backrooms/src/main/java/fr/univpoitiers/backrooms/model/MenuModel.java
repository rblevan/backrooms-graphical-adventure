package fr.univpoitiers.backrooms.model;

import mvc.Model;

public class MenuModel implements Model {
    private String videoPath;
    private String titlePath;

    public MenuModel() {
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public void setTitlePath(String titlePath) {
        this.titlePath = titlePath;
    }

    public String getTitlePath() {
        return this.titlePath;
    }

    @Override
    public void run(){
        System.out.println("Le menu est actif.");
    }
}
