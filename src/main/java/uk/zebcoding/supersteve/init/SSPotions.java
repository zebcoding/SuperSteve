package uk.zebcoding.supersteve.init;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import uk.zebcoding.supersteve.common.event.SSEventHooks;
import uk.zebcoding.supersteve.lib.Names;
import uk.zebcoding.supersteve.lib.Reference;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Charlotte on 26/06/2014.
 */
public class SSPotions extends Potion {
  public static Potion frozenTouchPotion;

  protected SSPotions(int par1, boolean par2, int par3) {
    super(par1, par2, par3);
  }

  public static void preInit() {
    Potion[] potionTypes = null;

    for (Field f : Potion.class.getDeclaredFields()) {
      f.setAccessible(true);
      try {
        if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
          Field ssFields = Field.class.getDeclaredField("modifiers");
          ssFields.setAccessible(true);
          ssFields.setInt(f, f.getModifiers() & ~Modifier.FINAL);

          potionTypes = (Potion[]) f.get(null);
          final Potion[] newPotionTypes = new Potion[256];
          System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
          f.set(null, newPotionTypes);
        }
      } catch (Exception e) {
        System.err.println("Severe error, please report to the ZebCoding team:");
        System.err.println(e);
      }

      MinecraftForge.EVENT_BUS.register(new SSEventHooks());
    }
  }

  public static void init() {
    frozenTouchPotion = (new SSPotions(32, false, 0)).setIconIndex(0, 0).setPotionName(Names.Potions.FROZEN_TOUCH);
  }

  @Override
  public boolean hasStatusIcon() {
    Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.SS_ID, "textures/icons/ssPotions.png"));
    return true;
  }
}
