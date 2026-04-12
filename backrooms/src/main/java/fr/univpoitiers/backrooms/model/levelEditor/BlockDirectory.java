package fr.univpoitiers.backrooms.model.levelEditor;

// [IMPORTS]
import fr.univpoitiers.backrooms.model.enumeration.BlockSubtype;
import fr.univpoitiers.backrooms.model.enumeration.BlockType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlockDirectory {

    // [ATTRIBUTES]
    private final Block[] directory;

    // [DIRECTORY]
    // Down here are all the different blocks in the game
    // [LEVEL 1]
    // [EXIT BLOCKS]
    public static final Block EXIT_1 = new Block(1, BlockType.EXIT, BlockSubtype.NONE, 1, new ImageView("../../../../ressources/images/blocks/level1/exit_none_1.png"));
    public static final Block EXIT_2 = new Block(1, BlockType.EXIT, BlockSubtype.NONE, 2, new ImageView("../../../../ressources/images/blocks/level1/exit_none_2.png"));
    public static final Block EXIT_3 = new Block(1, BlockType.EXIT, BlockSubtype.NONE, 3, new ImageView("../../../../ressources/images/blocks/level1/exit_none_3.png"));
    public static final Block EXIT_4 = new Block(1, BlockType.EXIT, BlockSubtype.NONE, 4, new ImageView("../../../../ressources/images/blocks/level1/exit_none_4.png"));

    /* [TEMPLATE BLOCK] 
    public static final Block TEMP = new Block(1, BlockType.EXIT, BlockSubtype.NONE, 4, new ImageView("../../../../ressources/images/blocks/level./aaa.png"));
    */
    private ImageView imageView = new ImageView(new Image(getClass().getResource("/images/blocks/level1/...").toExternalForm()));

    // [CONSTRUCTOR]
    public BlockDirectory()
    {
        // We currently have 48 different blocks
        this.directory = new Block[48];
    }

    /* The operations done by this function could have been done in the constructor
    But doing it in a separate function make the initialization more explicit */
    public void init()
    {
        //directory[i] = A BLOCK OF THE DIRECTORY
        // Do the same for each Block of the directory
    }

    // No setter because BlockDirectory in only meant to be read

    public Block getBlock(int i)
    {
        return this.directory[i];
    }
}
