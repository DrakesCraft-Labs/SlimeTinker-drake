package io.github.sefiraat.slimetinker.items.tinkermaterials.setup;

import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterial;
import io.github.sefiraat.slimetinker.managers.SupportedPluginsManager;
import io.github.sefiraat.slimetinker.utils.Ids;
import io.github.sefiraat.slimetinker.utils.SkullTextures;
import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpellCheckingInspection")
public final class TinkersMaterialsSupreme {

    private TinkersMaterialsSupreme() {
        throw new UnsupportedOperationException("Utility Class");
    }

    private static final Map<String, TinkerMaterial> CM_MAP = new HashMap<>();

    private static ItemStack getAddonItem(String id, Material fallback) {
        SlimefunItem item = SlimefunItem.getById(id);
        return item != null ? item.getItem().clone() : new ItemStack(fallback);
    }

    private static final TinkerMaterial AURUM = new TinkerMaterial(
        Ids.AURUM,
        getAddonItem("SUPREME_ALLOY_AURUM", Material.GOLD_INGOT),
        "#fcdb03"
    )
        .setLiquidTexture(SkullTextures.ALLOY_TAN)
        .setTraitToolHead(Traits.SUPREME_AURUM_HEAD)
        .setTraitToolRod(Traits.SUPREME_AURUM_ROD)
        .setTraitArmorPlates(Traits.SUPREME_AURUM_PLATES)
        .setTraitArmorLinks(Traits.SUPREME_AURUM_LINKS)
        .setFormIngot("SUPREME_ALLOY_AURUM")
        .setFormBlock("SUPREME_AURUM_PLATE")
        .build();

    private static final TinkerMaterial ADAMANTIUM = new TinkerMaterial(
        Ids.ADAMANTIUM,
        getAddonItem("SUPREME_ALLOY_ADAMANTIUM", Material.NETHERITE_INGOT),
        "#3a4d59"
    )
        .setLiquidTexture(SkullTextures.ALLOY_SILVER)
        .setTraitToolHead(Traits.SUPREME_ADAMANTIUM_HEAD)
        .setTraitToolRod(Traits.SUPREME_ADAMANTIUM_ROD)
        .setTraitArmorPlates(Traits.SUPREME_ADAMANTIUM_PLATES)
        .setTraitArmorLinks(Traits.SUPREME_ADAMANTIUM_LINKS)
        .setFormIngot("SUPREME_ALLOY_ADAMANTIUM")
        .setFormBlock("SUPREME_ADAMANTIUM_PLATE")
        .build();

    private static final TinkerMaterial THORNIUM = new TinkerMaterial(
        Ids.THORNIUM,
        getAddonItem("SUPREME_THORNIUM_INGOT", Material.IRON_INGOT),
        "#00b86b"
    )
        .setLiquidTexture(SkullTextures.ALLOY_GREEN)
        .setTraitToolHead(Traits.SUPREME_THORNIUM_HEAD)
        .setTraitToolRod(Traits.SUPREME_THORNIUM_ROD)
        .setTraitArmorPlates(Traits.SUPREME_THORNIUM_PLATES)
        .setTraitArmorLinks(Traits.SUPREME_THORNIUM_LINKS)
        .setFormNugget("SUPREME_THORNIUM_BIT")
        .setFormDust("SUPREME_THORNIUM_DUST")
        .setFormIngot("SUPREME_THORNIUM_INGOT")
        .build();

    private static final TinkerMaterial SUPREME = new TinkerMaterial(
        Ids.SUPREME,
        getAddonItem("SUPREME_SUPREME", Material.PURPLE_DYE),
        "#a832a4"
    )
        .setLiquidTexture(SkullTextures.ALLOY_PURPLE_DEEP)
        .setTraitToolHead(Traits.SUPREME_SUPREME_HEAD)
        .setTraitToolRod(Traits.SUPREME_SUPREME_ROD)
        .setTraitArmorPlates(Traits.SUPREME_SUPREME_PLATES)
        .setTraitArmorLinks(Traits.SUPREME_SUPREME_LINKS)
        .setFormNugget("SUPREME_SUPREME_NUGGET")
        .setFormIngot("SUPREME_SUPREME")
        .build();

    private static final TinkerMaterial COSMIC_ALLOY = new TinkerMaterial(
        Ids.COSMIC_ALLOY,
        Materials.INGOT_CAST_COSMIC_ALLOY,
        "#8824e3"
    )
        .setLiquidTexture(SkullTextures.ALLOY_PURPLE_DEEP)
        .setTraitToolHead(Traits.COSMIC_ALLOY_HEAD)
        .setTraitToolRod(Traits.COSMIC_ALLOY_ROD)
        .setTraitArmorPlates(Traits.COSMIC_ALLOY_PLATES)
        .setTraitArmorLinks(Traits.COSMIC_ALLOY_LINKS)
        .setFormNugget(Materials.NUGGET_CAST_COSMIC_ALLOY.getItemId())
        .setFormIngot(Materials.INGOT_CAST_COSMIC_ALLOY.getItemId())
        .setFormBlock(Materials.BLOCK_CAST_COSMIC_ALLOY.getItemId());

    static {
        if (SupportedPluginsManager.INFINITY_EXPANSION && TinkersMaterialsInfinity.getCmMap().containsKey(Ids.INFINITY)) {
            COSMIC_ALLOY.addAlloyRecipe(
                TinkersMaterialsInfinity.getCmMap().get(Ids.INFINITY).getLiquidItemStack(1),
                SUPREME.getLiquidItemStack(1)
            );
        }
        COSMIC_ALLOY.build();

        CM_MAP.put(Ids.AURUM, AURUM);
        CM_MAP.put(Ids.ADAMANTIUM, ADAMANTIUM);
        CM_MAP.put(Ids.THORNIUM, THORNIUM);
        CM_MAP.put(Ids.SUPREME, SUPREME);
        CM_MAP.put(Ids.COSMIC_ALLOY, COSMIC_ALLOY);
    }

    public static Map<String, TinkerMaterial> getCmMap() {
        return CM_MAP;
    }
}
