package com.gst.goydaevkaservertools.mixins.early;

import com.hbm.items.special.ItemBedrockOreBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import java.util.List;

@Mixin(value = ItemBedrockOreBase.class,
priority = 1001) // the class targeted by this mixin
public class InjectorInBedrockOre extends Item { // This is an example you should delete this class

    @Inject(method = "addInformation", at = @At("TAIL"), remap = false)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
        // this line of code will be injected at the end of the method "startGame" in the Minecraft class
        System.out.println("Example mod says Hello from within Minecraft.startGame()!");
    }
}
