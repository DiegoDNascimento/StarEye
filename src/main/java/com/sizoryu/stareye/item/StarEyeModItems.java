package com.sizoryu.stareye.item;

import com.sizoryu.stareye.StarEye;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StarEyeModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StarEye.MOD_ID);

    public static final RegistryObject<Item> STAR_EYE = ITEMS.register("star_eye",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
