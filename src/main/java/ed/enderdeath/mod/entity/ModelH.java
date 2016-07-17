// Date: 20/05/2016 20:30:14
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package ed.enderdeath.mod.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelH extends ModelBase
{
  //fields
    ModelRenderer patteGauche;
    ModelRenderer patteDroite;
    ModelRenderer patteAvanGauche;
    ModelRenderer patteAvantDroite;
    ModelRenderer tronc;
    ModelRenderer devantBrasGauche;
    ModelRenderer devantBrasDroit;
    ModelRenderer coup;
    ModelRenderer tete;
    ModelRenderer debutQueue;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
  
  public ModelH()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      patteGauche = new ModelRenderer(this, 0, 0);
      patteGauche.addBox(0F, 0F, 0F, 3, 9, 6);
      patteGauche.setRotationPoint(-3F, 15F, 2F);
      patteGauche.setTextureSize(64, 32);
      patteGauche.mirror = true;
      setRotation(patteGauche, 0F, 0F, 0.296706F);
      patteDroite = new ModelRenderer(this, 0, 0);
      patteDroite.addBox(3F, 0F, 0F, 3, 10, 6);
      patteDroite.setRotationPoint(-6F, 14F, -8F);
      patteDroite.setTextureSize(64, 32);
      patteDroite.mirror = true;
      setRotation(patteDroite, 0F, 0F, 0.2792527F);
      patteAvanGauche = new ModelRenderer(this, 0, 0);
      patteAvanGauche.addBox(0F, 0F, 0F, 3, 7, 6);
      patteAvanGauche.setRotationPoint(4F, 21F, 2F);
      patteAvanGauche.setTextureSize(64, 32);
      patteAvanGauche.mirror = true;
      setRotation(patteAvanGauche, 0F, 0F, 1.570796F);
      patteAvantDroite = new ModelRenderer(this, 0, 0);
      patteAvantDroite.addBox(0F, 0F, 0F, 3, 7, 6);
      patteAvantDroite.setRotationPoint(4F, 21F, -8F);
      patteAvantDroite.setTextureSize(64, 32);
      patteAvantDroite.mirror = true;
      setRotation(patteAvantDroite, 0F, 0F, 1.570796F);
      tronc = new ModelRenderer(this, 0, 0);
      tronc.addBox(0F, 0F, 0F, 8, 20, 16);
      tronc.setRotationPoint(-1F, 0F, -8F);
      tronc.setTextureSize(64, 32);
      tronc.mirror = true;
      setRotation(tronc, 0F, 0F, 0.3839724F);
      devantBrasGauche = new ModelRenderer(this, 0, 0);
      devantBrasGauche.addBox(0F, 2F, 0F, 4, 4, 7);
      devantBrasGauche.setRotationPoint(0F, 1F, 7F);
      devantBrasGauche.setTextureSize(64, 32);
      devantBrasGauche.mirror = true;
      setRotation(devantBrasGauche, 0F, 0F, 0F);
      devantBrasDroit = new ModelRenderer(this, 0, 0);
      devantBrasDroit.addBox(0F, 2F, 0F, 4, 4, 7);
      devantBrasDroit.setRotationPoint(0F, 1F, -14F);
      devantBrasDroit.setTextureSize(64, 32);
      devantBrasDroit.mirror = true;
      setRotation(devantBrasDroit, 0F, 0F, 0F);
      coup = new ModelRenderer(this, 0, 0);
      coup.addBox(0F, 0F, 0F, 4, 4, 6);
      coup.setRotationPoint(0F, -3F, -3F);
      coup.setTextureSize(64, 32);
      coup.mirror = true;
      setRotation(coup, 0F, 0F, 0.2094395F);
      tete = new ModelRenderer(this, 0, 0);
      tete.addBox(0F, 0F, 0F, 9, 9, 9);
      tete.setRotationPoint(0F, -11F, -4F);
      tete.setTextureSize(64, 32);
      tete.mirror = true;
      setRotation(tete, 0F, 0F, 0.2268928F);
      debutQueue = new ModelRenderer(this, 0, 0);
      debutQueue.addBox(0F, 0F, 0F, 12, 3, 4);
      debutQueue.setRotationPoint(-14F, 14F, -2F);
      debutQueue.setTextureSize(64, 32);
      debutQueue.mirror = true;
      setRotation(debutQueue, 0F, 0F, -0.2617994F);
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 8, 3, 4);
      Shape1.setRotationPoint(-18F, 14F, -2F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, -0.0698132F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 3, 7, 4);
      Shape2.setRotationPoint(-7F, 8F, -2F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 4F, -2F, 3, 8, 4);
      Shape3.setRotationPoint(-5F, -1F, 0F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    patteGauche.render(f5);
    patteDroite.render(f5);
    patteAvanGauche.render(f5);
    patteAvantDroite.render(f5);
    tronc.render(f5);
    devantBrasGauche.render(f5);
    devantBrasDroit.render(f5);
    coup.render(f5);
    tete.render(f5);
    debutQueue.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
