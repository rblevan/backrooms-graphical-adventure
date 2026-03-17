package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.MyImageModel;
import fr.univpoitiers.backrooms.view.MyImageView;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import mvc.Controller;

public class MyImageController extends Controller {
    public MyImageController() {
        super(new MyImageModel(),new MyImageView());
    }

    public void moveWithKeyBoard(Scene scene){
        MyImageModel myImageModel = (MyImageModel) this.getModel();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch(keyEvent.getCode()){
                    case Z:
                        myImageModel.setGoNorth(true);
                        break;
                    case S:
                        myImageModel.setGoSouth(true);
                        break;
                    case Q:
                        myImageModel.setGoWest(true);
                        break;
                    case D:
                        myImageModel.setGoEast(true);
                        break;
                    case SHIFT:
                        myImageModel.setRunning(true);
                        break;
                    default:
                        break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case Z:
                        myImageModel.setGoNorth(false);
                        break;
                    case S:
                        myImageModel.setGoSouth(false);
                        break;
                    case Q:
                        myImageModel.setGoWest(false);
                        break;
                    case D:
                        myImageModel.setGoEast(false);
                        break;
                    case SHIFT:
                        myImageModel.setRunning(false);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public void moveImage(ImageView imageView) {
        MyImageModel myImageModel = (MyImageModel) this.getModel();
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                double speed = 2;
                if (myImageModel.isRunning()) {
                    speed = speed*2;
                }
                if (myImageModel.isGoNorth()) {
                    imageView.setTranslateY(imageView.getTranslateY()-speed);
                }else if (myImageModel.isGoEast()){
                    imageView.setTranslateX(imageView.getTranslateX()+speed);
                }else if (myImageModel.isGoSouth()){
                    imageView.setTranslateY(imageView.getTranslateY()+speed);
                }else if (myImageModel.isGoWest()){
                    imageView.setTranslateX(imageView.getTranslateX()-speed);
                }
            }
        };
    }
}
