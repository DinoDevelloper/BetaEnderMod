package ed.enderdeath.mod.common;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.Charsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;

@SideOnly(Side.CLIENT)
public class GuiCustomMenu extends GuiScreen implements GuiYesNoCallback
{
    private static final Logger logger = LogManager.getLogger();
    /** The RNG used by the Main Menu Screen. */
    private static final Random rand = new Random();
    /** Counts the number of screen updates. */
    private float updateCounter;
    /** The splash message. */
    private String splashText;
    private GuiButton buttonResetDemo;
    /** Timer used to rotate the panorama, increases every tick. */
    private int panoramaTimer;
    /**
     * Texture allocated for the current viewport of the main menu's panorama background.
     */
    private DynamicTexture viewportTexture;
    private final Object field_104025_t = new Object();
    private String field_92025_p;
    private String field_146972_A;
    private String field_104024_v;
    private String Test;
    private static final ResourceLocation splashTexts = new ResourceLocation("enderdeath", "texts/splashes.txt");
    private static final ResourceLocation minecraftTitleTextures = new ResourceLocation("enderdeath", "textures/minecraft.png");

    private final ResourceLocation backGround = new ResourceLocation("enderdeath", "textures/menu.png"); // faut changer l'id du mod ici

    public static final String field_96138_a = "Please click " + EnumChatFormatting.UNDERLINE + "here" + EnumChatFormatting.RESET + " for more information.";
    private int field_92024_r;
    private int field_92023_s;
    private int field_92022_t;
    private int field_92021_u;
    private int field_92020_v;
    private int field_92019_w;
    private ResourceLocation field_110351_G;

    public GuiCustomMenu()
    {
        this.field_146972_A = field_96138_a;
        this.splashText = null;
        BufferedReader bufferedreader = null;

        try
        {
            ArrayList arraylist = new ArrayList();
            bufferedreader = new BufferedReader(new InputStreamReader(Minecraft.getMinecraft().getResourceManager().getResource(splashTexts).getInputStream(), Charsets.UTF_8));
            String s;

            while((s = bufferedreader.readLine()) != null)
            {
                s = s.trim();

                if(!s.isEmpty())
                {
                    arraylist.add(s);
                }
            }

            if(!arraylist.isEmpty())
            {
                do
                {
                    this.splashText = (String)arraylist.get(rand.nextInt(arraylist.size()));
                }
                while(this.splashText.hashCode() == 125780783);
            }
        }
        catch(IOException ioexception1)
        {
            ;
        }
        finally
        {
            if(bufferedreader != null)
            {
                try
                {
                    bufferedreader.close();
                }
                catch(IOException ioexception)
                {
                    ;
                }
            }
        }

        this.updateCounter = rand.nextFloat();
        this.field_92025_p = "";
        this.Test = "";
        if(!GLContext.getCapabilities().OpenGL20 && !OpenGlHelper.func_153193_b())
        {
            this.field_92025_p = I18n.format("title.oldgl1", new Object[0]);
            this.field_146972_A = I18n.format("title.oldgl2", new Object[0]);
            this.field_104024_v = "https://help.mojang.com/customer/portal/articles/325948?ref=game";

        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        ++this.panoramaTimer;
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char p_73869_1_, int p_73869_2_)
    {}

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.viewportTexture = new DynamicTexture(854, 480);
        this.field_110351_G = this.mc.getTextureManager().getDynamicTextureLocation("background", this.viewportTexture);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        if(calendar.get(2) + 1 == 11 && calendar.get(5) == 9)
        {
            this.splashText = "Happy birthday, ez!";
        }
        else if(calendar.get(2) + 1 == 6 && calendar.get(5) == 1)
        {
            this.splashText = "Happy birthday, Notch!";
        }
        else if(calendar.get(2) + 1 == 12 && calendar.get(5) == 24)
        {
            this.splashText = "Merry X-mas!";
        }
        else if(calendar.get(2) + 1 == 1 && calendar.get(5) == 1)
        {
            this.splashText = "Happy new year!";
        }
        else if(calendar.get(2) + 1 == 10 && calendar.get(5) == 31)
        {
            this.splashText = "OOoooOOOoooo! Spooky!";
        }

        boolean flag = true;
        int i = this.height / 4 + 48;

        if(this.mc.isDemo())
        {
            this.addDemoButtons(i, 24);
        }
        else
        {
            this.addSingleplayerMultiplayerButtons(i, 24);
        }

        this.buttonList.add(new GuiButton(4, this.width / 2 + 2, i + 72 + 12, 98, 20, I18n.format("menu.quit", new Object[0])));
        Object object = this.field_104025_t;

        synchronized(this.field_104025_t)
        {
            this.field_92023_s = this.fontRendererObj.getStringWidth(this.field_92025_p);
            this.field_92024_r = this.fontRendererObj.getStringWidth(this.field_146972_A);
            int j = Math.max(this.field_92023_s, this.field_92024_r);
            this.field_92022_t = (this.width - j) / 2;
            this.field_92021_u = ((GuiButton)this.buttonList.get(0)).yPosition - 24;
            this.field_92020_v = this.field_92022_t + j;
            this.field_92019_w = this.field_92021_u + 24;
        }
    }

