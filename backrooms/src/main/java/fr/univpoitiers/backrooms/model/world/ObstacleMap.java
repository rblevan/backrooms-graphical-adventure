package fr.univpoitiers.backrooms.model.world;

public class ObstacleMap {
    private boolean[][] obstacles;
    private static final double CELL_SIZE = 50;

    public ObstacleMap(int width, int height){
        this.obstacles = new boolean[width][height];
    }

    public void setObstacle(int x, int y){
        obstacles[x][y] = true;
    }

    public int getWidth(){
        return obstacles.length;
    }

    public int getHeight(){
        return obstacles[0].length;
    }
}
