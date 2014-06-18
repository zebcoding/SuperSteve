package uk.zebcoding.supersteve.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import uk.zebcoding.supersteve.init.SSTab;

/**
 * Created by Charlotte on 18/06/2014.
 */
public class BlockSS extends Block {
  public BlockSS(String name) {
    this(Material.rock, name);
  }

  public BlockSS(Material material, String name) {
    super(material);
    setBlockName(name);
    setHardness(2.5F);
    setResistance(10.0F);
    setCreativeTab(SSTab.SS_TAB);
  }
}
