package uk.zebcoding.supersteve.common.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import uk.zebcoding.supersteve.common.tileentity.TileEntitySewingMachine;
import uk.zebcoding.supersteve.lib.Names;

/**
 * Created by Charlotte on 19/06/2014.
 */
public class BlockSewingMachine extends BlockSS {
  public BlockSewingMachine() {
    super(Names.Blocks.SEWING_MACHINE);
  }

  @Override
  public int getRenderType() {
    return -1;
  }

  @Override
  public boolean isOpaqueCube() {
    return false;
  }

  @Override
  public boolean renderAsNormalBlock() {
    return false;
  }

  @Override
  public TileEntity createTileEntity(World world, int metadata) {
    return new TileEntitySewingMachine();
  }
}
