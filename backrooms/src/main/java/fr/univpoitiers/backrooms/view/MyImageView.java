package fr.univpoitiers.backrooms.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mvc.View;

import java.util.Objects;

public class MyImageView extends ImageView implements View {
    private ImageView imageView;

    public MyImageView(String path){
        this.imageView = createImageView(path);
    }

    public ImageView getImageView(){
        return this.imageView;
    }

    public ImageView createImageView(String imagePath) {
        String imagePathLong = Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm();
        return new ImageView(new Image(imagePathLong));
    }

    public ImageView addImageToLayout(Pane pane, Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);

      //  imageView.setTranslateX(worldController.getPlayer().getPosition().getX());
      //  imageView.setTranslateY(worldController.getPlayer().getPosition().getY());

        pane.getChildren().add(imageView);
        return imageView;
    }

}
