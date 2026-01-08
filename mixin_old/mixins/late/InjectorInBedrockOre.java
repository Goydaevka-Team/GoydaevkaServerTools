package com.gst.goydaevkaservertools.mixins.late;

import com.hbm.items.ModItems;
import com.hbm.items.special.ItemBedrockOreBase;
import com.hbm.items.special.ItemBedrockOreNew;
import net.minecraft.client.Minecraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(targets = "com.hbm.items.special.ItemBedrockOreBase", remap = false)// the class targeted by this mixin
public class InjectorInBedrockOre extends Item{ // This is an example you should delete this class

//    @Inject(method = "addInformation", at = @At("HEAD"), remap = false)
//    public void example$sayHello(ItemStack stack, EntityPlayer player, List list, boolean bool, CallbackInfo ci) {
//        list.add("SSSS");
//        // this line of code will be injected at the end of the method "startGame" in the Minecraft class
//
//    }

    public static void setOreAmount(ItemStack stack, double level, ItemBedrockOreNew.BedrockOreType type) {

    }
}
