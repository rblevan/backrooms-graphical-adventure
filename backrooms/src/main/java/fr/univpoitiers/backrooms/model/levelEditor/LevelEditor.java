package fr.univpoitiers.backrooms.model.levelEditor;

// [IMPORTS]
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LevelEditor {

    // [ATTRIBUTES]
    private Level level = new Level();
    private Block selectedPresetBlock = new Block();

    // [METHODS]
    
    //* Gets the LevelEditor's level */
    public Level getLevel()
    {
        return this.level;
    }

    //* Gets the LevelEditor's selected Block */
    public Block getSelectedPresetBlock()
    {
        return this.selectedPresetBlock;
    }

    //* Rebuild sprites of the level by rebuilding each Block's sprite */
    private void rebuildSprites()
    {
        Block[][] grid = level.getBlockgrid();

        for (int x = 0; x < grid.length; x++)
        {
            for (int y = 0; y < grid[x].length; y++)
            {
                if (grid[x][y] != null)
                {
                    grid[x][y].rebuildSprite();
                }
            }
        }
    }

    /**
     * Saves created level into a .json file
     *
     * @param filename  The name you want to save your level as
     */
    public void saveLevel(String filename)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filename))
        {
            gson.toJson(level, writer);
            System.out.println("Level sauvegardé !");
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Loads created level from a .json file
     *
     * @param filename  The name you want to save your level as
     */
    public void loadLevel(String filename)
    {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(filename))
        {
            level = gson.fromJson(reader, Level.class);

            // Recréer les sprites
            rebuildSprites();

            System.out.println("Level chargé !");
        }
        
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
