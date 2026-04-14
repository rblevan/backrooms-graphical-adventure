package fr.univpoitiers.backrooms.model.levelEditor;

public class Level {
    
    // ATTRIBUTES
    private Block[][] blockgrid;
    private static final int SIZE_X = 30;   // Default level size is 30x30 blocks
    private static final int SIZE_Y = 30;   // Default level size is 30x30 blocks
    private int spawnX;
    private int spawnY;

    // [CONSTRUCTOR]
    public Level ()
    {
        blockgrid = new Block[SIZE_X][SIZE_Y];

        for(int i = 0; i < SIZE_X; i++)
        {
            for(int j = 0; j < SIZE_Y; j++)
            {
                blockgrid[i][j] = new Block();
            }
        }

        this.spawnX = 0;
        this.spawnY = 0;
    }

    // [METHODS]

    //* Gets the Level's blockgrid */
    public Block[][] getBlockgrid()
    {
        return this.blockgrid;
    }

    /**
     * Sets the blockgrid to copy another blockgrid (from charged level.json for example)
     *
     * @param bg    Source blockgrid
     */
    public void setBlockgrid(Block[][]bg)
    {
        this.blockgrid = bg;
    }

    //* Gets the Level's sizeX */
    public int getSizeX()
    {
        return Level.SIZE_X;
    }

    //* Gets the Level's sizeY */
    public int getSizeY()
    {
        return Level.SIZE_Y;
    }

    //* Gets the Level's spawnX */
    public int getSpawnX()
    {
        return this.spawnX;
    }

    //* Gets the Level's spawnY */
    public int getSpawnY()
    {
        return this.spawnY;
    }

    /**
     * Gets a desired Block of the blockgrid
     *
     * @param i     X index of the block in the blockgrid
     * @param j     Y index of the block in the blockgrid
     */
    public Block getBlock(int i, int j)
    {
        // First, we check if i and j have valid values
        if((i < 0) || (i >= SIZE_X) || (j < 0) || (j >= SIZE_Y))
        {
            throw new IndexOutOfBoundsException("Block index out of bounds.");
        }

        return this.blockgrid[i][j];
    }

    /**
     * Sets a desired Block of the blockgrid
     *
     * @param i             X index of the block in the blockgrid
     * @param j             Y index of the block in the blockgrid
     * @param sourceBlock   The source Block that will be set into the Level's Block[][] blockgrid[i][j] 
     */
    public void setBlock(int i, int j, Block sourceBlock)
    {
        // First, we check if i and j have valid values
        if((i < 0) || (i >= SIZE_X) || (j < 0) || (j >= SIZE_Y))
        {
            throw new IndexOutOfBoundsException("Block index out of bounds.");
        }

        this.blockgrid[i][j] = sourceBlock;
    }
}