    /**
     * Adds Singleplayer and Multiplayer buttons on Main Menu for players who have bought the game.
     */
    private void addSingleplayerMultiplayerButtons(int x, int y)
    {
        this.buttonList.add(new GuiButton(22, this.width / 2 + 102, x + 0, 98, 20, I18n.format("\u00A7dTeamspeak")));

        GuiButton webSiteButton2 = new GuiButton(23, this.width / 3 + 155, x + y * 2, "\u00A7cYoutube");
        this.buttonList.add(new GuiButton(20, this.width / 2 - 96, 35 + y * 2, "\u00A7cRejoindre \u00A7aEnderdeath"));
        GuiButton webSiteButton = new GuiButton(21, this.width / 3 - 100, x + y * 2, "\u00A7bTwitter");
        this.buttonList.add(new GuiButton(24, this.width / 2 - 194, x + 1, 98, 20, I18n.format("\u00A7eSite")));
        webSiteButton.width = 100;
        webSiteButton2.width = 100;

        this.buttonList.add(webSiteButton);
        this.buttonList.add(webSiteButton2);

    }

    /**
     * Adds Demo buttons on Main Menu for players who are playing Demo.
     */
    private void addDemoButtons(int x, int y)
    {
        this.buttonList.add(new GuiButton(11, this.width / 2 - 100, x, I18n.format("menu.playdemo", new Object[0])));
        this.buttonList.add(this.buttonResetDemo = new GuiButton(12, this.width / 2 - 100, x + y * 1, I18n.format("menu.resetdemo", new Object[0])));
        ISaveFormat isaveformat = this.mc.getSaveLoader();
        WorldInfo worldinfo = isaveformat.getWorldInfo("Demo_World");

        if(worldinfo == null)
        {
            this.buttonResetDemo.enabled = false;
        }
    }

    protected void actionPerformed(GuiButton button)
    {

        if(button.id == 5)
        {
            this.mc.displayGuiScreen(new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
        }

        if(button.id == 1)
        {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        }

        if(button.id == 2)
        {

        }

        if(button.id == 4)
        {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));

        }

        if(button.id == 11)
        {
            this.mc.launchIntegratedServer("Demo_World", "Demo_World", DemoWorldServer.demoWorldSettings);
        }

