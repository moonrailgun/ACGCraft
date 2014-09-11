package com.MRG.ACGCraft.entity;

import scala.reflect.internal.Trees.This;

import com.MRG.ACGCraft.utility.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEndIcePearl extends EntitySnowball{

	public EntityEndIcePearl(World p_i1773_1_) {
		super(p_i1773_1_);
	}

	public EntityEndIcePearl(World world, EntityPlayer entityPlayer) {
		super(world,entityPlayer);
	}

	@Override
	protected void onImpact(MovingObjectPosition movingObjectPosition) {
        if (movingObjectPosition.entityHit != null)
        {
            byte b0 = 0;

            movingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
        }

        for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
        
        //ice create
        if(this.worldObj.isRemote) return;
        
        for(int i=0; i<10; i++)
        {
        	for(int j=0; j<30; j++)
        	{
        		for(int k=0; k<30; k++)
        		{
        			int x = (int)this.posX,y = (int)this.posY,z = (int)this.posZ;
        			
        			creativeIceOrObsidian(this.worldObj, x+j, y+i, z+k);
        			creativeIceOrObsidian(this.worldObj, x+j, y+i, z-k);
        			creativeIceOrObsidian(this.worldObj, x+j, y-i, z-k);
        			creativeIceOrObsidian(this.worldObj, x-j, y+i, z+k);
        			creativeIceOrObsidian(this.worldObj, x-j, y+i, z-k);
        			creativeIceOrObsidian(this.worldObj, x-j, y-i, z-k);
        		}
        	}
        }
        
        
        
        
	}
	
	private void creativeIceOrObsidian(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		
		if(block == Blocks.water || block == Blocks.flowing_water)
		{
			world.setBlock(x, y, z, Blocks.ice);
		}else if(block == Blocks.lava || block == Blocks.flowing_lava){
			world.setBlock(x, y, z, Blocks.obsidian);
		}else{
			return;
		}
	}
}
