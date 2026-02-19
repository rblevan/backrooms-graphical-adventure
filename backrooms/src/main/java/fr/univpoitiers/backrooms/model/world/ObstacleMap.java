package fr.univpoitiers.backrooms.model.world;

public class ObtacleMap {
    private boolean[][] obstacles;

    public ObtacleMap(int width, int height){
        this.obstacles = new boolean[width][height];
    }

    public boolean isObstacle(int x, int y){
        return obstacles[x][y];
    }

    public void setObstacle(int x, int y){
        obstacles[x][y] = true;
    }
}
