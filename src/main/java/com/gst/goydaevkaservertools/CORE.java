package com.gst.goydaevkaservertools;

import com.gst.goydaevkaservertools.wgcore.ExpansionFlagCrafHandler;
import com.wdg.wgcore.WGCore;
import com.wdg.wgcore.flag.WgcFlagRegistry;
import com.wdg.wgcore.flag.model.WgcFlagType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gst.goydaevkaservertools.commands.CreateBedrockOreCommand;
import com.gst.goydaevkaservertools.commands.SoyuzPayloadCallerCommand;
import com.gst.goydaevkaservertools.goydaevka.dogtag.ItemDogtag;
import com.gst.goydaevkaservertools.goydaevka.dogtag.PlayerDiedDogtagHandler;
import com.gst.goydaevkaservertools.ntm.expiredcapsule.ExpiredSoyuzEntityCapsule;
import com.gst.goydaevkaservertools.ntm.expiredcapsule.SoyuzPayloadCallerGUIHandler;
import com.hbm.entity.EntityMappings;
import com.hbm.util.Tuple;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "goydaevkaservertools", name = "Goydaevka Server Tools", version = Tags.VERSION)
public class CORE {

    @Mod.Instance("goydaevkaservertools")
    public static CORE instance;

    public static final String MODID = "goydaevkaservertools";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(
        clientSide = "com.gst.goydaevkaservertools.ClientProxy",
        serverSide = "com.gst.goydaevkaservertools.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new SoyuzPayloadCallerGUIHandler());

        EntityMappings.entityMappings
            .add(new Tuple.Quartet<>(ExpiredSoyuzEntityCapsule.class, "expired_soyuz_capsule", 1000, true));

        ItemDogtag.DOGTAG = new ItemDogtag();
        GameRegistry.registerItem(ItemDogtag.DOGTAG, "dogtag", MODID);



        MinecraftForge.EVENT_BUS.register(new PlayerDiedDogtagHandler());

        proxy.preInit(event);
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        GameRegistry.addRecipe(
            new ItemStack(WgcFlagRegistry.getItemForType(WgcFlagType.EXPANSION), 1),
            new Object[]{

                "   ", " Y ", "   ",

                ('Y'), ItemDogtag.DOGTAG

            });

        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
        event.registerServerCommand(new CreateBedrockOreCommand());
        event.registerServerCommand(new SoyuzPayloadCallerCommand());
    }
}
