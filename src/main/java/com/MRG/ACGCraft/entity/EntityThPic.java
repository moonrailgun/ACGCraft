package com.MRG.ACGCraft.entity;

import java.util.List;

import com.MRG.ACGCraft.ACGCraft;
import com.MRG.ACGCraft.init.ModItems;
import com.MRG.ACGCraft.utility.LogHelper;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityThPic extends Entity {
	public final static int GRIDS_HEIGHT = 2;
	public final static int GRIDS_WIDTH = 2;
	
	public int hanging_direction;
	public int block_pos_x;
	public int block_pos_y;
	public int block_pos_z;
	public int title_id;
	
	public EntityThPic(World world, int x, int y, int z, int direction, int title_id) {
		super(world);
		LogHelper.info(direction);
		this.block_pos_x = x;
		this.block_pos_y = y;
		this.block_pos_z = z;
		this.hanging_direction = direction;
		this.title_id = title_id;
		
		this.save_params();
		this.init_params();
	}
	
	@Override
	protected void entityInit() {
		this.dataWatcher.addObject(18, 0);
		this.dataWatcher.addObject(19, 0);
		this.dataWatcher.addObject(20, 0);
		this.dataWatcher.addObject(21, 0);
		this.dataWatcher.addObject(22, 0);
	}
	
	private void save_params() {
		this.dataWatcher.updateObject(18, this.hanging_direction);
		this.dataWatcher.updateObject(19, this.block_pos_x);
		this.dataWatcher.updateObject(20, this.block_pos_y);
		this.dataWatcher.updateObject(21, this.block_pos_z);
		this.dataWatcher.updateObject(22, this.title_id);
	}
	
	public void load_params() {
		this.hanging_direction = this.dataWatcher.getWatchableObjectInt(18);
		this.block_pos_x = this.dataWatcher.getWatchableObjectInt(19);
		this.block_pos_y = this.dataWatcher.getWatchableObjectInt(20);
		this.block_pos_z = this.dataWatcher.getWatchableObjectInt(21);
		this.title_id = this.dataWatcher.getWatchableObjectInt(22);
		
		this.init_params();
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound var1) {
		this.hanging_direction = var1.getInteger("hanging_direction");
		this.block_pos_x = var1.getInteger("block_pos_x");
		this.block_pos_y = var1.getInteger("block_pos_y");
		this.block_pos_z = var1.getInteger("block_pos_z");
		this.title_id = var1.getInteger("title_id");
		
		init_params();
		save_params();
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) {
		var1.setInteger("hanging_direction", this.hanging_direction);
		var1.setInteger("block_pos_x", this.block_pos_x);
		var1.setInteger("block_pos_y", this.block_pos_y);
		var1.setInteger("block_pos_z", this.block_pos_z);
		var1.setInteger("title_id", this.title_id);
	}

	public void init_params() {
		int direction = this.hanging_direction;
				
		float half_width = GRIDS_WIDTH / 2.0F;
		float half_height = GRIDS_HEIGHT / 2.0F;
		
		float entity_pos_x;
		float entity_pos_y = this.block_pos_y + half_height;
		float entity_pos_z;
		
		float horizontal_off = 0.0625F; // 1/16
		
		if (direction == 2) {
			entity_pos_x = this.block_pos_x + 1.0F - half_width;
			entity_pos_z = this.block_pos_z - horizontal_off;
			
			this.rotationYaw = this.prevRotationYaw = 180;
			this.setPosition(entity_pos_x, entity_pos_y, entity_pos_z);
			this.boundingBox.setBounds(
					entity_pos_x - half_width, entity_pos_y - half_height, entity_pos_z - horizontal_off, 
					entity_pos_x + half_width, entity_pos_y + half_height, entity_pos_z + horizontal_off
				);
			return;
		}
		
		if (direction == 1) {
			entity_pos_x = this.block_pos_x - horizontal_off;
			entity_pos_z = this.block_pos_z + half_width;
			
			this.rotationYaw = this.prevRotationYaw = 270;
			this.setPosition(entity_pos_x, entity_pos_y, entity_pos_z);
			this.boundingBox.setBounds(
					entity_pos_x - horizontal_off, entity_pos_y - half_height, entity_pos_z - half_width, 
					entity_pos_x + horizontal_off, entity_pos_y + half_height, entity_pos_z + half_width
				);
			return;
		}
		
		if (direction == 0) {
			entity_pos_x = this.block_pos_x + half_width;
			entity_pos_z = this.block_pos_z + 1.0F + horizontal_off;
			
			this.rotationYaw = this.prevRotationYaw = 0;
			this.setPosition(entity_pos_x, entity_pos_y, entity_pos_z);
			this.boundingBox.setBounds(
					entity_pos_x - half_width, entity_pos_y - half_height, entity_pos_z - horizontal_off, 
					entity_pos_x + half_width, entity_pos_y + half_height, entity_pos_z + horizontal_off
				);
			return;
		}
		
		if (direction == 3) {
			entity_pos_x = this.block_pos_x + 1.0F + horizontal_off;
			entity_pos_z = this.block_pos_z + 1.0F - half_width;
			
			this.rotationYaw = this.prevRotationYaw = 90;
			this.setPosition(entity_pos_x, entity_pos_y, entity_pos_z);
			this.boundingBox.setBounds(
					entity_pos_x - horizontal_off, entity_pos_y - half_height, entity_pos_z - half_width, 
					entity_pos_x + horizontal_off, entity_pos_y + half_height, entity_pos_z + half_width
				);
			return;
		}
	}

	public boolean onValidSurface() {
		if (!this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox)
				.isEmpty()) {
			return false;
		}
		
		int x = this.block_pos_x;
		int y = this.block_pos_y;
		int z = this.block_pos_z;
		int direction = this.hanging_direction;

		float half_width = GRIDS_WIDTH / 2.0F;
		float half_height = GRIDS_HEIGHT / 2.0F;
		
		if (direction == 2) {
			x = MathHelper.floor_double(this.posX - half_width);
		}

		if (direction == 1) {
			z = MathHelper.floor_double(this.posZ - half_width);
		}

		if (direction == 0) {
			x = MathHelper.floor_double(this.posX - half_width);
		}

		if (direction == 3) {
			z = MathHelper.floor_double(this.posZ - half_width);
		}

		y = MathHelper.floor_double(this.posY - half_height);
		
		for (int i = 0; i < GRIDS_WIDTH; ++i) {
			for (int j = 0; j < GRIDS_HEIGHT; ++j) {
				Material material;

				if (direction == 1 || direction == 3) {
					material = this.worldObj.getBlock(this.block_pos_x, y + j, z + i).getMaterial();
				} else {
					material = this.worldObj.getBlock(x + i, y + j, this.block_pos_z).getMaterial();
				}

				if (!material.isSolid()) {
					System.out.println("not enough area,cannot to place");
					return false;
				}
			}
		}

		List<?> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox);		
		for(Object entity : list) {
			if (!(entity instanceof EntityThPic)) continue;
			
			System.out.println("To resist,cannot to place" + entity);
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean hitByEntity(Entity par1Entity) {
		return par1Entity instanceof EntityPlayer ? this.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)par1Entity), 0) : false;
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if (this.isEntityInvulnerable())
			return false;
		
		if (!this.isDead && !this.worldObj.isRemote) {
			this.setDead();
			this.setBeenAttacked();
			EntityPlayer var3 = null;

			if (par1DamageSource.getEntity() instanceof EntityPlayer) {
				var3 = (EntityPlayer) par1DamageSource.getEntity();
			}

			if (var3 != null && var3.capabilities.isCreativeMode) {
				return true;
			}

			this.dropItemStack();
		}

		return true;
	}

	public void dropItemStack() {
		this.entityDropItem(new ItemStack(ModItems.ThPic), 0.0F);
	}
	
	@Override
	public boolean canBeCollidedWith() {
		return true;
	}
}
