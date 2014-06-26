package uk.zebcoding.supersteve.common.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import uk.zebcoding.supersteve.lib.Names;

import javax.lang.model.element.Name;
import java.util.List;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class ItemInfusedCloth extends ItemSS {
  public ItemInfusedCloth() {
    super(Names.Items.INFUSED_CLOTH);
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    if (entityPlayer.capabilities.isCreativeMode && entityPlayer.isSneaking()) {
      NBTTagCompound tagCompound = itemStack.stackTagCompound;

      if (tagCompound != null) {
        int power = tagCompound.getInteger(Names.NBT.POWERS);
        switch (power) {
          case 0:
            power = 1;
            break;
          case 1:
            power = 2;
            break;
          case 2:
            power = 3;
            break;
          case 3:
            power = 4;
            break;
          case 4:
            power = 0;
        }

        itemStack.stackTagCompound.setInteger(Names.NBT.POWERS, power);
      }
    }

    return itemStack;
  }

  @Override
  public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    if(itemStack.stackTagCompound == null) {
      itemStack = initNBT(itemStack);
    }
  }

  @Override
  public int getColorFromItemStack(ItemStack itemStack, int metadata) {
    NBTTagCompound tagCompound = itemStack.stackTagCompound;
    if (tagCompound != null) {
      int colour = tagCompound.getInteger(Names.NBT.POWERS);
      switch (colour) {
        case Names.Powers.FLIGHT:
          return Names.Colours.FLIGHT;
        case Names.Powers.SPEED:
          return Names.Colours.SPEED;
        case Names.Powers.STRENGTH:
          return Names.Colours.STRENGTH;
        case Names.Powers.FROZEN_TOUCH:
          return Names.Colours.FROZEN_TOUCH;
        default:
          return 0xFFFFFF;
      }
    } else {
      return 0xFFFFFF;
    }
  }

  @Override
  public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean par4) {
    list.add("Power:");
    String powerName = " - ";
    try {
      int powerNumber = itemStack.stackTagCompound.getInteger(Names.NBT.POWERS);
      switch (powerNumber) {
        case Names.Powers.FLIGHT:
          powerName += "Flight.";
          break;
        case Names.Powers.SPEED:
          powerName += "Speed.";
          break;
        case Names.Powers.STRENGTH:
          powerName += "Strength.";
          break;
        case Names.Powers.FROZEN_TOUCH:
          powerName += "Frozen Touch.";
          break;
        default:
          powerName += "None.";
      }
    } catch (NullPointerException e) {
      powerName += "None.";
    }
    list.add(powerName);
  }

  private ItemStack initNBT(ItemStack itemStack) {
    itemStack.stackTagCompound = new NBTTagCompound();
    itemStack.stackTagCompound.setInteger(Names.NBT.POWERS, 0);

    return itemStack;
  }
}
