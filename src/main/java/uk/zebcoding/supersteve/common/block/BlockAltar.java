package uk.zebcoding.supersteve.common.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class BlockAltar extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Pillar1;
    ModelRenderer Pillar2;
    ModelRenderer Pillar3;
    ModelRenderer Pillar4;
    ModelRenderer MidPlane;
    ModelRenderer Corner1;
    ModelRenderer Corner2;
    ModelRenderer Corner3;
    ModelRenderer Corner4;
    ModelRenderer TopPlane;
  
  public BlockAltar()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 0, 47);
      Base.addBox(0F, 23F, -1F, 14, 3, 14);
      Base.setRotationPoint(-7F, -3F, -6F);
      Base.setTextureSize(64, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Pillar1 = new ModelRenderer(this, 0, 0);
      Pillar1.addBox(0F, 0F, 0F, 4, 7, 4);
      Pillar1.setRotationPoint(-7F, 13F, -2F);
      Pillar1.setTextureSize(64, 64);
      Pillar1.mirror = true;
      setRotation(Pillar1, 0F, 0F, 0F);
      Pillar2 = new ModelRenderer(this, 20, 17);
      Pillar2.addBox(0F, 0F, 0F, 4, 7, 4);
      Pillar2.setRotationPoint(-2F, 13F, -3F);
      Pillar2.setTextureSize(64, 64);
      Pillar2.mirror = true;
      setRotation(Pillar2, 0F, 1.570796F, 0F);
      Pillar3 = new ModelRenderer(this, 0, 0);
      Pillar3.addBox(0F, 0F, 0F, 4, 7, 4);
      Pillar3.setRotationPoint(3F, 13F, -2F);
      Pillar3.setTextureSize(64, 64);
      Pillar3.mirror = true;
      setRotation(Pillar3, 0F, 0F, 0F);
      Pillar4 = new ModelRenderer(this, 0, 0);
      Pillar4.addBox(0F, 0F, 0F, 4, 7, 4);
      Pillar4.setRotationPoint(-2F, 13F, 3F);
      Pillar4.setTextureSize(64, 64);
      Pillar4.mirror = true;
      setRotation(Pillar4, 0F, 0F, 0F);
      MidPlane = new ModelRenderer(this, 0, 47);
      MidPlane.addBox(0F, 0F, 0F, 14, 1, 14);
      MidPlane.setRotationPoint(-7F, 12F, -7F);
      MidPlane.setTextureSize(64, 64);
      MidPlane.mirror = true;
      setRotation(MidPlane, 0F, 0F, 0F);
      Corner1 = new ModelRenderer(this, 0, 14);
      Corner1.addBox(0F, 0F, 0F, 2, 2, 2);
      Corner1.setRotationPoint(5F, 10F, 5F);
      Corner1.setTextureSize(64, 64);
      Corner1.mirror = true;
      setRotation(Corner1, 0F, 0F, 0F);
      Corner2 = new ModelRenderer(this, 0, 14);
      Corner2.addBox(0F, 0F, 0F, 2, 2, 2);
      Corner2.setRotationPoint(5F, 10F, -7F);
      Corner2.setTextureSize(64, 64);
      Corner2.mirror = true;
      setRotation(Corner2, 0F, 0F, 0F);
      Corner3 = new ModelRenderer(this, 0, 14);
      Corner3.addBox(0F, 0F, 0F, 2, 2, 2);
      Corner3.setRotationPoint(-7F, 10F, -7F);
      Corner3.setTextureSize(64, 64);
      Corner3.mirror = true;
      setRotation(Corner3, 0F, 0F, 0F);
      Corner4 = new ModelRenderer(this, 0, 14);
      Corner4.addBox(0F, 0F, 0F, 2, 2, 2);
      Corner4.setRotationPoint(-7F, 10F, 5F);
      Corner4.setTextureSize(64, 64);
      Corner4.mirror = true;
      setRotation(Corner4, 0F, 0F, 0F);
      TopPlane = new ModelRenderer(this, 0, 32);
      TopPlane.addBox(0F, 0F, 0F, 14, 1, 14);
      TopPlane.setRotationPoint(-7F, 9F, -7F);
      TopPlane.setTextureSize(64, 64);
      TopPlane.mirror = true;
      setRotation(TopPlane, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    Pillar1.render(f5);
    Pillar2.render(f5);
    Pillar3.render(f5);
    Pillar4.render(f5);
    MidPlane.render(f5);
    Corner1.render(f5);
    Corner2.render(f5);
    Corner3.render(f5);
    Corner4.render(f5);
    TopPlane.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
    super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
  }

}