        if(button.id == 12)
        {
            ISaveFormat isaveformat = this.mc.getSaveLoader();
            WorldInfo worldinfo = isaveformat.getWorldInfo("Demo_World");

            if(worldinfo != null)
            {
                GuiYesNo guiyesno = GuiSelectWorld.func_152129_a(this, worldinfo.getWorldName(), 12);
                this.mc.displayGuiScreen(guiyesno);
            }
        }
        if(button.id == 22)
        {
            ISaveFormat isaveformat = this.mc.getSaveLoader();
            WorldInfo worldinfo = isaveformat.getWorldInfo("Demo_World");

            if(worldinfo != null)
            {
                GuiYesNo guiyesno = GuiSelectWorld.func_152129_a(this, worldinfo.getWorldName(), 12);
                this.mc.displayGuiScreen(guiyesno);
            }
        }
        if(button.id == 20)
        {
            // TODO pour la connexion au serveur
            FMLClientHandler.instance().connectToServerAtStartup("enderdeath.craft.gg", 10048); // ip, port
        }

        if(button.id == 22)
        {

            if(Desktop.isDesktopSupported())
            {
                try
                {
                    Desktop.getDesktop().browse(new URI("ts3server://ts.enderdeath.fr?port=9987"));
                }
                catch(Exception e)
                {

                }
            }
        }

