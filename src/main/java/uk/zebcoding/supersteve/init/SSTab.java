package uk.zebcoding.supersteve.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import uk.zebcoding.supersteve.lib.Reference;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class SSTab {
  public static final CreativeTabs SS_TAB = new CreativeTabs(Reference.SS_ID) {
    @Override
    public Item getTabIconItem() {
      return Items.bucket;
    }
  };
}
