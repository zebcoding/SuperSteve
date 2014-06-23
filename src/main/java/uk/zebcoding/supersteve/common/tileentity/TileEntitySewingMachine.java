package uk.zebcoding.supersteve.common.tileentity;

import net.minecraft.item.ItemStack;
import uk.zebcoding.supersteve.lib.Names;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlotte on 19/06/2014.
 */
public class TileEntitySewingMachine extends TileEntitySS {
  public ItemStack cape = null;
  public ItemStack cloth = null;

  @Override
  public void updateEntity() {
    if (cape != null && cloth != null) {
      int[] original = cape.stackTagCompound.getIntArray(Names.NBT.POWERS);
      List<Integer> updated = new ArrayList<Integer>();
      for (int i : original) {
        updated.add(i);
      }

      if (cloth.stackTagCompound != null) {
        updated.add(cloth.stackTagCompound.getInteger(Names.NBT.POWERS));

        int[] powers = new int[updated.size()];
        for(int i = 0; i < updated.size(); i++) {
          powers[i] = updated.get(i);
        }

        cape.stackTagCompound.setIntArray(Names.NBT.POWERS, powers);
        cloth = null;
      }
    }
  }
}