        if(button.id == 24)
        {
            try
            {
                Class oclass = Class.forName("java.awt.Desktop");
                Object object = oclass.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
                oclass.getMethod("browse", new Class[] {URI.class}).invoke(object, new Object[] {new URI("https://www.youtube.com/channel/UCKHsenokwTlMeZmIVq62TLw")});
            }
            catch(Throwable throwable)
            {
                logger.error("Couldn\'t open link", throwable);
            }
        }
        if(button.id == 23)
        {
            try
            {
                Class oclass = Class.forName("java.awt.Desktop");
                Object object = oclass.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
                oclass.getMethod("browse", new Class[] {URI.class}).invoke(object, new Object[] {new URI("https://www.youtube.com/channel/UCKHsenokwTlMeZmIVq62TLw")});
            }
            catch(Throwable throwable)
            {
                logger.error("Couldn\'t open link", throwable);
            }
        }
        if(button.id == 21)
        {
            try
            {
                Class oclass = Class.forName("java.awt.Desktop");
                Object object = oclass.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
                oclass.getMethod("browse", new Class[] {URI.class}).invoke(object, new Object[] {new URI("https://twitter.com/Ender_Death")});
            }

            catch(Throwable throwable)
            {
                logger.error("Couldn\'t open link", throwable);

            }
        }

    }

    public void confirmClicked(boolean p_73878_1_, int id)
    {
        if(p_73878_1_ && id == 12)
        {
            ISaveFormat isaveformat = this.mc.getSaveLoader();
            isaveformat.flushCache();
            isaveformat.deleteWorldDirectory("Demo_World");
            this.mc.displayGuiScreen(this);
        }
        else if(id == 13)
        {
            if(p_73878_1_)
            {
                try
                {
                    Class oclass = Class.forName("java.awt.Desktop");
                    Object object = oclass.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
                    oclass.getMethod("browse", new Class[] {URI.class}).invoke(object, new Object[] {new URI(this.field_104024_v)});
                }
                catch(Throwable throwable)
                {
                    logger.error("Couldn\'t open link", throwable);
                }
            }

            this.mc.displayGuiScreen(this);
        }
    }

    private void renderBackGround()
    {
        GL11.glViewport(0, 0, 256, 256);
        this.mc.getTextureManager().bindTexture(backGround);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
        int k = this.width;
        int l = this.height;
        tessellator.addVertexWithUV(0, 0, this.zLevel, 0, 0);
        tessellator.addVertexWithUV(0, l, this.zLevel, 0, 1);
        tessellator.addVertexWithUV(k, l, this.zLevel, 1, 1);
        tessellator.addVertexWithUV(k, 0, this.zLevel, 1, 0);
        tessellator.draw();
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int x, int y, float partialTick)
    {
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        this.renderBackGround();
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        Tessellator tessellator = Tessellator.instance;
        short short1 = 274;
        int k = this.width / 2 - short1 / 2;
        byte b0 = 30;
        this.drawGradientRect(0, 0, this.width, this.height, -2130706433, 16777215);
        this.drawGradientRect(0, 0, this.width, this.height, 0, Integer.MIN_VALUE);
        this.mc.getTextureManager().bindTexture(minecraftTitleTextures);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        if((double)this.updateCounter < 1.0E-4D)
        {
            this.drawTexturedModalRect(k + 0, b0 + 0, 0, 0, 99, 44);
            this.drawTexturedModalRect(k + 99, b0 + 0, 129, 0, 27, 44);
            this.drawTexturedModalRect(k + 99 + 26, b0 + 0, 126, 0, 3, 44);
            this.drawTexturedModalRect(k + 99 + 26 + 3, b0 + 0, 99, 0, 26, 44);
            this.drawTexturedModalRect(k + 155, b0 + 0, 0, 45, 155, 44);
        }
        else
        {
            this.drawTexturedModalRect(k + 0, b0 + 0, 0, 0, 155, 44);
            this.drawTexturedModalRect(k + 155, b0 + 0, 0, 45, 155, 44);
        }

        tessellator.setColorOpaque_I(-1);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(this.width / 2 + 90), 70.0F, 0.0F);
        GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
        float f1 = 1.8F - MathHelper.abs(MathHelper.sin((float)(Minecraft.getSystemTime() % 1000L) / 1000.0F * (float)Math.PI * 2.0F) * 0.1F);
        f1 = f1 * 100.0F / (float)(this.fontRendererObj.getStringWidth(this.splashText) + 32);
        GL11.glScalef(f1, f1, f1);
        this.drawCenteredString(this.fontRendererObj, this.splashText, 0, -8, -256);
        GL11.glPopMatrix();
        String s = "Enderdeath 1.7.10";

        if(this.mc.isDemo())
        {
            s = s + " Demo";
        }

        List<String> brandings = Lists.reverse(FMLCommonHandler.instance().getBrandings(true));
        for(int i = 0; i < brandings.size(); i++)
        {
            String brd = brandings.get(i);
            if(!Strings.isNullOrEmpty(brd))
            {
                this.drawString(this.fontRendererObj, brd, 2, this.height - (10 + i * (this.fontRendererObj.FONT_HEIGHT + 1)), 16777215);
            }
        }
        String s1 = "\u00A74By leo01418";
        String s3 = "\u00A74CopyRight Enderdeath V1.0";

        this.drawString(this.fontRendererObj, s1, this.width - this.fontRendererObj.getStringWidth(s1) - 2, this.height - 10, -1);
        this.drawString(this.fontRendererObj, s3, this.width - this.fontRendererObj.getStringWidth(s3) - 2, this.height - 20, -1);

        if(this.field_92025_p != null && this.field_92025_p.length() > 0)
        {
            drawRect(this.field_92022_t - 2, this.field_92021_u - 2, this.field_92020_v + 2, this.field_92019_w - 1, 1428160512);
            this.drawString(this.fontRendererObj, this.field_92025_p, this.field_92022_t, this.field_92021_u, -1);
            this.drawString(this.fontRendererObj, this.field_146972_A, (this.width - this.field_92024_r) / 2, ((GuiButton)this.buttonList.get(0)).yPosition - 12, -1);
        }

        super.drawScreen(x, y, partialTick);
    }

    /**
     * Called when the mouse is clicked.
     */
    protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
        Object object = this.field_104025_t;

        synchronized(this.field_104025_t)
        {
            if(this.field_92025_p.length() > 0 && p_73864_1_ >= this.field_92022_t && p_73864_1_ <= this.field_92020_v && p_73864_2_ >= this.field_92021_u && p_73864_2_ <= this.field_92019_w)
            {
                GuiConfirmOpenLink guiconfirmopenlink = new GuiConfirmOpenLink(this, this.field_104024_v, 13, true);
                guiconfirmopenlink.func_146358_g();
                this.mc.displayGuiScreen(guiconfirmopenlink);
            }
        }
    }
}