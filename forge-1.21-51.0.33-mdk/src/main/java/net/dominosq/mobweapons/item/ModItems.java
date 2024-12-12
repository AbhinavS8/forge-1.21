package net.dominosq.mobweapons.item;

import net.dominosq.mobweapons.MobWeapons;
import net.dominosq.mobweapons.item.custom.ChiselItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MobWeapons.MOD_ID);

//    public static final RegistryObject<Item> KOK = ITEMS.register("kok",
//            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ESSENCE = ITEMS.register("essence",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL_ITEM = ITEMS.register("chisel_item",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
