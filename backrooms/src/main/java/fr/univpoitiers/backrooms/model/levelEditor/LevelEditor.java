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
    public static final String SAVE_DIR = "../../../../../ressources/levels/custom";
    public static final String LOAD_DIR_OG = "../../../../../ressources/levels/originals";

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

    //* Updates selectedPresetBlock with a new selected Block */
    public void updateSelectedPresetBlock(Block newSelection)
    {
        this.selectedPresetBlock = newSelection;
    }

    //* Rebuild sprites of the level by rebuilding each Block's sprite */
    private void rebuildSprites()
    {
        Block[][] grid = level.getBlockgrid();

        for (Block[] grid1 : grid) {
            for (Block grid11 : grid1) {
                if (grid11 != null) {
                    grid11.rebuildSprite();
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
    private Path buildPath(String filename, String dir)
    {
        return Path.of(dir, filename + ".json").toAbsolutePath();
    }

    /**
     * Saves created level into a .json file
     *
     * @param filename  The name you want to save your level as
     */
    public void saveLevel(String filename, String dir)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Path path = buildPath(filename, dir);

        try (BufferedWriter writer = Files.newBufferedWriter(path))
        {
            gson.toJson(level, writer);
            System.out.println("Level sauvegardé : " + path);
        }

        catch (IOException e){}
    }

    /**
     * Loads created level from a .json file
     *
     * @param filename  The name you want to save your level as
     */
    public void loadLevel(String filename, String dir)
    {
        Gson gson = new Gson();
        Path path = buildPath(filename, dir);

        try (BufferedReader reader = Files.newBufferedReader(path))
        {
            level = gson.fromJson(reader, Level.class);

            rebuildSprites();

            System.out.println("Level chargé : " + path);
        }
        
        catch (IOException e){}
    }

    public void setSelectedPresetBlock(Block selectedPresetBlock) {
        this.selectedPresetBlock = selectedPresetBlock;
    }
}
