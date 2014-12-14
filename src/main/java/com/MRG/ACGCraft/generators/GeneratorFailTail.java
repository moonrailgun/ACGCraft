package com.MRG.ACGCraft.generators;

import java.util.Random;

import com.MRG.ACGCraft.init.ModBlocks;
import com.MRG.ACGCraft.init.ModItems;
import com.MRG.ACGCraft.utility.LogHelper;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class GeneratorFailTail implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case 0:
				generateSurface(world, random, chunkX, chunkZ);
				break;
			default:
				break;
		}
	}
	
	private void generateSurface(World world, Random rand,int block_x, int block_z)
	{
		if(rand.nextInt(4) == 0) return;
		
		int x = block_x * 16 + rand.nextInt(16);
		int z = block_z * 16 + rand.nextInt(16);
		int y = rand.nextInt(30) + 10;//10 to 40
		
		for(int i = 0; i < 4; i++)
		{
			tryCreateBlock(world, x+rand.nextInt(2)-rand.nextInt(2), y+rand.nextInt(2)-rand.nextInt(2), z+rand.nextInt(2)-rand.nextInt(2));
		}
	}
	
	private void tryCreateBlock(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y, z) == Blocks.stone)
		{
			world.setBlock(x, y, z, ModBlocks.FailyTail);
		}
	}
	
}
