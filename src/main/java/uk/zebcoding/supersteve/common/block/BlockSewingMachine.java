package uk.zebcoding.supersteve.common.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import uk.zebcoding.supersteve.common.tileentity.TileEntitySewingMachine;
import uk.zebcoding.supersteve.init.SSItems;
import uk.zebcoding.supersteve.lib.Names;

/**
 * Created by Charlotte on 19/06/2014.
 */
public class BlockSewingMachine extends BlockSS {
  public BlockSewingMachine() {
    super(Names.Blocks.SEWING_MACHINE);
  }

  @Override
  public int getRenderType() {
    return -1;
  }

  @Override
  public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
    TileEntitySewingMachine tileEntity = (TileEntitySewingMachine) world.getTileEntity(x,y,z);
    ForgeDirection orientation = tileEntity.getOrientation();
    if (orientation == ForgeDirection.NORTH || orientation == ForgeDirection.SOUTH) {
      setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 0.8125F, 0.75F);
    } else {
      setBlockBounds(0.25F, 0.0F, 0.0F, 0.75F, 0.8125F, 1.0F);
    }
  }

  @Override
  public boolean isOpaqueCube() {
    return false;
  }

  @Override
  public boolean renderAsNormalBlock() {
    return false;
  }

  @Override
  public TileEntity createTileEntity(World world, int metadata) {
    return new TileEntitySewingMachine();
  }

  @Override
  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9) {
    if (!entityPlayer.isSneaking()) {
      ItemStack itemStack = entityPlayer.getCurrentEquippedItem();
      TileEntitySewingMachine sewingMachine = (TileEntitySewingMachine) world.getTileEntity(x, y, z);
      if (itemStack != null) {
        if (itemStack.isItemEqual(new ItemStack(SSItems.cape)) && sewingMachine.cape == null) {
          sewingMachine.cape = itemStack;
          entityPlayer.setCurrentItemOrArmor(0, null);
          return true;
        } else if (itemStack.isItemEqual(new ItemStack(SSItems.infusedCloth)) && sewingMachine.cloth == null) {
          sewingMachine.cloth = itemStack;
          entityPlayer.setCurrentItemOrArmor(0, null);
          return true;
        }
      } else if (sewingMachine.cape != null) {
        entityPlayer.setCurrentItemOrArmor(0, sewingMachine.cape);
        sewingMachine.cape = null;
      } else if (sewingMachine.cloth != null) {
        entityPlayer.setCurrentItemOrArmor(0, sewingMachine.cloth);
        sewingMachine.cloth = null;
      }
    }

    return false;
  }
}
