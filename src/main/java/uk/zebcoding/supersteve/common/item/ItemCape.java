package uk.zebcoding.supersteve.common.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
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
}
