package ed.enderdeath.mod.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreGenerator  implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) 
	{
		switch(world.provider.dimensionId)
		{
		case -1:
			generateNether(world, random, chunkX * 15,chunkZ * 15);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16,chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16,chunkZ * 16);
			break;
		} 
	}
	 private void generateNether(World world, Random random, int x, int z) {
			for(int i = 0; i < 200; i++)
			{
				
			}
		}
	private void  generateSurface(World world,Random random, int chunkZ, int chunkX)
	{
		for(int i = 0 ; i < 5 ; i++)
		{
			 int yMin = 1;
			 int yMax = 11;
			 
			 int firstBlockX = chunkX + random.nextInt(16);
			 int firstBlockY = yMin + random.nextInt(yMax - yMin );
			 int firstBlockZ = chunkZ + random.nextInt(16);
			 
			 (new WorldGenMinable(enderdeath.RubisOre, 3)).generate(world, random, firstBlockX, firstBlockY, firstBlockZ);
		}
		for(int i = 0 ; i < 5 ; i++)
		{
			 int yMin = 1;
			 int yMax = 10;
			 
			 int firstBlockX = chunkX + random.nextInt(16);
			 int firstBlockY = yMin + random.nextInt(yMax - yMin );
			 int firstBlockZ = chunkZ + random.nextInt(16);
			 
			 (new WorldGenMinable(enderdeath.SaphirOre, 2)).generate(world, random, firstBlockX, firstBlockY, firstBlockZ);
		}
		for(int i = 0 ; i < 4 ; i++)
		{
			 int yMin = 1;
			 int yMax = 10;
			 
			 int firstBlockX = chunkX + random.nextInt(16);
			 int firstBlockY = yMin + random.nextInt(yMax - yMin );
			 int firstBlockZ = chunkZ + random.nextInt(16);
			 
			 (new WorldGenMinable(enderdeath.HulminiOre, 3)).generate(world, random, firstBlockX, firstBlockY, firstBlockZ);
		}
		for(int i = 0 ; i < 3 ; i++)
		{
			 int yMin = 1;
			 int yMax = 9;
			 
			 int firstBlockX = chunkX + random.nextInt(16);
			 int firstBlockY = yMin + random.nextInt(yMax - yMin );
			 int firstBlockZ = chunkZ + random.nextInt(16);
			 
			 (new WorldGenMinable(enderdeath.RoyaliteOre, 2)).generate(world, random, firstBlockX, firstBlockY, firstBlockZ);
		}
		for(int i = 0 ; i < 2 ; i++)
		{
			 int yMin = 1;
			 int yMax = 8;
			 
			 int firstBlockX = chunkX + random.nextInt(16);
			 int firstBlockY = yMin + random.nextInt(yMax - yMin );
			 int firstBlockZ = chunkZ + random.nextInt(16);
			 
			 (new WorldGenMinable(enderdeath.DarkaniteNetherack, 2)).generate(world, random, firstBlockX, firstBlockY, firstBlockZ);
		}

		for(int i = 0 ; i < 3 ; i++)
		{
			 int yMin = 1;
			 int yMax = 11;
			 
			 int firstBlockX = chunkX + random.nextInt(16);
			 int firstBlockY = yMin + random.nextInt(yMax - yMin );
			 int firstBlockZ = chunkZ + random.nextInt(16);
			 
			 (new WorldGenMinable(enderdeath.XpOre, 2)).generate(world, random, firstBlockX, firstBlockY, firstBlockZ);
		}
	
	}
	
	
	private void  generateEnd(World world,Random random, int chunkZ, int chunkX)
	{
		
	}

}
