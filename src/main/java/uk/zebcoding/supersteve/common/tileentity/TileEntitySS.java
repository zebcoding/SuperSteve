package uk.zebcoding.supersteve.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import uk.zebcoding.supersteve.lib.Names;

/**
 * Created by Charlotte on 19/06/2014.
 */
public class TileEntitySS extends TileEntity {
  protected ForgeDirection orientation;
  protected byte state;
  protected String name;
  protected String owner;

  public TileEntitySS() {
    orientation = ForgeDirection.NORTH;
    state = 0;
    name = "";
    owner = "";
  }

  public void setOrientation(ForgeDirection orientation) {
    this.orientation = orientation;
  }

  public ForgeDirection getOrientation() {
    return orientation;
  }

  public void setOrientation(int orientation) {
    this.orientation = ForgeDirection.getOrientation(orientation);
  }

  public byte getState() {
    return state;
  }

  public void setState(byte state) {
    this.state = state;
  }

  public boolean hasName() {
    return name != null && name.length() > 0;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean hasOwner() {
    return owner != null && owner.length() > 0;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  @Override
  public void readFromNBT(NBTTagCompound nbtTagCompound) {
    super.readFromNBT(nbtTagCompound);

    if (nbtTagCompound.hasKey(Names.NBT.ORIENTATION)) {
      this.orientation = ForgeDirection.getOrientation(nbtTagCompound.getByte(Names.NBT.ORIENTATION));
    }

    if (nbtTagCompound.hasKey(Names.NBT.STATE)) {
      this.state = nbtTagCompound.getByte(Names.NBT.STATE);
    }

    if (nbtTagCompound.hasKey(Names.NBT.NAME)) {
      this.name = nbtTagCompound.getString(Names.NBT.NAME);
    }

    if (nbtTagCompound.hasKey(Names.NBT.OWNER)) {
      this.owner = nbtTagCompound.getString(Names.NBT.OWNER);
    }
  }

  @Override
  public void writeToNBT(NBTTagCompound nbtTagCompound) {
    super.writeToNBT(nbtTagCompound);

    nbtTagCompound.setByte(Names.NBT.ORIENTATION, (byte) orientation.ordinal());
    nbtTagCompound.setByte(Names.NBT.STATE, state);

    if (this.hasName()) {
      nbtTagCompound.setString(Names.NBT.NAME, name);
    }

    if (this.hasOwner()) {
      nbtTagCompound.setString(Names.NBT.OWNER, owner);
    }
  }

}
