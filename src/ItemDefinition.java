// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import sign.signlink;

public class ItemDefinition {

    public static void dystroy(int junk) {
        item_modelstorage = null;
        aClass12_158 = null;
        offsets = null;
        definition_stack = null;
        info_buffer = null;
    }

    public boolean method192(int i, int j) {
        if(i != -2836)
            aBoolean186 = !aBoolean186;
        int k = anInt175;
        int l = anInt166;
        if(j == 1)
        {
            k = anInt197;
            l = anInt173;
        }
        if(k == -1)
            return true;
        boolean flag = true;
        if(!Model.isLoaded(k))
            flag = false;
        if(l != -1 && !Model.isLoaded(l))
            flag = false;
        return flag;
    }

    public static void amountitems(ContainerArchive class44)
    {
        info_buffer = new Buffer(class44.getEntry("obj.dat", null));
        Buffer buffer0 = new Buffer(class44.getEntry("obj.idx", null));
        anInt203 = buffer0.getShort();
        offsets = new int[anInt203];
        int i = 2;
        for(int j = 0; j < anInt203; j++)
        {
            offsets[j] = i;
            i += buffer0.getShort();
        }
        definition_stack = new ItemDefinition[10];
        for(int k = 0; k < 10; k++)
            definition_stack[k] = new ItemDefinition();
    }

    public Model method194(int i, int j)
    {
        while(i >= 0) 
            aBoolean186 = !aBoolean186;
        int k = anInt175;
        int l = anInt166;
        if(j == 1)
        {
            k = anInt197;
            l = anInt173;
        }
        if(k == -1)
            return null;
        Model class30_sub2_sub4_sub6 = Model.getModel(anInt171, k);
        if(l != -1)
        {
            Model class30_sub2_sub4_sub6_1 = Model.getModel(anInt171, l);
            Model aclass30_sub2_sub4_sub6[] = {
                class30_sub2_sub4_sub6, class30_sub2_sub4_sub6_1
            };
            class30_sub2_sub4_sub6 = new Model(aclass30_sub2_sub4_sub6, 2);
        }
        if(trianglecolors != null)
        {
            for(int i1 = 0; i1 < trianglecolors.length; i1++)
                class30_sub2_sub4_sub6.setTriangleColors(trianglecolors[i1], trianglecolorvalues[i1]);

        }
        return class30_sub2_sub4_sub6;
    }

    public boolean loadPlayerModels_(int junk, int gender)
    {
        int k = male_model1;
        int l = male_model2;
        int i1 = male_model3;
        if(gender == 1)
        {
            k = female_model1;
            l = female_model2;
            i1 = female_model3;
        }
        if(k == -1)
            return true;
        boolean flag = true;
        if(!Model.isLoaded(k))
            flag = false;
        if(l != -1 && !Model.isLoaded(l))
            flag = false;
        if(i1 != -1 && !Model.isLoaded(i1))
            flag = false;
        return flag;
    }

    public Model toModel_id(boolean junk, int gender)
    {
        int j = male_model1;
        int k = male_model2;
        int l = male_model3;
		/* Female */
        if(gender == 1)
        {
            j = female_model1;
            k = female_model2;
            l = female_model3;
        }
        if(j == -1)
            return null;
        Model class30_sub2_sub4_sub6 = Model.getModel(anInt171, j);
        if(k != -1)
            if(l != -1)
            {
                Model class30_sub2_sub4_sub6_1 = Model.getModel(anInt171, k);
                Model class30_sub2_sub4_sub6_3 = Model.getModel(anInt171, l);
                Model aclass30_sub2_sub4_sub6_1[] = {
                    class30_sub2_sub4_sub6, class30_sub2_sub4_sub6_1, class30_sub2_sub4_sub6_3
                };
                class30_sub2_sub4_sub6 = new Model(aclass30_sub2_sub4_sub6_1, 3);
            } else
            {
                Model class30_sub2_sub4_sub6_2 = Model.getModel(anInt171, k);
                Model aclass30_sub2_sub4_sub6[] = {
                    class30_sub2_sub4_sub6, class30_sub2_sub4_sub6_2
                };
                class30_sub2_sub4_sub6 = new Model(aclass30_sub2_sub4_sub6, 2);
            }
        if(gender == 0 && male_moveverticies != 0)
            class30_sub2_sub4_sub6.moveVertices(0, male_moveverticies, 16384, 0);
        if(gender == 1 && female_moveverticies != 0)
            class30_sub2_sub4_sub6.moveVertices(0, female_moveverticies, 16384, 0);
        if(trianglecolors != null)
        {
            for(int i1 = 0; i1 < trianglecolors.length; i1++)
                class30_sub2_sub4_sub6.setTriangleColors(trianglecolors[i1], trianglecolorvalues[i1]);
        }
        return class30_sub2_sub4_sub6;
    }

