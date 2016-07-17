package ed.enderdeath.mod.entity;
import org.lwjgl.opengl.GL11;

import ed.enderdeath.mod.common.enderdeath;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;

public class RenderKinggolbin extends RenderBiped
{
	public final ResourceLocation texture = new ResourceLocation(enderdeath.MODID, "textures/entity/GoblinKing.png");
	public RenderKinggolbin(ModelBiped model,float shadow) {
		
		super(model, shadow);
		
	}
	protected ResourceLocation getEntityTexture(EntityLiving living)
	{
		return this.Texture((GoblinKing)living);
	}

	private ResourceLocation Texture(GoblinKing GoblinKing)
	{
		return texture;
	}

	public void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleMob((EntityMob)par1EntityLivingBase, par2);
    }
    protected void scaleMob(EntityMob par1Entitymob, float par2)
    {
            GL11.glScalef(0.775F, 0.775F, 0.775F);

    }
	public void renderHealtBar(GoblinKing mob, double x, double y, double z, float par8, float par9)
	{
		BossStatus.setBossStatus(mob, true);
		super.doRender(mob, x, y, z, par8, par9);
	}
	public void doRender(Entity entity, double x, double y, double z, float par8, float par9)
	{
		this.renderHealtBar((GoblinKing)entity, x, y, z, par8, par9);
	}
}
