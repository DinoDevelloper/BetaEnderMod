package ed.enderdeath.mod.entity;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderKCreeper extends RenderLiving
{
	public final ResourceLocation texture = new ResourceLocation(enderdeath.MODID, "textures/entity/KCreeper.png");
	public RenderKCreeper(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);

	}
	protected ResourceLocation getEntityTexture(EntityLiving living)
	{
		return this.Texture((KCreeper)living);
	}

	private ResourceLocation Texture(KCreeper KCreeper)
	{
		return texture;
	}
	protected ResourceLocation getEntityTexture(Entity KCreeper) {
		
		return texture;
	}
	
}
