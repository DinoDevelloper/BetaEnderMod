// Date: 02/07/2016 08:56:47
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package ed.enderdeath.mod.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDragonLeo extends ModelBase
{
    // fields
    ModelRenderer patte_gauche_1_orange;
    ModelRenderer patte_gauche2;
    ModelRenderer patte_gauche_3;
    ModelRenderer patte_gauche_4;
    ModelRenderer patte_gauche_5;
    ModelRenderer patte_gauche_6;
    ModelRenderer patte_gauche_7;
    ModelRenderer patte_droite_1_orange;
    ModelRenderer patte_doite_2;
    ModelRenderer patte_droite_3;
    ModelRenderer patte_droite_4;
    ModelRenderer patte_droite_5;
    ModelRenderer patte_droite_6;
    ModelRenderer patte_droite_7;
    ModelRenderer patte_gauche_avant_1;
    ModelRenderer patte_gauche_avant_2;
    ModelRenderer patte_gauche_avant_3;
    ModelRenderer patte_gauche_avant_4;
    ModelRenderer patte_gauche_avant_5;
    ModelRenderer patte_gauche_avant_6;
    ModelRenderer patte_droite_avant_1;
    ModelRenderer patte_droite_avant_2;
    ModelRenderer patte_droite_avant_3;
    ModelRenderer patte_droite_avant_4;
    ModelRenderer patte_droite_avant_5;
    ModelRenderer patte_droite_avant_6;
    ModelRenderer tete_1;
    ModelRenderer tete_2;
    ModelRenderer tete_3;
    ModelRenderer tete_4;
    ModelRenderer tete_5;
    ModelRenderer oeil_gauhe;
    ModelRenderer oeil_droit;
    ModelRenderer corne_droite_1;
    ModelRenderer corne_droite_2;
    ModelRenderer corne_gauche_1;
    ModelRenderer corne_gauche2;
    ModelRenderer Museau_1;
    ModelRenderer Museau_2;
    ModelRenderer corps_1;
    ModelRenderer corps_2;
    ModelRenderer corps_3;
    ModelRenderer corps_4;
    ModelRenderer corps_bas_du_ventre;
    ModelRenderer corps_6;
    ModelRenderer corps_7;
    ModelRenderer corps_8;
    ModelRenderer corps_bas_du_ventre_suite;
    ModelRenderer aile_gauche_1;
    ModelRenderer aile_gauche_2;
    ModelRenderer aile_gauche_3;
    ModelRenderer aile_de_gauche_4;
    ModelRenderer aile_de_gauche_5;
    ModelRenderer peau_de_laile_gauche_1;
    ModelRenderer peau_de_laile_gauche_2;
    ModelRenderer aile_droite_1;
    ModelRenderer aile__droite_2;
    ModelRenderer aile_droite_3;
    ModelRenderer aile_droite_4;
    ModelRenderer aile_de_droite_5;
    ModelRenderer peau_de_laile_droite_1;
    ModelRenderer peau_de_laile__droite_2;
    ModelRenderer queue_1;
    ModelRenderer queue_2;

    public ModelDragonLeo()
    {
        textureWidth = 256;
        textureHeight = 128;

        patte_gauche_1_orange = new ModelRenderer(this, 243, 1);
        patte_gauche_1_orange.addBox(0F, 0F, 0F, 4, 2, 2);
        patte_gauche_1_orange.setRotationPoint(4F, 22F, 3F);
        patte_gauche_1_orange.setTextureSize(64, 32);
        patte_gauche_1_orange.mirror = true;
        setRotation(patte_gauche_1_orange, 0F, 0F, 0F);
        patte_gauche2 = new ModelRenderer(this, 226, 1);
        patte_gauche2.addBox(0F, 0F, 0F, 4, 2, 4);
        patte_gauche2.setRotationPoint(4F, 22F, 5F);
        patte_gauche2.setTextureSize(64, 32);
        patte_gauche2.mirror = true;
        setRotation(patte_gauche2, 0F, 0F, 0F);
        patte_gauche_3 = new ModelRenderer(this, 212, 1);
        patte_gauche_3.addBox(0F, 0F, 0F, 4, 2, 2);
        patte_gauche_3.setRotationPoint(4F, 20F, 7F);
        patte_gauche_3.setTextureSize(64, 32);
        patte_gauche_3.mirror = true;
        setRotation(patte_gauche_3, 0F, 0F, 0F);
        patte_gauche_4 = new ModelRenderer(this, 193, 1);
        patte_gauche_4.addBox(0F, 0F, 0F, 4, 4, 4);
        patte_gauche_4.setRotationPoint(4F, 16F, 7F);
        patte_gauche_4.setTextureSize(64, 32);
        patte_gauche_4.mirror = true;
        setRotation(patte_gauche_4, 0F, 0F, 0F);
        patte_gauche_5 = new ModelRenderer(this, 176, 1);
        patte_gauche_5.addBox(0F, 0F, 0F, 2, 2, 4);
        patte_gauche_5.setRotationPoint(2F, 18F, 7F);
        patte_gauche_5.setTextureSize(64, 32);
        patte_gauche_5.mirror = true;
        setRotation(patte_gauche_5, 0F, 0F, 0F);
        patte_gauche_6 = new ModelRenderer(this, 160, 1);
        patte_gauche_6.addBox(0F, 0F, 0F, 4, 2, 2);
        patte_gauche_6.setRotationPoint(4F, 16F, 5F);
        patte_gauche_6.setTextureSize(64, 32);
        patte_gauche_6.mirror = true;
        setRotation(patte_gauche_6, 0F, 0F, 0F);
        patte_gauche_7 = new ModelRenderer(this, 142, 1);
        patte_gauche_7.addBox(0F, 0F, 0F, 2, 2, 6);
        patte_gauche_7.setRotationPoint(4F, 14F, 5F);
        patte_gauche_7.setTextureSize(64, 32);
        patte_gauche_7.mirror = true;
        setRotation(patte_gauche_7, 0F, 0F, 0F);
        patte_droite_1_orange = new ModelRenderer(this, 243, 10);
        patte_droite_1_orange.addBox(0F, 0F, 0F, 4, 2, 2);
        patte_droite_1_orange.setRotationPoint(-8F, 22F, 3F);
        patte_droite_1_orange.setTextureSize(64, 32);
        patte_droite_1_orange.mirror = true;
        setRotation(patte_droite_1_orange, 0F, 0F, 0F);
        patte_doite_2 = new ModelRenderer(this, 226, 10);
        patte_doite_2.addBox(0F, 0F, 0F, 4, 2, 4);
        patte_doite_2.setRotationPoint(-8F, 22F, 5F);
        patte_doite_2.setTextureSize(64, 32);
        patte_doite_2.mirror = true;
        setRotation(patte_doite_2, 0F, 0F, 0F);
        patte_droite_3 = new ModelRenderer(this, 212, 10);
        patte_droite_3.addBox(0F, 0F, 0F, 4, 2, 2);
        patte_droite_3.setRotationPoint(-8F, 20F, 7F);
        patte_droite_3.setTextureSize(64, 32);
        patte_droite_3.mirror = true;
        setRotation(patte_droite_3, 0F, 0F, 0F);
        patte_droite_4 = new ModelRenderer(this, 193, 10);
        patte_droite_4.addBox(0F, 0F, 0F, 4, 4, 4);
        patte_droite_4.setRotationPoint(-8F, 16F, 7F);
        patte_droite_4.setTextureSize(64, 32);
        patte_droite_4.mirror = true;
        setRotation(patte_droite_4, 0F, 0F, 0F);
        patte_droite_5 = new ModelRenderer(this, 176, 10);
        patte_droite_5.addBox(0F, 0F, 0F, 2, 2, 4);
        patte_droite_5.setRotationPoint(-4F, 18F, 7F);
        patte_droite_5.setTextureSize(64, 32);
        patte_droite_5.mirror = true;
        setRotation(patte_droite_5, 0F, 0F, 0F);
        patte_droite_6 = new ModelRenderer(this, 160, 10);
        patte_droite_6.addBox(0F, 0F, 0F, 4, 2, 2);
        patte_droite_6.setRotationPoint(-8F, 16F, 5F);
        patte_droite_6.setTextureSize(64, 32);
        patte_droite_6.mirror = true;
        setRotation(patte_droite_6, 0F, 0F, 0F);
        patte_droite_7 = new ModelRenderer(this, 142, 10);
        patte_droite_7.addBox(0F, 0F, 0F, 2, 2, 6);
        patte_droite_7.setRotationPoint(-6F, 14F, 5F);
        patte_droite_7.setTextureSize(64, 32);
        patte_droite_7.mirror = true;
        setRotation(patte_droite_7, 0F, 0F, 0F);
        patte_gauche_avant_1 = new ModelRenderer(this, 243, 20);
        patte_gauche_avant_1.addBox(0F, 0F, 0F, 4, 2, 2);
        patte_gauche_avant_1.setRotationPoint(2F, 22F, -11F);
        patte_gauche_avant_1.setTextureSize(64, 32);
        patte_gauche_avant_1.mirror = true;
        setRotation(patte_gauche_avant_1, 0F, 0F, 0F);
        patte_gauche_avant_2 = new ModelRenderer(this, 226, 20);
        patte_gauche_avant_2.addBox(0F, 0F, 0F, 4, 2, 4);
        patte_gauche_avant_2.setRotationPoint(2F, 22F, -9F);
        patte_gauche_avant_2.setTextureSize(64, 32);
        patte_gauche_avant_2.mirror = true;
        setRotation(patte_gauche_avant_2, 0F, 0F, 0F);
        patte_gauche_avant_3 = new ModelRenderer(this, 212, 20);
        patte_gauche_avant_3.addBox(0F, 0F, 0F, 4, 2, 2);
        patte_gauche_avant_3.setRotationPoint(2F, 20F, -7F);
        patte_gauche_avant_3.setTextureSize(64, 32);
        patte_gauche_avant_3.mirror = true;
        setRotation(patte_gauche_avant_3, 0F, 0F, 0F);
        patte_gauche_avant_4 = new ModelRenderer(this, 193, 20);
        patte_gauche_avant_4.addBox(0F, 0F, 0F, 4, 2, 4);
        patte_gauche_avant_4.setRotationPoint(2F, 18F, -7F);
        patte_gauche_avant_4.setTextureSize(64, 32);
        patte_gauche_avant_4.mirror = true;
        setRotation(patte_gauche_avant_4, 0F, 0F, 0F);
        patte_gauche_avant_5 = new ModelRenderer(this, 173, 20);
        patte_gauche_avant_5.addBox(0F, 0F, 0F, 2, 2, 4);
        patte_gauche_avant_5.setRotationPoint(4F, 16F, -7F);
        patte_gauche_avant_5.setTextureSize(64, 32);
        patte_gauche_avant_5.mirror = true;
        setRotation(patte_gauche_avant_5, 0F, 0F, 0F);
        patte_gauche_avant_6 = new ModelRenderer(this, 162, 20);
        patte_gauche_avant_6.addBox(0F, 0F, 0F, 2, 2, 2);
        patte_gauche_avant_6.setRotationPoint(4F, 14F, -7F);
        patte_gauche_avant_6.setTextureSize(64, 32);
        patte_gauche_avant_6.mirror = true;
        setRotation(patte_gauche_avant_6, 0F, 0F, 0F);
        patte_droite_avant_1 = new ModelRenderer(this, 243, 30);
        patte_droite_avant_1.addBox(0F, 0F, 0F, 4, 2, 2);
        patte_droite_avant_1.setRotationPoint(-6F, 22F, -11F);
        patte_droite_avant_1.setTextureSize(64, 32);
        patte_droite_avant_1.mirror = true;
        setRotation(patte_droite_avant_1, 0F, 0F, 0F);
        patte_droite_avant_2 = new ModelRenderer(this, 226, 30);
        patte_droite_avant_2.addBox(0F, 0F, 0F, 4, 2, 4);
        patte_droite_avant_2.setRotationPoint(-6F, 22F, -9F);
        patte_droite_avant_2.setTextureSize(64, 32);
        patte_droite_avant_2.mirror = true;
        setRotation(patte_droite_avant_2, 0F, 0F, 0F);
        patte_droite_avant_3 = new ModelRenderer(this, 212, 30);
        patte_droite_avant_3.addBox(0F, 0F, 0F, 4, 2, 2);
        patte_droite_avant_3.setRotationPoint(-6F, 20F, -7F);
        patte_droite_avant_3.setTextureSize(64, 32);
        patte_droite_avant_3.mirror = true;
        setRotation(patte_droite_avant_3, 0F, 0F, 0F);
        patte_droite_avant_4 = new ModelRenderer(this, 193, 30);
        patte_droite_avant_4.addBox(0F, 0F, 0F, 4, 2, 4);
        patte_droite_avant_4.setRotationPoint(-6F, 18F, -7F);
        patte_droite_avant_4.setTextureSize(64, 32);
        patte_droite_avant_4.mirror = true;
        setRotation(patte_droite_avant_4, 0F, 0F, 0F);
        patte_droite_avant_5 = new ModelRenderer(this, 173, 30);
        patte_droite_avant_5.addBox(0F, 0F, 0F, 2, 2, 4);
        patte_droite_avant_5.setRotationPoint(-6F, 16F, -7F);
        patte_droite_avant_5.setTextureSize(64, 32);
        patte_droite_avant_5.mirror = true;
        setRotation(patte_droite_avant_5, 0F, 0F, 0F);
        patte_droite_avant_6 = new ModelRenderer(this, 162, 30);
        patte_droite_avant_6.addBox(0F, 0F, 0F, 2, 2, 2);
        patte_droite_avant_6.setRotationPoint(-6F, 14F, -7F);
        patte_droite_avant_6.setTextureSize(64, 32);
        patte_droite_avant_6.mirror = true;
        setRotation(patte_droite_avant_6, 0F, 0F, 0F);
        tete_1 = new ModelRenderer(this, 218, 50);
        tete_1.addBox(0F, 0F, 0F, 8, 2, 10);
        tete_1.setRotationPoint(-4F, 10F, -13F);
        tete_1.setTextureSize(64, 32);
        tete_1.mirror = true;
        setRotation(tete_1, 0F, 0F, 0F);
        tete_2 = new ModelRenderer(this, 183, 50);
        tete_2.addBox(0F, 0F, 0F, 8, 2, 8);
        tete_2.setRotationPoint(-4F, 8F, -13F);
        tete_2.setTextureSize(64, 32);
        tete_2.mirror = true;
        setRotation(tete_2, 0F, 0F, 0F);
        tete_3 = new ModelRenderer(this, 168, 50);
        tete_3.addBox(0F, 0F, 0F, 4, 2, 2);
        tete_3.setRotationPoint(-2F, 8F, -5F);
        tete_3.setTextureSize(64, 32);
        tete_3.mirror = true;
        setRotation(tete_3, 0F, 0F, 0F);
        tete_4 = new ModelRenderer(this, 140, 50);
        tete_4.addBox(0F, 0F, 0F, 8, 4, 4);
        tete_4.setRotationPoint(-4F, 4F, -9F);
        tete_4.setTextureSize(64, 32);
        tete_4.mirror = true;
        setRotation(tete_4, 0F, 0F, 0F);
        tete_5 = new ModelRenderer(this, 124, 50);
        tete_5.addBox(0F, 0F, 0F, 4, 4, 2);
        tete_5.setRotationPoint(-2F, 4F, -11F);
        tete_5.setTextureSize(64, 32);
        tete_5.mirror = true;
        setRotation(tete_5, 0F, 0F, 0F);
        oeil_gauhe = new ModelRenderer(this, 112, 50);
        oeil_gauhe.addBox(0F, 0F, 0F, 2, 2, 2);
        oeil_gauhe.setRotationPoint(2F, 6F, -11F);
        oeil_gauhe.setTextureSize(64, 32);
        oeil_gauhe.mirror = true;
        setRotation(oeil_gauhe, 0F, 0F, 0F);
        oeil_droit = new ModelRenderer(this, 100, 50);
        oeil_droit.addBox(0F, 0F, 0F, 2, 2, 2);
        oeil_droit.setRotationPoint(-4F, 6F, -11F);
        oeil_droit.setTextureSize(64, 32);
        oeil_droit.mirror = true;
        setRotation(oeil_droit, 0F, 0F, 0F);
        corne_droite_1 = new ModelRenderer(this, 83, 50);
        corne_droite_1.addBox(0F, 0F, 0F, 2, 2, 4);
        corne_droite_1.setRotationPoint(-4F, 4F, -5F);
        corne_droite_1.setTextureSize(64, 32);
        corne_droite_1.mirror = true;
        setRotation(corne_droite_1, 0F, 0F, 0F);
        corne_droite_2 = new ModelRenderer(this, 87, 43);
        corne_droite_2.addBox(0F, 0F, 0F, 2, 2, 2);
        corne_droite_2.setRotationPoint(-4F, 2F, -3F);
        corne_droite_2.setTextureSize(64, 32);
        corne_droite_2.mirror = true;
        setRotation(corne_droite_2, 0F, 0F, 0F);
        corne_gauche_1 = new ModelRenderer(this, 66, 50);
        corne_gauche_1.addBox(0F, 0F, 0F, 2, 2, 4);
        corne_gauche_1.setRotationPoint(2F, 4F, -5F);
        corne_gauche_1.setTextureSize(64, 32);
        corne_gauche_1.mirror = true;
        setRotation(corne_gauche_1, 0F, 0F, 0F);
        corne_gauche2 = new ModelRenderer(this, 68, 42);
        corne_gauche2.addBox(0F, 0F, 0F, 2, 2, 2);
        corne_gauche2.setRotationPoint(2F, 2F, -3F);
        corne_gauche2.setTextureSize(64, 32);
        corne_gauche2.mirror = true;
        setRotation(corne_gauche2, 0F, 0F, 0F);
        Museau_1 = new ModelRenderer(this, 50, 50);
        Museau_1.addBox(0F, 0F, 0F, 4, 2, 2);
        Museau_1.setRotationPoint(-2F, 8F, -15F);
        Museau_1.setTextureSize(64, 32);
        Museau_1.mirror = true;
        setRotation(Museau_1, 0F, 0F, 0F);
        Museau_2 = new ModelRenderer(this, 50, 43);
        Museau_2.addBox(0F, 0F, 0F, 4, 2, 2);
        Museau_2.setRotationPoint(-2F, 10F, -15F);
        Museau_2.setTextureSize(64, 32);
        Museau_2.mirror = true;
        setRotation(Museau_2, 0F, 0F, 0F);
        corps_1 = new ModelRenderer(this, 197, 80);
        corps_1.addBox(0F, 0F, 0F, 8, 4, 20);
        corps_1.setRotationPoint(-4F, 14F, -7F);
        corps_1.setTextureSize(64, 32);
        corps_1.mirror = true;
        setRotation(corps_1, 0F, 0F, 0F);
        corps_2 = new ModelRenderer(this, 158, 80);
        corps_2.addBox(0F, 0F, 0F, 4, 2, 14);
        corps_2.setRotationPoint(-2F, 12F, -3F);
        corps_2.setTextureSize(64, 32);
        corps_2.mirror = true;
        setRotation(corps_2, 0F, 0F, 0F);
        corps_3 = new ModelRenderer(this, 147, 80);
        corps_3.addBox(0F, 0F, 0F, 2, 2, 2);
        corps_3.setRotationPoint(-4F, 12F, -3F);
        corps_3.setTextureSize(64, 32);
        corps_3.mirror = true;
        setRotation(corps_3, 0F, 0F, 0F);
        corps_4 = new ModelRenderer(this, 135, 80);
        corps_4.addBox(0F, 0F, 0F, 2, 2, 2);
        corps_4.setRotationPoint(2F, 12F, -3F);
        corps_4.setTextureSize(64, 32);
        corps_4.mirror = true;
        setRotation(corps_4, 0F, 0F, 0F);
        corps_bas_du_ventre = new ModelRenderer(this, 84, 80);
        corps_bas_du_ventre.addBox(0F, 0F, 0F, 4, 2, 20);
        corps_bas_du_ventre.setRotationPoint(-2F, 18F, -7F);
        corps_bas_du_ventre.setTextureSize(64, 32);
        corps_bas_du_ventre.mirror = true;
        setRotation(corps_bas_du_ventre, 0F, 0F, 0F);
        corps_6 = new ModelRenderer(this, 58, 80);
        corps_6.addBox(0F, 0F, 0F, 8, 2, 4);
        corps_6.setRotationPoint(-4F, 12F, -7F);
        corps_6.setTextureSize(64, 32);
        corps_6.mirror = true;
        setRotation(corps_6, 0F, 0F, 0F);
        corps_7 = new ModelRenderer(this, 73, 90);
        corps_7.addBox(0F, 0F, 0F, 2, 4, 2);
        corps_7.setRotationPoint(2F, 12F, -9F);
        corps_7.setTextureSize(64, 32);
        corps_7.mirror = true;
        setRotation(corps_7, 0F, 0F, 0F);
        corps_8 = new ModelRenderer(this, 60, 90);
        corps_8.addBox(0F, 0F, 0F, 2, 4, 2);
        corps_8.setRotationPoint(-4F, 12F, -9F);
        corps_8.setTextureSize(64, 32);
        corps_8.mirror = true;
        setRotation(corps_8, 0F, 0F, 0F);
        corps_bas_du_ventre_suite = new ModelRenderer(this, 69, 100);
        corps_bas_du_ventre_suite.addBox(0F, 0F, 0F, 4, 6, 2);
        corps_bas_du_ventre_suite.setRotationPoint(-2F, 12F, -9F);
        corps_bas_du_ventre_suite.setTextureSize(64, 32);
        corps_bas_du_ventre_suite.mirror = true;
        setRotation(corps_bas_du_ventre_suite, 0F, 0F, 0F);
        aile_gauche_1 = new ModelRenderer(this, 230, 114);
        aile_gauche_1.addBox(0F, 0F, 0F, 10, 1, 1);
        aile_gauche_1.setRotationPoint(2F, 11F, -0.5F);
        aile_gauche_1.setTextureSize(64, 32);
        aile_gauche_1.mirror = true;
        setRotation(aile_gauche_1, 0F, 0F, -0.0872665F);
        aile_gauche_2 = new ModelRenderer(this, 203, 114);
        aile_gauche_2.addBox(0F, 0F, 0F, 10, 1, 1);
        aile_gauche_2.setRotationPoint(12F, 10.2F, -0.5F);
        aile_gauche_2.setTextureSize(64, 32);
        aile_gauche_2.mirror = true;
        setRotation(aile_gauche_2, 0F, 0F, 0.0872665F);
        aile_gauche_3 = new ModelRenderer(this, 176, 114);
        aile_gauche_3.addBox(0F, 0F, 0F, 10, 1, 1);
        aile_gauche_3.setRotationPoint(12.5F, 10.2F, 0.5F);
        aile_gauche_3.setTextureSize(64, 32);
        aile_gauche_3.mirror = true;
        setRotation(aile_gauche_3, 0F, -1.570796F, 0.0872665F);
        aile_de_gauche_4 = new ModelRenderer(this, 144, 114);
        aile_de_gauche_4.addBox(0F, 0F, 0F, 12, 1, 1);
        aile_de_gauche_4.setRotationPoint(13F, 10.2F, 0F);
        aile_de_gauche_4.setTextureSize(64, 32);
        aile_de_gauche_4.mirror = true;
        setRotation(aile_de_gauche_4, 0F, -0.7853982F, 0.0872665F);
        aile_de_gauche_5 = new ModelRenderer(this, 114, 114);
        aile_de_gauche_5.addBox(0F, 0F, 0F, 12, 1, 1);
        aile_de_gauche_5.setRotationPoint(12F, 10.2F, 0.5F);
        aile_de_gauche_5.setTextureSize(64, 32);
        aile_de_gauche_5.mirror = true;
        setRotation(aile_de_gauche_5, 0F, -2.356194F, 0.0698132F);
        peau_de_laile_gauche_1 = new ModelRenderer(this, 75, 114);
        peau_de_laile_gauche_1.addBox(0F, 0F, 0F, 9, 0, 8);
        peau_de_laile_gauche_1.setRotationPoint(12F, 11F, 0.5F);
        peau_de_laile_gauche_1.setTextureSize(64, 32);
        peau_de_laile_gauche_1.mirror = true;
        setRotation(peau_de_laile_gauche_1, 0F, 0F, 0.0872665F);
        peau_de_laile_gauche_2 = new ModelRenderer(this, 37, 114);
        peau_de_laile_gauche_2.addBox(0F, 0F, 0F, 9, 0, 8);
        peau_de_laile_gauche_2.setRotationPoint(3F, 11.5F, 0.5F);
        peau_de_laile_gauche_2.setTextureSize(64, 32);
        peau_de_laile_gauche_2.mirror = true;
        setRotation(peau_de_laile_gauche_2, -0.0349066F, 0F, -0.0872665F);
        aile_droite_1 = new ModelRenderer(this, 154, 124);
        aile_droite_1.addBox(0F, 0F, 0F, 10, 1, 1);
        aile_droite_1.setRotationPoint(-12F, 10.2F, -0.5F);
        aile_droite_1.setTextureSize(64, 32);
        aile_droite_1.mirror = true;
        setRotation(aile_droite_1, 0F, 0F, 0.0872665F);
        aile__droite_2 = new ModelRenderer(this, 129, 124);
        aile__droite_2.addBox(0F, 0F, 0F, 10, 1, 1);
        aile__droite_2.setRotationPoint(-22F, 11F, -0.5F);
        aile__droite_2.setTextureSize(64, 32);
        aile__droite_2.mirror = true;
        setRotation(aile__droite_2, 0F, 0F, -0.0872665F);
        aile_droite_3 = new ModelRenderer(this, 104, 124);
        aile_droite_3.addBox(0F, 0F, 0F, 10, 1, 1);
        aile_droite_3.setRotationPoint(-11.5F, 10.2F, 0.5F);
        aile_droite_3.setTextureSize(64, 32);
        aile_droite_3.mirror = true;
        setRotation(aile_droite_3, 0F, -1.570796F, 0.0872665F);
        aile_droite_4 = new ModelRenderer(this, 75, 124);
        aile_droite_4.addBox(0F, 0F, 0F, 12, 1, 1);
        aile_droite_4.setRotationPoint(-11F, 10.2F, 0F);
        aile_droite_4.setTextureSize(64, 32);
        aile_droite_4.mirror = true;
        setRotation(aile_droite_4, 0F, -0.7853982F, 0.0872665F);
        aile_de_droite_5 = new ModelRenderer(this, 44, 124);
        aile_de_droite_5.addBox(0F, 0F, 0F, 12, 1, 1);
        aile_de_droite_5.setRotationPoint(-12F, 10.2F, 0.5F);
        aile_de_droite_5.setTextureSize(64, 32);
        aile_de_droite_5.mirror = true;
        setRotation(aile_de_droite_5, 0F, -2.356194F, 0.0698132F);
        peau_de_laile_droite_1 = new ModelRenderer(this, 218, 119);
        peau_de_laile_droite_1.addBox(0F, 0F, 0F, 9, 0, 8);
        peau_de_laile_droite_1.setRotationPoint(-12F, 11F, 0.5F);
        peau_de_laile_droite_1.setTextureSize(64, 32);
        peau_de_laile_droite_1.mirror = true;
        setRotation(peau_de_laile_droite_1, 0F, 0F, 0.0872665F);
        peau_de_laile__droite_2 = new ModelRenderer(this, 180, 119);
        peau_de_laile__droite_2.addBox(0F, 0F, 0F, 9, 0, 8);
        peau_de_laile__droite_2.setRotationPoint(-21F, 11.5F, 0.5F);
        peau_de_laile__droite_2.setTextureSize(64, 32);
        peau_de_laile__droite_2.mirror = true;
        setRotation(peau_de_laile__droite_2, -0.0349066F, 0F, -0.0872665F);
        queue_1 = new ModelRenderer(this, 66, 3);
        queue_1.addBox(0F, 0F, 0F, 2, 2, 7);
        queue_1.setRotationPoint(-1.3F, 14.1F, 12F);
        queue_1.setTextureSize(64, 32);
        queue_1.mirror = true;
        setRotation(queue_1, 0F, 0.0523599F, 0F);
        queue_2 = new ModelRenderer(this, 51, 3);
        queue_2.addBox(0F, 0F, 0F, 1, 1, 4);
        queue_2.setRotationPoint(-0.4F, 14.4F, 19F);
        queue_2.setTextureSize(64, 32);
        queue_2.mirror = true;
        setRotation(queue_2, 0F, 0.122173F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        patte_gauche_1_orange.render(f5);
        patte_gauche2.render(f5);
        patte_gauche_3.render(f5);
        patte_gauche_4.render(f5);
        patte_gauche_5.render(f5);
        patte_gauche_6.render(f5);
        patte_gauche_7.render(f5);
        patte_droite_1_orange.render(f5);
        patte_doite_2.render(f5);
        patte_droite_3.render(f5);
        patte_droite_4.render(f5);
        patte_droite_5.render(f5);
        patte_droite_6.render(f5);
        patte_droite_7.render(f5);
        patte_gauche_avant_1.render(f5);
        patte_gauche_avant_2.render(f5);
        patte_gauche_avant_3.render(f5);
        patte_gauche_avant_4.render(f5);
        patte_gauche_avant_5.render(f5);
        patte_gauche_avant_6.render(f5);
        patte_droite_avant_1.render(f5);
        patte_droite_avant_2.render(f5);
        patte_droite_avant_3.render(f5);
        patte_droite_avant_4.render(f5);
        patte_droite_avant_5.render(f5);
        patte_droite_avant_6.render(f5);
        tete_1.render(f5);
        tete_2.render(f5);
        tete_3.render(f5);
        tete_4.render(f5);
        tete_5.render(f5);
        oeil_gauhe.render(f5);
        oeil_droit.render(f5);
        corne_droite_1.render(f5);
        corne_droite_2.render(f5);
        corne_gauche_1.render(f5);
        corne_gauche2.render(f5);
        Museau_1.render(f5);
        Museau_2.render(f5);
        corps_1.render(f5);
        corps_2.render(f5);
        corps_3.render(f5);
        corps_4.render(f5);
        corps_bas_du_ventre.render(f5);
        corps_6.render(f5);
        corps_7.render(f5);
        corps_8.render(f5);
        corps_bas_du_ventre_suite.render(f5);
        aile_gauche_1.render(f5);
        aile_gauche_2.render(f5);
        aile_gauche_3.render(f5);
        aile_de_gauche_4.render(f5);
        aile_de_gauche_5.render(f5);
        peau_de_laile_gauche_1.render(f5);
        peau_de_laile_gauche_2.render(f5);
        aile_droite_1.render(f5);
        aile__droite_2.render(f5);
        aile_droite_3.render(f5);
        aile_droite_4.render(f5);
        aile_de_droite_5.render(f5);
        peau_de_laile_droite_1.render(f5);
        peau_de_laile__droite_2.render(f5);
        queue_1.render(f5);
        queue_2.render(f5);
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
