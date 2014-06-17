package uk.zebcoding.supersteve;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import uk.zebcoding.supersteve.lib.Reference;

/**
 * Created by Charlotte on 17/06/2014.
 */
@Mod(modid = Reference.SS_ID, name = Reference.SS_NAME, version = Reference.SS_VERSION, acceptedMinecraftVersions = Reference.SS_MCVERSION)
public class SuperSteve {
  @Instance(Reference.SS_ID)
  public static SuperSteve instance;
}
