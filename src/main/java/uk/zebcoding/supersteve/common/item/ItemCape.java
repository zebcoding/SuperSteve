package uk.zebcoding.supersteve.common.item;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import uk.zebcoding.supersteve.lib.Names;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class ItemCape extends ItemSS {
  public ItemCape() {
    super(Names.Items.CAPE);
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    if (entityPlayer.isSneaking()) {
      NBTTagCompound tagCompound = itemStack.stackTagCompound;

      if(tagCompound != null) {
        if (!tagCompound.getBoolean(Names.NBT.ACTIVE)) {
          tagCompound.setBoolean(Names.NBT.ACTIVE, true);
        } else {
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

    itemStack.stackTagCompound = tagCompound;

    return itemStack;
  }
}
