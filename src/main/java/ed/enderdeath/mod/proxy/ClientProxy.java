package ed.enderdeath.mod.proxy;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;

import cpw.mods.fml.client.registry.RenderingRegistry;
import ed.enderdeath.mod.Armor.ModelTFKnightlyArmor;
import ed.enderdeath.mod.common.enderdeath;
import ed.enderdeath.mod.entity.BomberEntity;
import ed.enderdeath.mod.entity.Boss;
import ed.enderdeath.mod.entity.DragonRed;
import ed.enderdeath.mod.entity.EntityArrowDeath;
import ed.enderdeath.mod.entity.EntityBoatTnT;
import ed.enderdeath.mod.entity.EntityCreeperBoss;
import ed.enderdeath.mod.entity.Familiar;
import ed.enderdeath.mod.entity.Goblin;
import ed.enderdeath.mod.entity.GoblinKing;
import ed.enderdeath.mod.entity.KCreeper;
import ed.enderdeath.mod.entity.KingHeal;
import ed.enderdeath.mod.entity.ModelBoss;
import ed.enderdeath.mod.entity.ModelDragonLeo;
import ed.enderdeath.mod.entity.ModelH;
import ed.enderdeath.mod.entity.RenderArrowD;
import ed.enderdeath.mod.entity.RenderBoaTnT;
import ed.enderdeath.mod.entity.RenderBoss;
import ed.enderdeath.mod.entity.RenderCreeperBoss;
import ed.enderdeath.mod.entity.RenderDragonRed;
import ed.enderdeath.mod.entity.RenderFamiliar;
import ed.enderdeath.mod.entity.RenderGoblin;
import ed.enderdeath.mod.entity.RenderKCreeper;
import ed.enderdeath.mod.entity.RenderKing;
import ed.enderdeath.mod.entity.RenderKinggolbin;
import ed.enderdeath.mod.entity.RenderWolfNether;
import ed.enderdeath.mod.entity.WolfNether;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class ClientProxy extends CommonProxy {
	ModelBiped[] knightlyArmorModel;

	@Override
	public void registerRender() {
		System.out.println("client");
		
		this.setCursor("enderdeath", "/textures/items/ADarkaniteSword.png", 16, 16, 3.1415926536);

		
		



		RenderingRegistry.registerEntityRenderingHandler(KingHeal.class, new RenderKing(new ModelEnderman(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(KCreeper.class, new RenderKCreeper(new ModelCreeper(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCreeperBoss.class, new RenderCreeperBoss(new ModelCreeper(), 0.5F));
		
		knightlyArmorModel = new ModelBiped[4];
		knightlyArmorModel[0] = new ModelTFKnightlyArmor(0, 0.5F);
		RenderingRegistry.registerEntityRenderingHandler(Goblin.class, new RenderGoblin(new ModelZombie(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(EntityBoatTnT.class, new RenderBoaTnT());

		RenderingRegistry.registerEntityRenderingHandler(Familiar.class, new RenderFamiliar(new ModelH(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(DragonRed.class, new RenderDragonRed(new ModelDragonLeo(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(Boss.class, new RenderBoss(new ModelBoss(), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(WolfNether.class,
				new RenderWolfNether(new ModelWitch(0), 0.5F));

		RenderingRegistry.registerEntityRenderingHandler(GoblinKing.class,
				new RenderKinggolbin(new ModelZombie(), 0.5F));

		
		
		RenderingRegistry.registerEntityRenderingHandler(BomberEntity.class, new RenderSnowball(enderdeath.Bomber));

		RenderingRegistry.registerEntityRenderingHandler(EntityArrowDeath.class, new RenderArrowD());
	}

	private void setCursor(String modid, String path, int width, int height, double rotation) {
		AffineTransform transform = new AffineTransform();

		try {
			BufferedImage cursorTexture = ImageIO.read(getClass().getResource("/assets/" + modid + path));
			transform.rotate(rotation, cursorTexture.getWidth() / 2, cursorTexture.getHeight() / 2);

			AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
			cursorTexture = op.filter(cursorTexture, null);

			int[] rgbs = new int[cursorTexture.getWidth() * cursorTexture.getHeight()];

			IntBuffer buffer = IntBuffer.wrap(cursorTexture.getRGB(0, 0, cursorTexture.getWidth(),
					cursorTexture.getHeight(), rgbs, 0, cursorTexture.getHeight()));

			buffer.rewind();

			Cursor newCursor = new Cursor(width, height, 1, cursorTexture.getHeight() - 1, 1, buffer, null);
			Mouse.setNativeCursor(newCursor);
		} catch (LWJGLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ModelBiped getKnightlyArmorModel(int armorSlot) {
		return knightlyArmorModel[armorSlot];
	}
	

}
