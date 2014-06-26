package uk.zebcoding.supersteve.init;

import cpw.mods.fml.common.registry.GameRegistry;
import uk.zebcoding.supersteve.common.block.BlockSS;
import uk.zebcoding.supersteve.common.block.BlockSewingMachine;
import uk.zebcoding.supersteve.lib.Names;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class SSBlocks {
  public static final BlockSS sewingMachine = new BlockSewingMachine();

  public static void init() {
    GameRegistry.registerBlock(sewingMachine, Names.Blocks.SEWING_MACHINE);
  }
}
