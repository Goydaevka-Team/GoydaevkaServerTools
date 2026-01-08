package com.gst.goydaevkaservertools.mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import com.gst.goydaevkaservertools.CORE;
import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;
import cpw.mods.fml.relauncher.FMLLaunchHandler;

// The annotation is required, it indicates to
// the mixins framework to instantiate this class
// and look for LateMixins to load.
@LateMixin
public class LateMixinsLoader implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        // rename the associated .json file by replacing the "mymodid" with your own mod ID
        // in the .json file edit the "package" and "refmap" properties to match your mod
        // also edit the "refmap" property in the "mixins.goydaevkaservertools.json" file
        return "mixins.goydaevkaservertools.late.json";
    }

    @Nonnull
    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        // Register your mixins here by adding them to the list.
        // The late mixins are mixins that target classes from other mods
        // The late mixins should be placed in the "mixins/late" package
        CORE.LOG.info(loadedMods.toString());
        CORE.LOG.info(loadedMods.contains("hbm"));
        List<String> mixins = new ArrayList<>();

        if (FMLLaunchHandler.side()
            .isClient()) {
            // register here your mixins that should only be loaded on the client
            // this is an example you should delete it and the associated mixin
            // class as well
        } else {
            // register here your mixins that should only be loaded on the dedicated server
            // mixins.add("MixinClass");
        }
        mixins.add("InjectorInBedrockOre");
        // The loadedMods contains the mod ID of the mods that are currently loaded
        // you can check this Set to decide to load certain mixins or not.
        return mixins;
    }
}