    public void setDefaults() {
        modelid = 0;
        name = null;
        examine = null;
        trianglecolors = null;
        trianglecolorvalues = null;
        zoom = 2000;
        rotation = 0;
        anInt198 = 0;
        anInt204 = 0;
        anInt169 = 0;
        anInt194 = 0;
        anInt199 = -1;
        aBoolean176 = false;
        anInt155 = 1;
        aBoolean161 = false;
        ground_options = null;
        inventory_options = null;
        male_model1 = -1;
        male_model2 = -1;
        male_moveverticies = 0;
        female_model1 = -1;
        female_model2 = -1;
        female_moveverticies = 0;
        male_model3 = -1;
        female_model3 = -1;
        anInt175 = -1;
        anInt166 = -1;
        anInt197 = -1;
        anInt173 = -1;
        amtmodels = null;
        amountmodels_ptrs = null;
        anInt179 = -1;
        anInt163 = -1;
        scalex = 128;
        scaley = 128;
        scalez = 128;
        lightvectorx = 0;
        lightvectory = 0;
        anInt202 = 0;
    }

    public static ItemDefinition getItemDefinition(int i) {
        for(int j = 0; j < 10; j++)
            if(definition_stack[j].id == i)
                return definition_stack[j];
        stackoffset = (stackoffset + 1) % 10;
        ItemDefinition class8 = definition_stack[stackoffset];
        info_buffer.position = offsets[i];
        class8.id = i;
        class8.setDefaults();
        class8.loadItemDef(true, info_buffer);
        if(class8.anInt163 != -1)
            class8.method199((byte)61);
        if(!aBoolean182 && class8.aBoolean161) {
            class8.name = "Members Object";
            class8.examine = "Login to a members' server to use this object.".getBytes();
            class8.ground_options = null;
            class8.inventory_options = null;
            class8.anInt202 = 0;
        }
        return class8;
    }

    public void method199(byte byte0)
    {
        ItemDefinition class8 = getItemDefinition(anInt163);
        modelid = class8.modelid;
        zoom = class8.zoom;
        rotation = class8.rotation;
        anInt198 = class8.anInt198;
        anInt204 = class8.anInt204;
        anInt169 = class8.anInt169;
        anInt194 = class8.anInt194;
        if(byte0 != 61)
            aBoolean186 = !aBoolean186;
        trianglecolors = class8.trianglecolors;
        trianglecolorvalues = class8.trianglecolorvalues;
        ItemDefinition class8_1 = getItemDefinition(anInt179);
        name = class8_1.name;
        aBoolean161 = class8_1.aBoolean161;
        anInt155 = class8_1.anInt155;
        String s = "a";
        char c = class8_1.name.charAt(0);
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            s = "an";
        examine = ("Swap this note at any bank for " + s + " " + class8_1.name + ".").getBytes();
        aBoolean176 = true;
    }

