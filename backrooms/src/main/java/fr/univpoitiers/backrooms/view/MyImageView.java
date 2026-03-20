package fr.univpoitiers.backrooms.view;

import fr.univpoitiers.backrooms.model.entity.Hero;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mvc.View;

import java.util.Objects;

public class MyImageView extends ImageView implements View {

    public void updateImage(String path) {
        this.setImage(new Image(Objects.requireNonNull(getClass().getResource(path)).toExternalForm()));
    }

    public void updateView(Hero hero) {
        // On aligne la position du sprite sur la position du modèle
        this.setTranslateX(hero.getPosition().getX());
        this.setTranslateY(hero.getPosition().getY());
    }
}
