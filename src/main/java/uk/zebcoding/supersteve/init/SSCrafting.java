package uk.zebcoding.supersteve.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import uk.zebcoding.supersteve.lib.Names;

/**
 * Created by Charlotte on 23/06/2014.
 */
public class SSCrafting {
  public static final ItemStack INFUSED_CLOTH = new ItemStack(SSItems.infusedCloth);
  public static ItemStack clothFlight = new ItemStack(SSItems.infusedCloth);
  public static ItemStack clothSpeed = new ItemStack(SSItems.infusedCloth);
  public static ItemStack clothStrength = new ItemStack(SSItems.infusedCloth);
  public static ItemStack clothFrozenTouch = new ItemStack(SSItems.infusedCloth);
  public static NBTTagCompound nbtFlight = new NBTTagCompound();
  public static NBTTagCompound nbtSpeed = new NBTTagCompound();
  public static NBTTagCompound nbtStrength = new NBTTagCompound();
  public static NBTTagCompound nbtFrozenTouch = new NBTTagCompound();

  public static void init() {
    nbtFlight.setInteger(Names.NBT.POWERS, Names.Powers.FLIGHT);
    nbtSpeed.setInteger(Names.NBT.POWERS, Names.Powers.SPEED);
    nbtStrength.setInteger(Names.NBT.POWERS, Names.Powers.STRENGTH);
    nbtFrozenTouch.setInteger(Names.NBT.POWERS, Names.Powers.FROZEN_TOUCH);

    clothFlight.setTagCompound(nbtFlight);
    clothSpeed.setTagCompound(nbtSpeed);
    clothStrength.setTagCompound(nbtStrength);
    clothFrozenTouch.setTagCompound(nbtFrozenTouch);

    GameRegistry.addRecipe(new ItemStack(SSItems.cape), "WEW", "WWW", "WWW", 'W', Blocks.wool, 'E', Items.emerald);

    GameRegistry.addRecipe(new ItemStack(SSBlocks.sewingMachine), "IIB", "I I", "III", 'I', Items.iron_ingot, 'B', Blocks.iron_block);

    // Cloths
    GameRegistry.addRecipe(INFUSED_CLOTH, " W ", "WEW", " W ", 'W', Blocks.wool, 'E', Items.emerald);
    GameRegistry.addRecipe(clothFlight, " E ", "FCF", " P ", 'E', Items.emerald, 'F', Items.feather, 'C', SSItems.infusedCloth, 'P', Items.ender_pearl);
    GameRegistry.addRecipe(clothSpeed, " E ", "RCR", " G ", 'E', Items.emerald, 'R', Items.redstone, 'C', SSItems.infusedCloth, 'G', Items.golden_boots);
    GameRegistry.addRecipe(clothStrength, " E ", "ICI", " D ", 'E', Items.emerald, 'I', Items.iron_sword, 'C', SSItems.infusedCloth, 'D', Items.diamond_sword);
    GameRegistry.addRecipe(clothFrozenTouch, " E ", "ICI", " B ", 'E', Items.emerald, 'I', Blocks.ice, 'C', SSItems.infusedCloth, 'B', Items.water_bucket);
  }
}
