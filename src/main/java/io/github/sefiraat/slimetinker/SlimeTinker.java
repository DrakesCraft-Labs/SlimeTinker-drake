package io.github.sefiraat.slimetinker;



import java.text.MessageFormat;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import io.github.sefiraat.slimetinker.itemgroups.ItemGroups;
import io.github.sefiraat.slimetinker.items.Casts;
import io.github.sefiraat.slimetinker.items.Dies;
import io.github.sefiraat.slimetinker.items.Guide;
import io.github.sefiraat.slimetinker.items.Materials;
import io.github.sefiraat.slimetinker.items.Mods;
import io.github.sefiraat.slimetinker.items.Parts;
import io.github.sefiraat.slimetinker.items.Workstations;
import io.github.sefiraat.slimetinker.items.tinkermaterials.TinkerMaterialManager;
import io.github.sefiraat.slimetinker.items.workstations.workbench.Workbench;
import io.github.sefiraat.slimetinker.listeners.ListenerManager;
import io.github.sefiraat.slimetinker.managers.DispatchManager;
import io.github.sefiraat.slimetinker.managers.MemoryManager;
import io.github.sefiraat.slimetinker.managers.TraitManager;
import io.github.sefiraat.slimetinker.runnables.RunnableManager;
import com.github.drakescraft_labs.slimefun4.api.SlimefunAddon;
import org.bukkit.plugin.java.JavaPlugin;

public class SlimeTinker extends JavaPlugin implements SlimefunAddon {

    private static final int DEFAULT_EFFECT_TICK_PERIOD = 40;
    private static final int DEFAULT_TRAIL_TICK_PERIOD = 5;
    private static final int DEFAULT_TRAIL_PARTICLES_PER_PLAYER = 11;

    private static SlimeTinker instance;

    private final String username;
    private final String repo;
    private final String branch;

    private RunnableManager runnableManager;
    private ListenerManager listenerManager;
    private TinkerMaterialManager tinkerMaterialManager;
    private DispatchManager dispatchManager;
    private Workbench workbench;
    private TraitManager traitManager;
    private MemoryManager memoryManager;

    public SlimeTinker() {
        this.username = "Sefiraat";
        this.repo = "SlimeTinker";
        this.branch = "master";
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        // Merge new safe defaults into existing installations without replacing local tuning.
        getConfig().options().copyDefaults(true);
        saveConfig();

        getLogger().info("########################################");
        getLogger().info(" SlimeTinker - Drake maintained edition ");
        getLogger().info("########################################");

        ItemGroups.set(this);
        Materials.set(this);
        Dies.set(this);
        Casts.set(this);
        Parts.set(this);
        Guide.set(this);
        Mods.set(this);
        Workstations.set(this);

        traitManager = new TraitManager();
        tinkerMaterialManager = new TinkerMaterialManager();
        runnableManager = new RunnableManager();
        dispatchManager = new DispatchManager();
        memoryManager = new MemoryManager();

        this.listenerManager = new ListenerManager(this, this.getServer().getPluginManager());

        getLogger().info("Runtime: effects every " + getEffectTickPeriod() + "t, trails every "
            + getTrailTickPeriod() + "t (max " + getTrailParticlesPerPlayer() + " particles/player).");
    }

    @Override
    public void onDisable() {
        saveConfig();
        instance = null;
    }


    public RunnableManager getRunnableManager() {
        return runnableManager;
    }

    public ListenerManager getListenerManager() {
        return listenerManager;
    }

    public TinkerMaterialManager getCmManager() {
        return tinkerMaterialManager;
    }

    public DispatchManager getDispatchManager() {
        return dispatchManager;
    }

    public Workbench getWorkbench() {
        return workbench;
    }

    public void setWorkbench(Workbench workbench) {
        this.workbench = workbench;
    }

    public TraitManager getTraitManager() {
        return traitManager;
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return MessageFormat.format("https://github.com/{0}/{1}/issues/", this.username, this.repo);
    }

    public static SlimeTinker getInstance() {
        return instance;
    }

    /**
     * Returns a bounded cadence for trait effects so an invalid config cannot create a hot loop.
     */
    public int getEffectTickPeriod() {
        return boundedConfigValue("runtime.effect-tick-period", DEFAULT_EFFECT_TICK_PERIOD, 20, 200);
    }

    /**
     * Returns a bounded cadence for cosmetic trails.
     */
    public int getTrailTickPeriod() {
        return boundedConfigValue("runtime.trail-tick-period", DEFAULT_TRAIL_TICK_PERIOD, 1, 100);
    }

    /**
     * Caps cosmetic particles per player to keep the scheduler predictable under load.
     */
    public int getTrailParticlesPerPlayer() {
        return boundedConfigValue("runtime.trail-particles-per-player", DEFAULT_TRAIL_PARTICLES_PER_PLAYER, 0, 24);
    }

    private int boundedConfigValue(String path, int fallback, int minimum, int maximum) {
        int value = getConfig().getInt(path, fallback);
        if (value < minimum || value > maximum) {
            getLogger().warning("Invalid value for " + path + ": " + value + ". Using " + fallback + ".");
            return fallback;
        }
        return value;
    }
}
