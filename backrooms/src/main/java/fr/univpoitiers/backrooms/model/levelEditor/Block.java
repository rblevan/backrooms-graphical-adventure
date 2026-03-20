package fr.univpoitiers.backrooms.model.levelEditor;

// [IMPORTS]
import fr.univpoitiers.backrooms.model.enumeration.BlockSubtype;
import fr.univpoitiers.backrooms.model.enumeration.BlockType;
import fr.univpoitiers.backrooms.model.item.Items;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Block {

    // ATTRIBUTES
    private int level;                      // Can be 1 or 2 depending on the level skin we want for the block
    private BlockType type;                 // Block Type, see Type enum
    private BlockSubtype subtype;           // Block Subtype, see Subtype enum
    private Items containedObject;          // Can be Food, Weapon, Spell...
    private int orientation;                // Can be 1, 2, 3 or 4
    private transient ImageView sprite;     // Changes following the other attributes of the block

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
    public Items getContainedObject()
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
     * Transform an existing block to give it properties from another block, making it a perfect copy
     * 
     * @param source            Source block
     */
    public void copyBlock(Block source)
    {
        this.level = source.level;
        this.type = source.type;
        this.subtype = source.subtype;
        this.containedObject = source.containedObject;
        this.orientation = source.orientation;
        this.sprite = source.sprite;
    }

    /**
     * Add an Object / Updates block's conainedObject
     *
     * @param obj           New block containedObject
     */
    public void updateObject(Items obj)
    {
        this.containedObject = obj;
    }

    //* Removes the Object contained in the Block, Block.containedObject gets to null */
    public void removeObject()
    {
        this.containedObject = null;
    }

    //* As the Block's sprite not serializable, we need to rebuild / recharge it thanks to the Block's properties */
    public void rebuildSprite()
    {
        String path = "/images/blocks/";

        path += "level" + level + "/";
        path += type.toString().toLowerCase() + "_";
        path += subtype.toString().toLowerCase() + "_";
        path += orientation + ".png";

        Image image = new Image(getClass().getResourceAsStream(path));
        this.sprite = new ImageView(image);
    }
}
