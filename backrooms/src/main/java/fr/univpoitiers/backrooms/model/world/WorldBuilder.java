package fr.univpoitiers.backrooms.model.world;

import fr.univpoitiers.backrooms.model.entity.Characters;
import fr.univpoitiers.backrooms.model.item.Food;
import fr.univpoitiers.backrooms.model.item.Spells;
import fr.univpoitiers.backrooms.model.item.Weapon;

import java.util.HashMap;
import java.util.Objects;

public class WorldBuilder {
    private HashMap<String, Locations> locations;

    public WorldBuilder() {
        HashMap<String, Locations> locations = new HashMap<>();

        // Création des Locations
        Locations realWorld = new Locations("Real World",
                "You managed to return to reality. But for how long?");
        Locations level1 = new Locations("Level 1 : Living Area",
                "The maddening hum of the yellow wallpaper has faded. You are in a vast warehouse. The air is cold and smells of damp concrete and... something strangely sweet: Almonds. This is Level 1, the 'Habitable Zone'.");
        Locations level7 = new Locations("Level 7 : Thalassophobia",
                "You gasp as you hit the freezing water. You are floating in a flooded room. Beneath the surface lies a vast, impossible ocean. You must swim to survive.");

        // Chemins vers les images
        String pathRealWorld = Objects.requireNonNull(WorldBuilder.class.getResource("/images/Map_Empty.png")).toExternalForm();
        String pathLevel1 = Objects.requireNonNull(WorldBuilder.class.getResource("/images/Map_Empty.png")).toExternalForm();
        String pathLevel7 = Objects.requireNonNull(WorldBuilder.class.getResource("/images/Map_Empty.png")).toExternalForm();

        // Ajout des maps dans le HashMap
        locations.put(pathRealWorld, realWorld);
        locations.put(pathLevel1, level1);
        locations.put(pathLevel7, level7);

        // Ajout des items
        level1.addItem(new Weapon("CROWBAR", 3, "A solid metal tool for defense.", 15));
        level1.addItem(new Food("LUNCHBOX_SANDWICH", 1, "A stale but edible sandwich.", 12));
        level7.addItem(new Food("HYDRATION_GEL", 1, "A strange gel restoring stamina.", 12));
        realWorld.addItem(new Spells("REALITY_ANCHOR", 1, "A spell stabilizing your presence in the real world."));

        // Ajout des personnages
        level1.addCharacter(new Characters(35, "The_Lurker", 5, "A tall, thin creature that stalks silently from the shadows."));
        level7.addCharacter(new Characters(60, "The_Drowned_Maiden", 4, "A drowned woman dripping black water."));

        this.locations = locations;
    }

    public HashMap<String, Locations> getLocations() {
        return locations;
    }

    public Locations getLocation(String pathName) {
        return this.locations.get(pathName);
    }
}
