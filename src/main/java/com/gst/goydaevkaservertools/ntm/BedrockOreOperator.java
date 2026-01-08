package com.gst.goydaevkaservertools.ntm;

import com.hbm.items.ModItems;
import com.hbm.items.special.ItemBedrockOreNew;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class BedrockOreOperator {
    public static void SetBedrockOreOperator(ItemStack stack, ItemBedrockOreNew.BedrockOreType type, double mult){

        if(!stack.hasTagCompound()) stack.stackTagCompound = new NBTTagCompound();

        NBTTagCompound data = stack.getTagCompound();

        data.setDouble(type.suffix, mult);
    }
    public static ItemStack CreateBedrockOreWithLevels(int count, float LM, float HM, float RE, float ACT, float NM, float CR){
        ItemStack stack = new ItemStack(ModItems.bedrock_ore_base, count);

        SetBedrockOreOperator(stack, ItemBedrockOreNew.BedrockOreType.LIGHT_METAL, LM);
        SetBedrockOreOperator(stack, ItemBedrockOreNew.BedrockOreType.HEAVY_METAL, HM);
        SetBedrockOreOperator(stack, ItemBedrockOreNew.BedrockOreType.RARE_EARTH, RE);
        SetBedrockOreOperator(stack, ItemBedrockOreNew.BedrockOreType.ACTINIDE, ACT);
        SetBedrockOreOperator(stack, ItemBedrockOreNew.BedrockOreType.NON_METAL, NM);
        SetBedrockOreOperator(stack, ItemBedrockOreNew.BedrockOreType.CRYSTALLINE, CR);

        return stack;
    }
}