    public static DirectColorSprite asSprite(int id, int j, int k, int l)
    {
        if(k == 0)
        {
            DirectColorSprite class30_sub2_sub1_sub1 = (DirectColorSprite)aClass12_158.method222(id);
            if(class30_sub2_sub1_sub1 != null && class30_sub2_sub1_sub1.height$ != j && class30_sub2_sub1_sub1.height$ != -1)
            {
                class30_sub2_sub1_sub1.removeDeque();
                class30_sub2_sub1_sub1 = null;
            }
            if(class30_sub2_sub1_sub1 != null)
                return class30_sub2_sub1_sub1;
        }
        ItemDefinition class8 = getItemDefinition(id);
        if(class8.amtmodels == null)
            j = -1;
        if(j > 1)
        {
            int i1 = -1;
            for(int j1 = 0; j1 < 10; j1++)
                if(j >= class8.amountmodels_ptrs[j1] && class8.amountmodels_ptrs[j1] != 0)
                    i1 = class8.amtmodels[j1];

            if(i1 != -1)
                class8 = getItemDefinition(i1);
        }
        Model model = class8.getAmountModel(1);
        if(model == null)
            return null;
        DirectColorSprite sprite0 = null;
        if(class8.anInt163 != -1)
        {
            sprite0 = asSprite(class8.anInt179, 10, -1, 9);
            if(sprite0 == null)
                return null;
        }
        DirectColorSprite sprite1 = new DirectColorSprite(32, 32);
        int k1 = TriangleRasterizer.midwidth;
        int l1 = TriangleRasterizer.midheight;
        int heightoffsets[] = TriangleRasterizer.heightoffsets;
        int output[] = Raster.output;
        int outwidth = Raster.outputwidth;
        int outheight = Raster.outputheight;
        int offsetwidth = Raster.widthoffset;
        int rasterwidth = Raster.width;
        int offsetheight = Raster.heightoffset;
        int rasterheight = Raster.height;
        TriangleRasterizer.aBoolean1464 = false;
        Raster.setOutput(32, 32, sprite1.pixels);
        Raster.drawQuadrilateral(0, 0, 32, 32, 0);
        TriangleRasterizer.setDimensions();
        int k3 = class8.zoom;
        if(k == -1)
            k3 = (int)((double)k3 * 1.5D);
        if(k > 0)
            k3 = (int)((double)k3 * 1.04D);
        int l3 = TriangleRasterizer.sine_table[class8.rotation] * k3 >> 16;
        int i4 = TriangleRasterizer.cosine_table[class8.rotation] * k3 >> 16;
        model.drawModel(0, class8.anInt198, class8.anInt204, class8.rotation, class8.anInt169, l3 + ((Entity) (model)).miny / 2 + class8.anInt194, i4 + class8.anInt194);
        for(int i5 = 31; i5 >= 0; i5--)
        {
            for(int j4 = 31; j4 >= 0; j4--)
                if(sprite1.pixels[i5 + j4 * 32] == 0)
                    if(i5 > 0 && sprite1.pixels[(i5 - 1) + j4 * 32] > 1)
                        sprite1.pixels[i5 + j4 * 32] = 1;
                    else
                    if(j4 > 0 && sprite1.pixels[i5 + (j4 - 1) * 32] > 1)
                        sprite1.pixels[i5 + j4 * 32] = 1;
                    else
                    if(i5 < 31 && sprite1.pixels[i5 + 1 + j4 * 32] > 1)
                        sprite1.pixels[i5 + j4 * 32] = 1;
                    else
                    if(j4 < 31 && sprite1.pixels[i5 + (j4 + 1) * 32] > 1)
                        sprite1.pixels[i5 + j4 * 32] = 1;

        }

        if(k > 0)
        {
            for(int j5 = 31; j5 >= 0; j5--)
            {
                for(int k4 = 31; k4 >= 0; k4--)
                    if(sprite1.pixels[j5 + k4 * 32] == 0)
                        if(j5 > 0 && sprite1.pixels[(j5 - 1) + k4 * 32] == 1)
                            sprite1.pixels[j5 + k4 * 32] = k;
                        else
                        if(k4 > 0 && sprite1.pixels[j5 + (k4 - 1) * 32] == 1)
                            sprite1.pixels[j5 + k4 * 32] = k;
                        else
                        if(j5 < 31 && sprite1.pixels[j5 + 1 + k4 * 32] == 1)
                            sprite1.pixels[j5 + k4 * 32] = k;
                        else
                        if(k4 < 31 && sprite1.pixels[j5 + (k4 + 1) * 32] == 1)
                            sprite1.pixels[j5 + k4 * 32] = k;

            }

        } else
        if(k == 0)
        {
            for(int k5 = 31; k5 >= 0; k5--)
            {
                for(int l4 = 31; l4 >= 0; l4--)
                    if(sprite1.pixels[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0 && sprite1.pixels[(k5 - 1) + (l4 - 1) * 32] > 0)
                        sprite1.pixels[k5 + l4 * 32] = 0x302020;

            }

        }
        if(class8.anInt163 != -1)
        {
            int l5 = sprite0.width$;
            int j6 = sprite0.height$;
            sprite0.width$ = 32;
            sprite0.height$ = 32;
            sprite0.drawOverlay(0, 16083, 0);
            sprite0.width$ = l5;
            sprite0.height$ = j6;
        }
        if(k == 0)
            aClass12_158.method223(sprite1, id, (byte)2);
        Raster.setOutput(outheight, outwidth, output);
        Raster.setDimensions(rasterwidth, offsetwidth, rasterheight, offsetheight);
        TriangleRasterizer.midwidth = k1;
        TriangleRasterizer.midheight = l1;
        TriangleRasterizer.heightoffsets = heightoffsets;
        TriangleRasterizer.aBoolean1464 = true;
        if(l < 9 || l > 9)
        {
            for(int i6 = 1; i6 > 0; i6++);
        }
        if(class8.aBoolean176)
            sprite1.width$ = 33;
        else
            sprite1.width$ = 32;
        sprite1.height$ = j;
        return sprite1;
    }

    public Model getAmountModel(int amount) {
        if(amtmodels != null && amount > 1) {
            int j = -1;
            for(int k = 0; k < 10; k++)
                if(amount >= amountmodels_ptrs[k] && amountmodels_ptrs[k] != 0)
                    j = amtmodels[k];
            if(j != -1)
                return getItemDefinition(j).getAmountModel(1);
        }
        Model class30_sub2_sub4_sub6 = (Model) item_modelstorage.method222(id);
        if(class30_sub2_sub4_sub6 != null)
            return class30_sub2_sub4_sub6;
        class30_sub2_sub4_sub6 = Model.getModel(anInt171, modelid);
        if(class30_sub2_sub4_sub6 == null)
            return null;
        if(scalex != 128 || scaley != 128 || scalez != 128)
            class30_sub2_sub4_sub6.scaleModel(scalex, scaley, scalez);
        if(trianglecolors != null) {
            for(int l = 0; l < trianglecolors.length; l++)
                class30_sub2_sub4_sub6.setTriangleColors(trianglecolors[l], trianglecolorvalues[l]);
        }
        class30_sub2_sub4_sub6.setLightingVectors(64 + lightvectorx, 768 + lightvectory, -50, -10, -50, true);
        class30_sub2_sub4_sub6.aBoolean1659 = true;
        item_modelstorage.method223(class30_sub2_sub4_sub6, id, (byte)2);
        return class30_sub2_sub4_sub6;
    }

    public Model method202(int i, boolean flag)
    {
        if(amtmodels != null && i > 1)
        {
            int j = -1;
            for(int k = 0; k < 10; k++)
                if(i >= amountmodels_ptrs[k] && amountmodels_ptrs[k] != 0)
                    j = amtmodels[k];

            if(j != -1)
                return getItemDefinition(j).method202(1, true);
        }
        Model class30_sub2_sub4_sub6 = Model.getModel(anInt171, modelid);
        if(!flag)
            throw new NullPointerException();
        if(class30_sub2_sub4_sub6 == null)
            return null;
        if(trianglecolors != null)
        {
            for(int l = 0; l < trianglecolors.length; l++)
                class30_sub2_sub4_sub6.setTriangleColors(trianglecolors[l], trianglecolorvalues[l]);

        }
        return class30_sub2_sub4_sub6;
    }

    public void loadItemDef(boolean flag, Buffer buffer0)
    {
        if(!flag)
            throw new NullPointerException();
        do
        {
            int i = buffer0.getUByte();
            if(i == 0)
                return;
            if(i == 1)
                modelid = buffer0.getShort();
            else
            if(i == 2)
                name = buffer0.getCStr();
            else
            if(i == 3)
                examine = buffer0.getCStrBytes((byte)30);
            else
            if(i == 4)
                zoom = buffer0.getShort();
            else
            if(i == 5)
                rotation = buffer0.getShort();
            else
            if(i == 6)
                anInt198 = buffer0.getShort();
            else
            if(i == 7)
            {
                anInt169 = buffer0.getShort();
                if(anInt169 > 32767)
                    anInt169 -= 0x10000;
            } else
            if(i == 8)
            {
                anInt194 = buffer0.getShort();
                if(anInt194 > 32767)
                    anInt194 -= 0x10000;
            } else
            if(i == 10)
                anInt199 = buffer0.getShort();
            else
            if(i == 11)
                aBoolean176 = true;
            else
            if(i == 12)
                anInt155 = buffer0.getInt();
            else
            if(i == 16)
                aBoolean161 = true;
            else
            if(i == 23)
            {
                male_model1 = buffer0.getShort();
                male_moveverticies = buffer0.getByte();
            } else
            if(i == 24)
                male_model2 = buffer0.getShort();
            else
            if(i == 25)
            {
                female_model1 = buffer0.getShort();
                female_moveverticies = buffer0.getByte();
            } else
            if(i == 26)
                female_model2 = buffer0.getShort();
            else
            if(i >= 30 && i < 35)
            {
                if(ground_options == null)
                    ground_options = new String[5];
                ground_options[i - 30] = buffer0.getCStr();
                if(ground_options[i - 30].equalsIgnoreCase("hidden"))
                    ground_options[i - 30] = null;
            } else
            if(i >= 35 && i < 40)
            {
                if(inventory_options == null)
                    inventory_options = new String[5];
                inventory_options[i - 35] = buffer0.getCStr();
            } else
            if(i == 40)
            {
                int j = buffer0.getUByte();
                trianglecolors = new int[j];
                trianglecolorvalues = new int[j];
                for(int k = 0; k < j; k++)
                {
                    trianglecolors[k] = buffer0.getShort();
                    trianglecolorvalues[k] = buffer0.getShort();
                }

            } else
            if(i == 78)
                male_model3 = buffer0.getShort();
            else
            if(i == 79)
                female_model3 = buffer0.getShort();
            else
            if(i == 90)
                anInt175 = buffer0.getShort();
            else
            if(i == 91)
                anInt197 = buffer0.getShort();
            else
            if(i == 92)
                anInt166 = buffer0.getShort();
            else
            if(i == 93)
                anInt173 = buffer0.getShort();
            else
            if(i == 95)
                anInt204 = buffer0.getShort();
            else
            if(i == 97)
                anInt179 = buffer0.getShort();
            else
            if(i == 98)
                anInt163 = buffer0.getShort();
            else
            if(i >= 100 && i < 110)
            {
                if(amtmodels == null)
                {
                    amtmodels = new int[10];
                    amountmodels_ptrs = new int[10];
                }
                amtmodels[i - 100] = buffer0.getShort();
                amountmodels_ptrs[i - 100] = buffer0.getShort();
            } else
            if(i == 110)
                scalex = buffer0.getShort();
            else
            if(i == 111)
                scaley = buffer0.getShort();
            else
            if(i == 112)
                scalez = buffer0.getShort();
            else
            if(i == 113)
                lightvectorx = buffer0.getByte();
            else
            if(i == 114)
                lightvectory = buffer0.getByte() * 5;
            else
            if(i == 115)
                anInt202 = buffer0.getUByte();
        } while(true);
    }

    public ItemDefinition() {
        id = -1;
        anInt171 = 9;
        anInt177 = 9;
        aBoolean186 = false;
        aBoolean206 = false;
    }

    public byte female_moveverticies;
    public int anInt155;
    public int trianglecolors[];
    public int id;
    public static Cache aClass12_158 = new Cache(false, 100);
    public static Cache item_modelstorage = new Cache(false, 50);
    public int trianglecolorvalues[];
    public boolean aBoolean161;
    public int female_model3;
    public int anInt163;
    public int female_model2;
    public int male_model1;
    public int anInt166;
    public int scalex;
    public String ground_options[];
    public int anInt169;
    public String name;
    public int anInt171;
    public static ItemDefinition definition_stack[];
    public int anInt173;
    public int modelid;
    public int anInt175;
    public boolean aBoolean176;
    public int anInt177;
    public byte examine[];
    public int anInt179;
    public static int stackoffset;
    public int zoom;
    public static boolean aBoolean182 = true;
    public static Buffer info_buffer;
    public int lightvectory;
    public int male_model3;
    public boolean aBoolean186;
    public static boolean aBoolean187;
    public int male_model2;
    public String inventory_options[];
    public int rotation;
    public int scalez;
    public int scaley;
    public int amtmodels[];
    public int anInt194;
    public static int offsets[];
    public int lightvectorx;
    public int anInt197;
    public int anInt198;
    public int anInt199;
    public int female_model1;
    public int amountmodels_ptrs[];
    public int anInt202;
    public static int anInt203;
    public int anInt204;
    public byte male_moveverticies;
    public boolean aBoolean206;

}
