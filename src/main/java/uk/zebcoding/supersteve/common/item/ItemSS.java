package uk.zebcoding.supersteve.common.item;

import net.minecraft.item.Item;
import uk.zebcoding.supersteve.init.SSTab;
import uk.zebcoding.supersteve.lib.Reference;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class ItemSS extends Item {
  public ItemSS(String name) {
    setUnlocalizedName(name);
    setTextureName(Reference.SS_ID + ":"
        + getUnlocalizedName().substring(5));
    setMaxStackSize(1);
    setCreativeTab(SSTab.SS_TAB);
    setNoRepair();
  }
}
