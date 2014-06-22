package uk.zebcoding.supersteve.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import uk.zebcoding.supersteve.client.render.blocks.RenderSewingMachine;
import uk.zebcoding.supersteve.client.render.items.RenderSewingMachineItem;
import uk.zebcoding.supersteve.common.SSCommonProxy;
import uk.zebcoding.supersteve.common.tileentity.TileEntitySewingMachine;
import uk.zebcoding.supersteve.init.SSBlocks;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class SSClientProxy extends SSCommonProxy {
  @Override
  public void registerRenderers() {
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySewingMachine.class, new RenderSewingMachine());

    MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(SSBlocks.SEWING_MACHINE), new RenderSewingMachineItem());
  }
}
