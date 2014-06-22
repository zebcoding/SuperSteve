package uk.zebcoding.supersteve.common;

import cpw.mods.fml.common.registry.GameRegistry;
import uk.zebcoding.supersteve.common.tileentity.TileEntitySewingMachine;
import uk.zebcoding.supersteve.lib.Names;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class SSCommonProxy {
  public void registerTileEntities() {
    GameRegistry.registerTileEntity(TileEntitySewingMachine.class, "tile." + Names.Blocks.SEWING_MACHINE);
  }

  public void registerRenderers() {
  }
}
