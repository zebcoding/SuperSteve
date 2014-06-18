package uk.zebcoding.supersteve.common.item;

import net.minecraft.item.Item;
import uk.zebcoding.supersteve.init.SSTab;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class ItemSS extends Item {
  public ItemSS(String name) {
    setUnlocalizedName(name);
    setMaxStackSize(1);
    setCreativeTab(SSTab.SS_TAB);
    setNoRepair();
  }
}
