package uk.zebcoding.supersteve.common.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import uk.zebcoding.supersteve.init.SSPotions;
import uk.zebcoding.supersteve.lib.Names;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class ItemCape extends ItemSS {
  private boolean onLastUpdate = false;
  private List<Integer> powers = new ArrayList<Integer>();


  public ItemCape() {
    super(Names.Items.CAPE);
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    if (entityPlayer.isSneaking()) {
      NBTTagCompound tagCompound = itemStack.stackTagCompound;

      if (tagCompound != null) {
        int[] recovered = tagCompound.getIntArray(Names.NBT.POWERS);

        for (int i : recovered) {
          powers.add(i);
        }

        if (!tagCompound.getBoolean(Names.NBT.ACTIVE)) {
          tagCompound.setBoolean(Names.NBT.ACTIVE, true);
        } else if (world.getBlock((int) entityPlayer.posX, (int) entityPlayer.posY - 1, (int) entityPlayer.posZ) != Blocks.air) {
          tagCompound.setBoolean(Names.NBT.ACTIVE, false);
        }
      }

      itemStack.stackTagCompound = tagCompound;

    }

    return itemStack;
  }

  @Override
  public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    NBTTagCompound tagCompound = itemStack.stackTagCompound;

    if (tagCompound == null) {
      itemStack = initNBT(itemStack);
    } else {
      if (entity instanceof EntityPlayer) {
        EntityPlayer entityPlayer = (EntityPlayer) entity;
        if (tagCompound.getBoolean(Names.NBT.ACTIVE)) {
          if (powers.contains(Names.Powers.FLIGHT)) {
            entityPlayer.capabilities.allowFlying = true;
          }
          if (powers.contains(Names.Powers.SPEED)) {
            entityPlayer.addPotionEffect(new PotionEffect(1, 10, 2));
          }
          if (powers.contains(Names.Powers.STRENGTH)) {
            entityPlayer.addPotionEffect(new PotionEffect(5, 10, 2));
          }
          if (powers.contains(Names.Powers.FROZEN_TOUCH)) {
            entityPlayer.addPotionEffect(new PotionEffect(SSPotions.frozenTouchPotion.getId(), 10, 2));
          }
          onLastUpdate = true;
        } else if (onLastUpdate && !entityPlayer.capabilities.isCreativeMode) {
          entityPlayer.capabilities.allowFlying = false;
        }
      }
    }
  }

  @Override
  public boolean hasEffect(ItemStack itemStack, int pass) {
    NBTTagCompound tagCompound = itemStack.stackTagCompound;
    return tagCompound != null && tagCompound.getBoolean(Names.NBT.ACTIVE);
  }

  private ItemStack initNBT(ItemStack itemStack) {
    NBTTagCompound tagCompound = new NBTTagCompound();
    tagCompound.setBoolean(Names.NBT.ACTIVE, false);
    int[] powers = { 0 };
    tagCompound.setIntArray(Names.NBT.POWERS, powers);

    itemStack.stackTagCompound = tagCompound;

    return itemStack;
  }

  @Override
  public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean par4) {
    list.add("Powers:");
    if (itemStack.stackTagCompound != null) {
      int[] powers = itemStack.stackTagCompound.getIntArray(Names.NBT.POWERS);
      if (powers.length == 1) {
        list.add(" - None.");
      } else {
        for (int i : powers) {
          switch (i) {
            case Names.Powers.FLIGHT:
              list.add(" - Flight.");
              break;
            case Names.Powers.SPEED:
              list.add(" - Speed.");
              break;
            case Names.Powers.STRENGTH:
              list.add(" - Strength.");
              break;
            case Names.Powers.FROZEN_TOUCH:
              list.add(" - Frozen Touch.");
          }
        }
      }
    } else {
      list.add(" - None.");
    }
  }
}
