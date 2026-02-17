package fr.univpoitiers.backrooms.model.world;

import fr.univpoitiers.backrooms.model.entity.Characters;
import fr.univpoitiers.backrooms.model.item.Food;
import fr.univpoitiers.backrooms.model.item.Spells;
import fr.univpoitiers.backrooms.model.item.Weapon;

import fr.univpoitiers.backrooms.model.enumeration.Direction;

public class TextBuilder {
    public static Locations buildWorld(){
        Locations realWorld = new Locations("Real World", "You managed to return to reality. But for how long?");

        Locations levelMinus1 = new Locations("Level -1 : Grey Corridor",
                "You have entered a long, straight hallway. The air is immediately glacial, chilling you to the bone. This place is known as 'The Negative Hub'.");

        Locations level0 = new Locations("Level 0 : Lobby",
                "You wake up in an endless maze of yellow-tinted rooms, dimly lit by flickering fluorescent lights that hum with an unbearable buzz. The air smells faintly of mold and electricity.");

        Locations level1 = new Locations("Level 1 : Living Area",
                "The maddening hum of the yellow wallpaper has faded. You are in a vast warehouse. The air is cold and smells of damp concrete and... something strangely sweet: Almonds. This is Level 1, the 'Habitable Zone'.");

        Locations level2 = new Locations("Level 2 : Pipe Dreams",
                "You have emerged into a suffocating, industrial labyrinth. The air here is thick, heavy, and incredibly hot. Infinite miles of rusting pipes line the walls and ceilings, hissing with steam and dripping unknown fluids.");

        Locations level3 = new Locations("Level 3 : Electrical Station",
                "The silence is replaced by a deafening, industrial roar. You are standing in a series of narrow, claustrophobic corridors made of dark brick. Thick electrical cables snake along the walls, pulsating with dangerous energy.");

        Locations level4 = new Locations("Level 4 : Abandoned Office",
                "The noise stops instantly. You are standing on a soft, grey carpet in an infinite, empty office building. You can find Almond Water in the coolers. You feel a sense of safety here.");

        Locations level5 = new Locations("Level 5 : Terror Hotel",
                "The office carpet gives way to elegant red rugs and polished mahogany wood. Smooth jazz music plays. You are in a grand, early 20th-century hotel. Staying here too long erodes your sanity.");

        Locations level6 = new Locations("Level 6 : Lights Out",
                "You can't see anything. This is not just darkness; it is a void. You must feel your way through the blindness.");

        Locations level7 = new Locations("Level 7 : Thalassophobia",
                "You gasp as you hit the freezing water. You are floating in a flooded room. Beneath the surface lies a vast, impossible ocean. You must swim to survive.");

        Locations level8 = new Locations("Level 8 : Cave System",
                "You drag yourself out of the water onto rough, jagged stone. You are in a colossal cave system. Glowing moss provides dim, greenish light. This place is a hunting ground. Watch the ceiling.");

        Locations level9 = new Locations("Level 9 : The Suburbs",
                "The jagged stone disappears. You are standing on asphalt in a neighborhood of suburban houses under a starless, black sky. It looks like home, but it feels wrong.");

        // --- 2. Connecting the Exits ---

        levelMinus1.addExit(Direction.WEST, new Exits(levelMinus1, "Return to the endless corridor", false));
        levelMinus1.addExit(Direction.NORTH, new Exits(level1, "A wooden door leading to Level 1", false));
        levelMinus1.addExit(Direction.SOUTH, new Exits(level3, "A wooden door leading to Level 3", false));
        levelMinus1.addExit(Direction.EAST, new Exits(level0, "A wooden door leading to Level 0", false));

        level0.addExit(Direction.NORTH, new Exits(level1, "Staircase going up to Level 1", false));
        level0.addExit(Direction.SOUTH, new Exits(levelMinus1, "A glitching area leading to Level -1", false));

        level1.addExit(Direction.SOUTH, new Exits(level0, "Door to Level 0", false));
        level1.addExit(Direction.EAST, new Exits(level2, "Maintenance door to Level 2", false));

        level2.addExit(Direction.WEST, new Exits(level1, "Return to Level 1", false));
        level2.addExit(Direction.NORTH, new Exits(level3, "Fire exit to Level 3", false));
        level2.addExit(Direction.EAST, new Exits(level4, "Old corridor toward Level 4", false));

        level3.addExit(Direction.NORTH, new Exits(level4, "Elevator to Level 4", false));
        level3.addExit(Direction.EAST, new Exits(level5, "Rare wooden door to Level 5", false));

        level4.addExit(Direction.NORTH, new Exits(level5, "Stairs up to Level 5", false));
        level4.addExit(Direction.SOUTH, new Exits(level6, "Stairs down to Level 6", false));

        level5.addExit(Direction.NORTH, new Exits(level6, "Boiler room to Level 6", false));

        level6.addExit(Direction.SOUTH, new Exits(level7, "Hole leading to Level 7", false));

        level7.addExit(Direction.NORTH, new Exits(level8, "Cave opening to Level 8", false));

        level8.addExit(Direction.SOUTH, new Exits(level9, "Pitfall to Level 9", false));
        level8.addExit(Direction.WEST, new Exits(level2, "Vent leading back to Level 2", false));

        level9.addExit(Direction.EAST, new Exits(realWorld, "Golden door to real world", false));

        // --- 3. Items Initialization ---

        level0.addItem(new Food("ALMOND_WATER", 1, "Sweet, refreshing and calming.", 20));
        level0.addItem(new Food("ENERGY_BAR", 1, "A dense bar full of calories.", 10));
        level0.addItem(new Weapon("IRON_ROD", 2, "A solid metal rod, good for basic self-defense.", 8));

        level1.addItem(new Weapon("CROWBAR", 3, "A solid metal tool for defense.", 15));
        level1.addItem(new Food("LUNCHBOX_SANDWICH", 1, "A stale but edible sandwich.", 12));

        level2.addItem(new Weapon("BROKEN_PIPE", 2, "A heavy shard of rusted pipe.", 12));
        level2.addItem(new Food("EXPIRED_RATIONS", 1, "Tastes awful but restores energy.", 8));

        level3.addItem(new Food("ELECTROLYTE_DRINK", 1, "Helps with recovery.", 15));
        level3.addItem(new Spells("STATIC_PULSE", 1, "A spell generating a burst of static energy."));

        level4.addItem(new Food("ALMOND_WATER_BOTTLE", 1, "Fresh almond water.", 25));
        level4.addItem(new Spells("MEMORY_FLASH", 1, "A spell that temporarily reveals hidden paths."));

        level5.addItem(new Weapon("FIRE_AXE", 4, "A sharp emergency axe.", 25));
        level5.addItem(new Spells("HAUNTING_WHISPER", 1, "A dangerous spell with unpredictable effects."));

        level6.addItem(new Weapon("GLOWSTICK_TORCH", 1, "A glowing stick acting as a weak weapon.", 3));
        level6.addItem(new Spells("VOID_ECHO", 1, "A spell born from absolute darkness."));

        level7.addItem(new Food("HYDRATION_GEL", 1, "A strange gel restoring stamina.", 12));

        level8.addItem(new Weapon("CRYSTAL_SHARD", 1, "A sharp glowing stone from the cave.", 10));

        level9.addItem(new Food("CHILDS_SNACK_PACK", 1, "A small pack of candy.", 8));
        level9.addItem(new Spells("SUBURB_MIRAGE", 1, "A spell creating illusions of safety."));

        realWorld.addItem(new Spells("REALITY_ANCHOR", 1, "A spell stabilizing your presence in the real world."));

        // --- 4. Characters Initialization ---

        level1.addCharacter(new Characters(35, "The_Lurker", 5, "A tall, thin creature that stalks silently from the shadows."));
        level3.addCharacter(new Characters(50, "The_Red_Hands", 3, "A burned electrical humanoid with crackling fingers."));
        level7.addCharacter(new Characters(60, "The_Drowned_Maiden", 4, "A drowned woman dripping black water."));
        level8.addCharacter(new Characters(80, "The_Crawling_Choir", 6, "A mass of twisted bodies on the ceiling."));
        level5.addCharacter(new Characters(70, "The_Faceless_Caretaker", 4, "A silent hotel butler with no face."));

        return level0;
    }
}