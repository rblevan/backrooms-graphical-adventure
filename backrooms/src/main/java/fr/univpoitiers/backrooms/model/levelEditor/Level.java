package fr.univpoitiers.backrooms.model.levelEditor;

public class Level {
    
    // ATTRIBUTES
    private Block[][] blockgrid;
    private final int sizeX = 30;   // Default level size is 30x30 blocks
    private final int sizeY = 30;   // Default level size is 30x30 blocks
    private int spawnX;
    private int spawnY;

    // [CONSTRUCTOR]
    public Level()
    {
        blockgrid = new Block[sizeX][sizeY];

        for(int i = 0; i < sizeX - 1; i++)
        {
            for(int j = 0; i < sizeY - 1; j++)
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
        return this.sizeX;
    }

    //* Gets the Level's sizeY */
    public int getSizeY()
    {
        return this.sizeY;
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
        if(i < 0 || i >= sizeX || j < 0 || j >= sizeY)
        {
            throw new IndexOutOfBoundsException("Block indices out of bounds.");
        }

        return this.blockgrid[i][j];
    }
}
