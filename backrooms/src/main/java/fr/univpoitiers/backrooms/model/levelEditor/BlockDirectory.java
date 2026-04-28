package fr.univpoitiers.backrooms.model.levelEditor;

// [IMPORTS]
import fr.univpoitiers.backrooms.model.enumeration.BlockSubtype;
import fr.univpoitiers.backrooms.model.enumeration.BlockType;
import javafx.scene.image.ImageView;

public class BlockDirectory {

    // [ATTRIBUTES]
    private final Block[] directory;

    // [DIRECTORY]
    // Down here are all the different blocks in the game

    // [LEVEL 1]
    // [EXITS]
    private static final Block LV1_EXIT_1 = new Block(1, BlockType.EXIT, BlockSubtype.NONE, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/exit_none_1.png").toExternalForm()));
    private static final Block LV1_EXIT_2 = new Block(1, BlockType.EXIT, BlockSubtype.NONE, 2, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/exit_none_2.png").toExternalForm()));
    private static final Block LV1_EXIT_3 = new Block(1, BlockType.EXIT, BlockSubtype.NONE, 3, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/exit_none_3.png").toExternalForm()));
    private static final Block LV1_EXIT_4 = new Block(1, BlockType.EXIT, BlockSubtype.NONE, 4, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/exit_none_4.png").toExternalForm()));
    // [GROUND]
    private static final Block LV1_GROUND = new Block(1, BlockType.GROUND, BlockSubtype.NONE, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/ground_none_1.png").toExternalForm()));
    // [VOID]
    private static final Block LV1_VOID = new Block(1, BlockType.VOID, BlockSubtype.NONE, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/void_none_1.png").toExternalForm()));
    // [INNERCORNERS]
    private static final Block LV1_WALL_INNERCORNER_1 = new Block(1, BlockType.WALL, BlockSubtype.INNERCORNER, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/wall_innercorner_1.png").toExternalForm()));
    private static final Block LV1_WALL_INNERCORNER_2 = new Block(1, BlockType.WALL, BlockSubtype.INNERCORNER, 2, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/wall_innercorner_2.png").toExternalForm()));
    private static final Block LV1_WALL_INNERCORNER_3 = new Block(1, BlockType.WALL, BlockSubtype.INNERCORNER, 3, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/wall_innercorner_3.png").toExternalForm()));
    private static final Block LV1_WALL_INNERCORNER_4 = new Block(1, BlockType.WALL, BlockSubtype.INNERCORNER, 4, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/wall_innercorner_4.png").toExternalForm()));
    // [WALLS]
    private static final Block LV1_WALL_1 = new Block(1, BlockType.WALL, BlockSubtype.NONE, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/wall_none_1.png").toExternalForm()));
    private static final Block LV1_WALL_2 = new Block(1, BlockType.WALL, BlockSubtype.NONE, 2, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/wall_none_2.png").toExternalForm()));
    private static final Block LV1_WALL_3 = new Block(1, BlockType.WALL, BlockSubtype.NONE, 3, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/wall_none_3.png").toExternalForm()));
    private static final Block LV1_WALL_4 = new Block(1, BlockType.WALL, BlockSubtype.NONE, 4, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/wall_none_4.png").toExternalForm()));
    // [OUTERCORNERS]
    private static final Block LV1_WALL_OUTERCORNER_1 = new Block(1, BlockType.WALL, BlockSubtype.OUTERCORNER, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/wall_outercorner_1.png").toExternalForm()));
    private static final Block LV1_WALL_OUTERCORNER_2 = new Block(1, BlockType.WALL, BlockSubtype.OUTERCORNER, 2, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/wall_outercorner_2.png").toExternalForm()));
    private static final Block LV1_WALL_OUTERCORNER_3 = new Block(1, BlockType.WALL, BlockSubtype.OUTERCORNER, 3, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/wall_outercorner_3.png").toExternalForm()));
    private static final Block LV1_WALL_OUTERCORNER_4 = new Block(1, BlockType.WALL, BlockSubtype.OUTERCORNER, 4, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/wall_outercorner_4.png").toExternalForm()));

    // [LEVEL 2]
    // [EXITS]
    private static final Block LV2_EXIT_1 = new Block(2, BlockType.EXIT, BlockSubtype.NONE, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/exit_none_1.png").toExternalForm()));
    private static final Block LV2_EXIT_2 = new Block(2, BlockType.EXIT, BlockSubtype.NONE, 2, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/exit_none_2.png").toExternalForm()));
    private static final Block LV2_EXIT_3 = new Block(2, BlockType.EXIT, BlockSubtype.NONE, 3, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/exit_none_3.png").toExternalForm()));
    private static final Block LV2_EXIT_4 = new Block(2, BlockType.EXIT, BlockSubtype.NONE, 4, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/exit_none_4.png").toExternalForm()));
    // [GROUND]
    private static final Block LV2_GROUND = new Block(2, BlockType.GROUND, BlockSubtype.NONE, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/ground_none_1.png").toExternalForm()));
    // [VOID]
    private static final Block LV2_VOID = new Block(2, BlockType.VOID, BlockSubtype.NONE, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/void_none_1.png").toExternalForm()));
    // [BEAM1 WALLS]
    private static final Block LV2_WALL_BEAM1_1 = new Block(2, BlockType.WALL, BlockSubtype.BEAM1, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_beam1_1.png").toExternalForm()));
    private static final Block LV2_WALL_BEAM1_2 = new Block(2, BlockType.WALL, BlockSubtype.BEAM1, 2, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_beam1_2.png").toExternalForm()));
    private static final Block LV2_WALL_BEAM1_3 = new Block(2, BlockType.WALL, BlockSubtype.BEAM1, 3, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_beam1_3.png").toExternalForm()));
    private static final Block LV2_WALL_BEAM1_4 = new Block(2, BlockType.WALL, BlockSubtype.BEAM1, 4, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_beam1_4.png").toExternalForm()));
    // [BEAM2 WALLS]
    private static final Block LV2_WALL_BEAM2_1 = new Block(2, BlockType.WALL, BlockSubtype.BEAM2, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_beam2_1.png").toExternalForm()));
    private static final Block LV2_WALL_BEAM2_2 = new Block(2, BlockType.WALL, BlockSubtype.BEAM2, 2, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_beam2_2.png").toExternalForm()));
    private static final Block LV2_WALL_BEAM2_3 = new Block(2, BlockType.WALL, BlockSubtype.BEAM2, 3, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_beam2_3.png").toExternalForm()));
    private static final Block LV2_WALL_BEAM2_4 = new Block(2, BlockType.WALL, BlockSubtype.BEAM2, 4, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_beam2_4.png").toExternalForm()));
    // [BEAM3 WALLS]
    private static final Block LV2_WALL_BEAM3_1 = new Block(2, BlockType.WALL, BlockSubtype.BEAM3, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_beam3_1.png").toExternalForm()));
    private static final Block LV2_WALL_BEAM3_2 = new Block(2, BlockType.WALL, BlockSubtype.BEAM3, 2, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_beam3_2.png").toExternalForm()));
    private static final Block LV2_WALL_BEAM3_3 = new Block(2, BlockType.WALL, BlockSubtype.BEAM3, 3, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_beam3_3.png").toExternalForm()));
    private static final Block LV2_WALL_BEAM3_4 = new Block(2, BlockType.WALL, BlockSubtype.BEAM3, 4, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_beam3_4.png").toExternalForm()));
    // [INNERCORNERS]
    private static final Block LV2_WALL_INNERCORNER_1 = new Block(2, BlockType.WALL, BlockSubtype.INNERCORNER, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_innercorner_1.png").toExternalForm()));
    private static final Block LV2_WALL_INNERCORNER_2 = new Block(2, BlockType.WALL, BlockSubtype.INNERCORNER, 2, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_innercorner_2.png").toExternalForm()));
    private static final Block LV2_WALL_INNERCORNER_3 = new Block(2, BlockType.WALL, BlockSubtype.INNERCORNER, 3, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_innercorner_3.png").toExternalForm()));
    private static final Block LV2_WALL_INNERCORNER_4 = new Block(2, BlockType.WALL, BlockSubtype.INNERCORNER, 4, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_innercorner_4.png").toExternalForm()));
    // [WALLS]
    private static final Block LV2_WALL_1 = new Block(2, BlockType.WALL, BlockSubtype.NONE, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_none_1.png").toExternalForm()));
    private static final Block LV2_WALL_2 = new Block(2, BlockType.WALL, BlockSubtype.NONE, 2, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_none_2.png").toExternalForm()));
    private static final Block LV2_WALL_3 = new Block(2, BlockType.WALL, BlockSubtype.NONE, 3, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_none_3.png").toExternalForm()));
    private static final Block LV2_WALL_4 = new Block(2, BlockType.WALL, BlockSubtype.NONE, 4, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_none_4.png").toExternalForm()));
    // [OUTERCORNERS]
    private static final Block LV2_WALL_OUTERCORNER_1 = new Block(2, BlockType.WALL, BlockSubtype.OUTERCORNER, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_outercorner_1.png").toExternalForm()));
    private static final Block LV2_WALL_OUTERCORNER_2 = new Block(2, BlockType.WALL, BlockSubtype.OUTERCORNER, 2, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_outercorner_2.png").toExternalForm()));
    private static final Block LV2_WALL_OUTERCORNER_3 = new Block(2, BlockType.WALL, BlockSubtype.OUTERCORNER, 3, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_outercorner_3.png").toExternalForm()));
    private static final Block LV2_WALL_OUTERCORNER_4 = new Block(2, BlockType.WALL, BlockSubtype.OUTERCORNER, 4, new ImageView(BlockDirectory.class.getResource("/images/blocks/level2/wall_outercorner_4.png").toExternalForm()));


    /* [TEMPLATE BLOCK] 
    public static final Block TEMP = new Block(1, BlockType.VOID, BlockSubtype.NONE, 1, new ImageView(BlockDirectory.class.getResource("/images/blocks/level1/void_none_1.png").toExternalForm()));
    */

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
        this.directory[0] = LV1_EXIT_1;
        this.directory[1] = LV1_EXIT_2;
        this.directory[2] = LV1_EXIT_3;
        this.directory[3] = LV1_EXIT_4;

        this.directory[4] = LV1_WALL_INNERCORNER_1;
        this.directory[5] = LV1_WALL_INNERCORNER_2;
        this.directory[6] = LV1_WALL_INNERCORNER_3;
        this.directory[7] = LV1_WALL_INNERCORNER_4;

        this.directory[8] = LV1_WALL_1;
        this.directory[9] = LV1_WALL_2;
        this.directory[10] = LV1_WALL_3;
        this.directory[11] = LV1_WALL_4;

        this.directory[12] = LV1_WALL_OUTERCORNER_1;
        this.directory[13] = LV1_WALL_OUTERCORNER_2;
        this.directory[14] = LV1_WALL_OUTERCORNER_3;
        this.directory[15] = LV1_WALL_OUTERCORNER_4;

        this.directory[16] = LV1_GROUND;

        this.directory[17] = LV1_VOID;

        this.directory[18] = LV2_VOID;

        this.directory[19] = LV2_GROUND;

        this.directory[20] = LV2_EXIT_1;
        this.directory[21] = LV2_EXIT_2;
        this.directory[22] = LV2_EXIT_3;
        this.directory[23] = LV2_EXIT_4;

        this.directory[24] = LV2_WALL_BEAM1_1;
        this.directory[25] = LV2_WALL_BEAM1_2;
        this.directory[26] = LV2_WALL_BEAM1_3;
        this.directory[27] = LV2_WALL_BEAM1_4;

        this.directory[28] = LV2_WALL_BEAM2_1;
        this.directory[29] = LV2_WALL_BEAM2_2;
        this.directory[30] = LV2_WALL_BEAM2_3;
        this.directory[31] = LV2_WALL_BEAM2_4;

        this.directory[32] = LV2_WALL_BEAM3_1;
        this.directory[33] = LV2_WALL_BEAM3_2;
        this.directory[34] = LV2_WALL_BEAM3_3;
        this.directory[35] = LV2_WALL_BEAM3_4;

        this.directory[36] = LV2_WALL_INNERCORNER_1;
        this.directory[37] = LV2_WALL_INNERCORNER_2;
        this.directory[38] = LV2_WALL_INNERCORNER_3;
        this.directory[39] = LV2_WALL_INNERCORNER_4;

        this.directory[40] = LV2_WALL_1;
        this.directory[41] = LV2_WALL_2;
        this.directory[42] = LV2_WALL_3;
        this.directory[43] = LV2_WALL_4;

        this.directory[44] = LV2_WALL_OUTERCORNER_1;
        this.directory[45] = LV2_WALL_OUTERCORNER_2;
        this.directory[46] = LV2_WALL_OUTERCORNER_3;
        this.directory[47] = LV2_WALL_OUTERCORNER_4;
    }

    // No setter because BlockDirectory in only meant to be read

    public Block getBlock(int i)
    {
        return this.directory[i];
    }
}
