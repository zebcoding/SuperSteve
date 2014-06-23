package uk.zebcoding.supersteve.client.render.blocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;
import uk.zebcoding.supersteve.common.tileentity.TileEntitySewingMachine;
import uk.zebcoding.supersteve.init.SSItems;
import uk.zebcoding.supersteve.lib.Reference;

/**
 * Created by Charlotte on 19/06/2014.
 */
public class RenderSewingMachine extends TileEntitySpecialRenderer {

  private static final ResourceLocation MODEL_LOC = new ResourceLocation(Reference.SS_ID, "models/ss_sewingmachine.obj");
  private IModelCustom model = AdvancedModelLoader.loadModel(MODEL_LOC);
  private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.SS_ID, "textures/blocks/ss_sewingmachine.png");

  @Override
  public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {
    GL11.glPushMatrix();

    TileEntitySewingMachine machine = (TileEntitySewingMachine) tileEntity;
    ForgeDirection orientation = machine.getOrientation();

    if (orientation == ForgeDirection.EAST || orientation == ForgeDirection.WEST) {
      GL11.glTranslated(x + 0.75, y, z + 1);
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
    } else {
      GL11.glTranslated(x, y, z + 0.75);
    }

    Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);

    model.renderAll();

    TileEntitySewingMachine sewingMachine = (TileEntitySewingMachine) tileEntity;

    ItemStack cloth = sewingMachine.cloth;
    if (cloth != null) {
      GL11.glPushMatrix();

      EntityItem entItem = new EntityItem(Minecraft.getMinecraft().theWorld, 0.0D, 0.0D, 0.0D, cloth);

      entItem.hoverStart = 0.0F;
      RenderItem.renderInFrame = true;
      GL11.glRotatef(180, 0, 1, 1);
      RenderManager.instance.renderEntityWithPosYaw(entItem, -0.05D, -0.5D, 0.2D, 0.0F, 0.0F);
      RenderItem.renderInFrame = false;
      GL11.glPopMatrix();
    }

    if (sewingMachine.cape != null) {
      GL11.glPushMatrix();
      ItemStack stack2 = new ItemStack(SSItems.cape, 1, 0);
      EntityItem entItem2 = new EntityItem(Minecraft.getMinecraft().theWorld, 0.0D, 0.0D, 0.0D, stack2);

      entItem2.hoverStart = 0.0F;
      RenderItem.renderInFrame = true;
      GL11.glRotatef(180, 0, 1, 1);
      GL11.glRotatef(50, 0, 0, 1);
      RenderManager.instance.renderEntityWithPosYaw(entItem2, -0.3D, 0.01D, 0.2D, 0.0F, 0.0F);
      RenderItem.renderInFrame = false;
      GL11.glPopMatrix();
    }

    GL11.glPopMatrix();
  }
}
