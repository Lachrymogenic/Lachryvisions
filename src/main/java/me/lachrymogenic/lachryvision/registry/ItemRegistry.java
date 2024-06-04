package me.lachrymogenic.lachryvision.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import me.lachrymogenic.lachryvision.Config;
import me.lachrymogenic.lachryvision.Constants;
import me.lachrymogenic.lachryvision.items.ItemMuttonCooked;
import me.lachrymogenic.lachryvision.items.ItemMuttonRaw;
import net.minecraft.item.Item;

import java.lang.reflect.Field;

public class ItemRegistry {

    public static final Item raw_mutton = new ItemMuttonRaw();
    public static final Item cooked_mutton = new ItemMuttonCooked();
    public static void register() {
        if (Config.RegisterCustomItems) {
            try {
                for (Field f : ItemRegistry.class.getDeclaredFields()) {
                    Object obj = f.get(null);

                    if (obj instanceof Item)
                        registerItem((Item) obj);
                    else if (obj instanceof Item[])
                        for (Item item : (Item[]) obj)
                            registerItem(item);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void registerItem(Item item) {
        String name = item.getUnlocalizedName();
        String[] strings = name.split("\\.");
        GameRegistry.registerItem(item, strings[strings.length - 1]);
    }
}
