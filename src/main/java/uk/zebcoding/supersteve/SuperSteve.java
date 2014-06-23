package uk.zebcoding.supersteve;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import uk.zebcoding.supersteve.common.SSCommonProxy;
import uk.zebcoding.supersteve.init.SSBlocks;
import uk.zebcoding.supersteve.init.SSCrafting;
import uk.zebcoding.supersteve.init.SSItems;
import uk.zebcoding.supersteve.lib.Reference;

/**
 * Created by Charlotte on 17/06/2014.
 */
@Mod (modid = Reference.SS_ID, name = Reference.SS_NAME, version = Reference.SS_VERSION, acceptedMinecraftVersions = Reference.SS_MCVERSION)
public class SuperSteve {
  @Instance (Reference.SS_ID)
  public static SuperSteve instance;

  @SidedProxy (serverSide = "uk.zebcoding.supersteve.common.SSCommonProxy", clientSide = "uk.zebcoding.supersteve.client.SSClientProxy")
  public static SSCommonProxy proxy;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    SSBlocks.init();

    SSItems.init();

    SSCrafting.init();
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
    proxy.registerTileEntities();

    proxy.registerRenderers();
  }
}
