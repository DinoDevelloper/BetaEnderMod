package ed.enderdeath.mod.Event;

import java.io.IOException;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class TickHandler
{

    private Minecraft mc;

    public TickHandler(Minecraft mc)
    {
        this.mc = mc;
    }

    @SubscribeEvent
    public void onRenderTick(RenderTickEvent event)
    {
        if(event.phase == Phase.START)
        {
            checkTexture();
        }
    }

    private void checkTexture()
    {
        if(mc.thePlayer != null)
        {
             if(TickHandler.hasIllegalTexture())
             {
                   System.err.println("CHEATEUR DECTETER [ENVOIE/LVD]");

                   Minecraft.getMinecraft().shutdown();
             }

        }
    }

    public static boolean hasIllegalTexture()
    {
        ResourceLocation r = new ResourceLocation("minecraft:textures/blocks/stone.png");
        ITextureObject textureObject = Minecraft.getMinecraft().getTextureManager().getTexture(r);
        if(textureObject == null)
        {
            textureObject = new SimpleTexture(r);
            Minecraft.getMinecraft().getTextureManager().loadTexture(r, textureObject);
        }
        int id = textureObject.getGlTextureId();
        try
        {
            int[] textureData = TextureUtil.readImageData(Minecraft.getMinecraft().getResourceManager(), r);
            for(int color : textureData)
            {
                int alpha = color >> 24 & 0xFF;
                if(alpha != 255)
                {
                    return true;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}

