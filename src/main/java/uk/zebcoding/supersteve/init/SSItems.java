package uk.zebcoding.supersteve.init;

import cpw.mods.fml.common.registry.GameRegistry;
import uk.zebcoding.supersteve.common.item.ItemCape;
import uk.zebcoding.supersteve.common.item.ItemInfusedCloth;
import uk.zebcoding.supersteve.common.item.ItemSS;
import uk.zebcoding.supersteve.lib.Names;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class SSItems {
  public static final ItemSS cape = new ItemCape();
  public static final ItemSS infusedCloth = new ItemInfusedCloth();

  public static void init() {
    GameRegistry.registerItem(cape, Names.Items.CAPE);
    GameRegistry.registerItem(infusedCloth, Names.Items.INFUSED_CLOTH);
  }
}
