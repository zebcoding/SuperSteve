package uk.zebcoding.supersteve.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import uk.zebcoding.supersteve.common.tileentity.TileEntitySS;
import uk.zebcoding.supersteve.lib.Names;
import uk.zebcoding.supersteve.lib.Reference;
import uk.zebcoding.supersteve.lib.SSTab;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class BlockSS extends BlockContainer {
  @SideOnly (Side.CLIENT)
  public IIcon icon;

  private String name;

  public BlockSS(String name) {
    this(Material.rock, name);
  }

  public BlockSS(Material material, String name) {
    super(material);
    this.name = name;
    setBlockName(name);
    setHardness(2.5F);
    setResistance(10.0F);
    setCreativeTab(SSTab.SS_TAB);
  }

  @Override
  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack) {
    if (world.getTileEntity(x, y, z) instanceof TileEntitySS) {
      int direction = 0;
      int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

      switch (facing) {
        case 0:
          direction = ForgeDirection.NORTH.ordinal();
          break;
        case 1:
          direction = ForgeDirection.EAST.ordinal();
          break;
        case 2:
          direction = ForgeDirection.SOUTH.ordinal();
          break;
        case 3:
          direction = ForgeDirection.WEST.ordinal();
          break;
      }

      if (itemStack.hasDisplayName()) {
        ((TileEntitySS) world.getTileEntity(x, y, z)).setName(itemStack.getDisplayName());
      }

      ((TileEntitySS) world.getTileEntity(x, y, z)).setOrientation(direction);
    }
  }

  @Override
  public TileEntity createNewTileEntity(World var1, int var2) {
    return null;
  }

  @Override
  public void registerBlockIcons(IIconRegister iconRegister) {
    icon = iconRegister.registerIcon(Reference.SS_ID + ":" + Names.Blocks.SEWING_MACHINE);
  }

  public IIcon getIcon(int side, int meta) {
    return icon;
  }
}
