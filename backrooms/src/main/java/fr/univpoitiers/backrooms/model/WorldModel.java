package fr.univpoitiers.backrooms.model;

import fr.univpoitiers.backrooms.model.entity.Hero;
import mvc.Model;

public class WorldModel implements Model {
    private Hero player;
    private String mapPath;

    public String getMapPath() {
        return mapPath;
    }

    public void setMapPath(String mapPath) {
        this.mapPath = mapPath;
    }

    public Hero getPlayer() {
        return player;
    }

    public void setPlayer(Hero player) {
        this.player = player;
    }

    @Override
    public void run() {
        // Logique de mise à jour du monde (physique, IA) si nécessaire
    }
}