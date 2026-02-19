package fr.univpoitiers.backrooms.model.entity;

import fr.univpoitiers.backrooms.model.world.Locations;
import fr.univpoitiers.backrooms.model.item.Backpack;
import fr.univpoitiers.backrooms.model.world.Position;
import javafx.scene.image.Image;

public class Hero extends Entity {

    private Backpack backpack;
    private final String username;
    private Locations location;
    private Image image;
    private Position position;

    /**
     * Retrieves the hero's backpack.
     * Used to access inventory contents or add/remove items.
     *
     * @return The Backpack object.
     */
    public Backpack getBackpack() {
        return this.backpack;
    }

    /**
     * Constructs a new Hero with specific stats and starting equipment.
     *
     * @param username      The player's username (often used for meta-data).
     * @param PV            Initial Health Points.
     * @param name          The character's in-game name.
     * @param attack        Attack power.
     * @param description   A description of the hero.
     * @param backpack      The hero's inventory object.
     * @param location      The starting location of the hero.
     * @param image         The hero's image.
     */
    public Hero(String username, int PV, String name, int attack, String description, Backpack backpack, Locations location, Image image, Position position){
        super(PV,name,attack,description);
        this.backpack = backpack;
        this.username = username;
        this.location = location;
        this.image = image;
        this.position = position;
    }

    // constructeur pour le jeu textuel (pas besoin de charger d'image)
    public Hero(String username, int PV, String name, int attack, String description, Backpack backpack, Locations location){
        super(PV,name,attack,description);
        this.backpack = backpack;
        this.username = username;
        this.location = location;
        this.image = null;
        this.position = null;
    }

    public Position getPosition() {
        return position;
    }

    public void setX(double x){
        this.position.setX(x);
    }
    public void setY(double y){
        this.position.setY(y);
    }

    /**
     * Retrieves the player's username.
     *
     * @return The username string.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Updates the hero's current location.
     * This is usually called when the 'GO' command is successfully executed.
     *
     * @param location The new Location object where the hero is moving to.
     */
    public void setLocation(Locations location) {this.location = location;}

    /**
     * Retrieves the current location of the hero.
     * Used to determine available exits, visible items, and enemies.
     *
     * @return The current Location object.
     */
    public Locations getLocation() {
        return location;
    }

    public Image getImage() {
        return image;
    }
}