package fr.univpoitiers.backrooms.model.levelEditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LevelEditor {

    // [ATTRIBUTES]
    private Level level = new Level();
    private Block selectedPresetBlock = new Block();
    private static final String SAVE_DIR = "../../../../ressources/levels/";

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
     * Build a path from SAVE_DIR + filename + .json to save / load a level.json file
     * 
     * @param filename      The name wanted for the file
     * @return              Absolute path to write / read level.json file   
     */
    private Path buildPath(String filename)
    {
        return Path.of(SAVE_DIR, filename + ".json").toAbsolutePath();
    }

    /**
     * Saves created level into a .json file
     *
     * @param filename  The name you want to save your level as
     */
    public void saveLevel(String filename)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path path = buildPath(filename);

        try (BufferedWriter writer = Files.newBufferedWriter(path))
        {
            gson.toJson(level, writer);
            System.out.println("Level sauvegardé : " + path);
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
        Path path = buildPath(filename);

        try (BufferedReader reader = Files.newBufferedReader(path))
        {
            level = gson.fromJson(reader, Level.class);

            rebuildSprites();

            System.out.println("Level chargé : " + path);
        }
        
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
