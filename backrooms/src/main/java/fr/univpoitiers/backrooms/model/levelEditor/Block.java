package fr.univpoitiers.backrooms.model.levelEditor;

public class Block {

    //BLOCKS ENUMS
    public enum Type {VOID, GROUND, WALL, CORNER}
    public enum Subtype {NONE, INNERCORNER, OUTERCORNER, BEAM1, BEAM2, BEAM3}

    // ATTRIBUTES
    private int level; // Can be 1 or 2 depending on the level skin we want for the block
    private Type type; // Block Type, see Type enum
    private Subtype subtype; // Block Subtype, see Subtype enum
    private Object containedObject; // Can be null, entity, food...
    private int orientation; // Can be 1, 2, 3 or 4

    // [CONSTRUCTOR]
    public Block()
    {
        this.level = 1;
        this.type = Type.VOID;
        this.subtype = Subtype.NONE;
        this.containedObject = null;
        this.orientation = 1;
    }

    // [METHODS]

    //* Gets the block's level */
    public int getLevel()
    {
        return this.level;
    }

    //* Gets the block's Type */
    public Type getType()
    {
        return this.type;
    }

    //* Gets the block's Subtype */
    public Subtype getSubType()
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

    /**
     * Updates a block to redefine it, Block.containedObject is redefine in following specific methods
     *
     * @param l             New block level
     * @param t             New block type
     * @param stype         New block subtype
     * @param o             New block orientation
     */
    public void updateBlock(int l, Type t, Subtype stype, int o)
    {
        this.level = l;
        this.type = t;
        this.subtype = stype;
        this.orientation = o;
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
