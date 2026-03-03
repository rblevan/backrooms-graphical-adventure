package fr.univpoitiers.backrooms.model.item;

import fr.univpoitiers.backrooms.model.entity.Entity;
import fr.univpoitiers.backrooms.model.entity.Hero;

/**
 * Represents a consumable food item.
 * Food can be used to restore the player's Health Points (PV).
 */
public class Food extends Items {

    private int healPoints;

    /**
     * Constructs a new Food item.
     *
     * @param name        The name of the food.
     * @param volume      The volume.
     * @param description The description.
     * @param healPoints  The amount of health this food restores when consumed.
     */
    public Food(String name, int volume, String description, int healPoints) {
        super(name, volume, description);
        this.healPoints = healPoints;
    }

    /**
     * Retrieves the healing power of the food.
     *
     * @return The number of PV restored.
     */
    public int getHealPoints() {
        return this.healPoints;
    }

    @Override
    public String use(Hero player) {
        int currentHP = player.getPV();
        int maxHP = player.getMax_hp();
        int healAmount = 20; // Ou une variable propre à l'objet Food

        // On calcule les nouveaux HP sans dépasser le max
        int newHP = Math.min(currentHP + healAmount, maxHP);
        int pointsGained = newHP - currentHP;

        player.setPV(newHP); // On met à jour le joueur
        player.getBackpack().removeItem(this); // On consomme l'item

        return "You ate the " + this.getName() + ". You recovered " + pointsGained + " HP. (Total: " + newHP + "/" + maxHP + ")";
    }

    @Override
    public String use(Hero player, Entity target) {
        return "";
    }
}
