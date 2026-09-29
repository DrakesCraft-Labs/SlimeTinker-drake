package cl.drakescraft.addon.bridge;

import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Puente de compatibilidad SlimeTinker → MultiverseTinker (autoria Chagui68).
 *
 * <p>Por reflexion contra {@code com.chagui68.multiversetinker.api.MultiverseTinkerAPI},
 * asi que SlimeTinker NO depende en tiempo de compilacion de MultiverseTinker y ambos
 * siguen funcionando por separado. Si MultiverseTinker no esta instalado, el puente
 * queda latente ({@link #isAvailable()} = false) y todo degrada a false/null/vacio.
 *
 * <p>Permite que la fundicion/casting de SlimeTinker reconozca los lingotes y alloys
 * de MultiverseTinker como material de entrada valido (interoperabilidad de metales
 * entre ambos sistemas Tinker).
 */
public final class MultiverseTinkerBridge {

    private static final Logger LOGGER = Logger.getLogger("SlimeTinker-MVTinkerBridge");
    private static final String API_CLASS = "com.chagui68.multiversetinker.api.MultiverseTinkerAPI";

    private static boolean available = false;
    private static Method mIsAvailable;
    private static Method mIsTinkerItem;
    private static Method mIsIngot;
    private static Method mGetMaterialId;
    private static Method mGetIngot;
    private static Method mListMaterialIds;

    private MultiverseTinkerBridge() {
    }

    /** Engancha la API de MultiverseTinker si esta presente. Idempotente. */
    public static void initialize(Logger logger) {
        try {
            Class<?> api = Class.forName(API_CLASS);
            mIsAvailable = api.getMethod("isAvailable");
            mIsTinkerItem = api.getMethod("isTinkerItem", ItemStack.class);
            mIsIngot = api.getMethod("isIngot", ItemStack.class);
            mGetMaterialId = api.getMethod("getMaterialId", ItemStack.class);
            mGetIngot = api.getMethod("getIngot", String.class);
            mListMaterialIds = api.getMethod("listMaterialIds");
            available = (boolean) mIsAvailable.invoke(null);
            if (available) {
                int count = listMaterialIds().size();
                logger.info("⚒️ MultiverseTinker detectado: interoperabilidad de metales activa (" + count + " materiales).");
            } else {
                logger.info("MultiverseTinker presente pero aun no listo; el puente reintentara en uso.");
            }
        } catch (ClassNotFoundException notFound) {
            available = false;
            logger.info("MultiverseTinker no instalado: SlimeTinker funciona standalone (puente latente).");
        } catch (Throwable t) {
            available = false;
            logger.warning("No se pudo enganchar MultiverseTinker: " + t.getMessage());
        }
    }

    /** True si MultiverseTinker esta cargado y su API responde. */
    public static boolean isAvailable() {
        if (mIsAvailable == null) {
            return false;
        }
        try {
            return (boolean) mIsAvailable.invoke(null);
        } catch (Throwable t) {
            return false;
        }
    }

    /** ¿El item es un objeto de MultiverseTinker (raw/ingot/nugget/…)? */
    public static boolean isMvTinkerItem(ItemStack item) {
        return invokeBool(mIsTinkerItem, item);
    }

    /** ¿El item es un lingote de MultiverseTinker (candidato a fundir en SlimeTinker)? */
    public static boolean isMvTinkerIngot(ItemStack item) {
        return invokeBool(mIsIngot, item);
    }

    /** Id del material del item MVTinker (p. ej. "bronze"), o null. */
    public static String getMaterialId(ItemStack item) {
        if (!available || mGetMaterialId == null) {
            return null;
        }
        try {
            return (String) mGetMaterialId.invoke(null, item);
        } catch (Throwable t) {
            return null;
        }
    }

    /** Lingote MVTinker de ese material, o null si no existe / MVTinker ausente. */
    public static ItemStack getIngot(String materialId) {
        if (!available || mGetIngot == null) {
            return null;
        }
        try {
            return (ItemStack) mGetIngot.invoke(null, materialId);
        } catch (Throwable t) {
            return null;
        }
    }

    /** Ids de todos los materiales/alloys de MultiverseTinker (para mapeo). */
    @SuppressWarnings("unchecked")
    public static List<String> listMaterialIds() {
        if (!available || mListMaterialIds == null) {
            return Collections.emptyList();
        }
        try {
            return (List<String>) mListMaterialIds.invoke(null);
        } catch (Throwable t) {
            return Collections.emptyList();
        }
    }

    private static boolean invokeBool(Method method, ItemStack item) {
        if (!available || method == null || item == null) {
            return false;
        }
        try {
            return (boolean) method.invoke(null, item);
        } catch (Throwable t) {
            return false;
        }
    }
}
