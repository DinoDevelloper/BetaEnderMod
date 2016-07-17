package ed.enderdeath.mod.entity;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderDragonRed  extends RenderLiving
{
	
	public final ResourceLocation texture = new ResourceLocation(enderdeath.MODID, "textures/entity/DragonRed.png");
	public RenderDragonRed(ModelDragonLeo modelH, float shadow)
	{
		super(modelH, shadow);
	}
	protected ResourceLocation getEntityTexture(EntityLiving living)
	{
		return this.Texture((DragonRed)living);
	}

	public ResourceLocation Texture(DragonRed DragonRED)
	{
		return texture;
	}
	
	
	
	@Override
	public ResourceLocation getEntityTexture(Entity p_110775_1_) {
	
		return texture;
	}

}
