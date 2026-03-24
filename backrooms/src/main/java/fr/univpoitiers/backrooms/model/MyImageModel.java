package fr.univpoitiers.backrooms.model;

import mvc.Model;

public class MyImageModel implements Model {
    private boolean goSouth;
    private boolean goNorth;
    private boolean goWest;
    private boolean goEast;
    private boolean running;

    public MyImageModel(){
        this.goNorth = false;
        this.goSouth = false;
        this.goWest = false;
        this.goEast = false;
        this.running = false;
    }

    public boolean isGoSouth() {
        return goSouth;
    }

    public void setGoSouth(boolean goSouth) {
        this.goSouth = goSouth;
    }

    public boolean isGoNorth() {
        return goNorth;
    }

    public void setGoNorth(boolean goNorth) {
        this.goNorth = goNorth;
    }

    public boolean isGoWest() {
        return goWest;
    }

    public void setGoWest(boolean goWest) {
        this.goWest = goWest;
    }

    public boolean isGoEast() {
        return goEast;
    }

    public void setGoEast(boolean goEast) {
        this.goEast = goEast;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {

    }
}
