package fr.univpoitiers.backrooms.model.levelEditor;

// [IMPORTS]
import fr.univpoitiers.backrooms.model.enumeration.BlockSubtype;
import fr.univpoitiers.backrooms.model.enumeration.BlockType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Block {

    // ATTRIBUTES
    private int level; // Can be 1 or 2 depending on the level skin we want for the block
    private BlockType type; // Block Type, see Type enum
    private BlockSubtype subtype; // Block Subtype, see Subtype enum
    private Object containedObject; // Can be null, entity, food...
    private int orientation; // Can be 1, 2, 3 or 4
    private ImageView sprite; // Changes following the other attributes of the block

    // [CONSTRUCTORS]
    public Block()
    {
        this.level = 1;
        this.type = BlockType.VOID;
        this.subtype = BlockSubtype.NONE;
        this.containedObject = null;
        this.orientation = 1;
        this.sprite = new ImageView(new Image(getClass().getResource("/images/blocks/void.png").toExternalForm()));
    }

    public Block(int l, BlockType t, BlockSubtype stype, int o, ImageView s)
    {
        this.level = l;
        this.type = t;
        this.subtype = stype;
        this.orientation = o;
        this.sprite = s;
    }

    // [METHODS]

    //* Gets the block's level */
    public int getLevel()
    {
        return this.level;
    }

    //* Gets the block's Type */
    public BlockType getType()
    {
        return this.type;
    }

    //* Gets the block's Subtype */
    public BlockSubtype getSubType()
    {
        return this.subtype;
    }

    //* Gets the block's ContainedObject */
    public Object getContainedObject()
    {
        return this.containedObject;
    }

    //* Gets the block's Orientation */
    public int getOrientation()
    {
        return this.orientation;
    }

    //* Gets the block's Sprite ImageView */
    public ImageView getSprite()
    {
        return this.sprite;
    }

    /**
     * Updates a block to redefine it, Block.containedObject is redefine in following specific methods
     *
     * @param l             New block level
     * @param t             New block type
     * @param stype         New block subtype
     * @param o             New block orientation
     * @param s             New block sprite
     */
    public void updateBlock(int l, BlockType t, BlockSubtype stype, int o, ImageView s)
    {
        this.level = l;
        this.type = t;
        this.subtype = stype;
        this.orientation = o;
        this.sprite = s;
    }

    /**
     * Add an Object / Updates block's conainedObject
     *
     * @param obj           New block containedObject
     */
    public void updateObject(Object obj)
    {
        this.containedObject = obj;
    }

    //* Removes the Object contained in the Block, Block.containedObject gets to null */
    public void removeObject()
    {
        this.containedObject = null;
    }
}
