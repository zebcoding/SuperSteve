package uk.zebcoding.supersteve.common.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import uk.zebcoding.supersteve.lib.Names;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class ItemInfusedCloth extends ItemSS {
  public ItemInfusedCloth() {
    super(Names.Items.INFUSED_CLOTH);
  }

  @Override
  public boolean hasEffect(ItemStack itemStack, int pass) {
    return true;
  }

  @Override
  public int getColorFromItemStack(ItemStack par1ItemStack, int par2) {
    return 0xADD8E6;
  }

  @Override
  public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    NBTTagCompound tagCompound = itemStack.stackTagCompound;
    if(tagCompound == null) {
      itemStack = initNBT(itemStack);
    }
  }

  private ItemStack initNBT(ItemStack itemStack) {
    NBTTagCompound tagCompound = new NBTTagCompound();

    tagCompound.setInteger(Names.NBT.POWERS, 0);

    return itemStack;
  }
}
