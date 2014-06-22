package uk.zebcoding.supersteve.client.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import uk.zebcoding.supersteve.lib.Reference;

/**
 * Created by Charlotte on 19/06/2014.
 */
public class RenderSewingMachineItem implements IItemRenderer {

  private static final ResourceLocation MODEL_LOC = new ResourceLocation(Reference.SS_ID, "models/ss_sewingmachine.obj");
  private IModelCustom model = AdvancedModelLoader.loadModel(MODEL_LOC);
  private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.SS_ID, "textures/blocks/ss_sewingmachine.png");

  @Override
  public boolean handleRenderType(ItemStack item, ItemRenderType type) {
    return true;
  }

  @Override
  public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
    return true;
  }

  @Override
  public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    switch (type) {
      case ENTITY:
        render(0.0F, 0.0F, 0.0F, 0.0F);
        return;
      case EQUIPPED:
        render(0.0F, 0.0F, 0.8F, 0.0F);
        return;
      case EQUIPPED_FIRST_PERSON:
        render(-1F, 0.4F, 0.8F, 90.0F);
        return;
      case INVENTORY:
        render(0.0F, -0.8F, 0.8F, 180.0F);
        return;
    }
  }

  private void render(float x, float y, float z, float rot) {
    GL11.glPushMatrix();
    GL11.glRotatef(rot, 0.0F, 1.0F, 0.0F);
    GL11.glTranslatef(x, y, z);

    Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);

    model.renderAll();
    GL11.glPopMatrix();
  }
}
