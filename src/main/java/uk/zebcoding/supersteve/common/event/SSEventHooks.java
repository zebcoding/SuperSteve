package uk.zebcoding.supersteve.common.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import uk.zebcoding.supersteve.init.SSPotions;

/**
 * Created by Charlotte on 26/06/2014.
 */
public class SSEventHooks {

  @SubscribeEvent
  public void onEntityUpdate(LivingUpdateEvent event) {
    if (event.entityLiving instanceof EntityPlayer) {
      EntityPlayer entityPlayer = (EntityPlayer) event.entityLiving;

      //Frozen Touch
      if (event.entityLiving.isPotionActive(SSPotions.frozenTouchPotion)) {
        for (int x = -3; x <= 3; x++) {
          for (int z = -3; z <= 3; z++) {
            Block block = entityPlayer.worldObj.getBlock((int) entityPlayer.posX + x, (int) entityPlayer.posY - 1, (int) entityPlayer.posZ + z);

            if (block == Blocks.water) {
              entityPlayer.worldObj.setBlock((int) entityPlayer.posX + x, (int) entityPlayer.posY - 1, (int) entityPlayer.posZ + z, Blocks.ice);
            }
          }
        }
      }
    }
  }

}
