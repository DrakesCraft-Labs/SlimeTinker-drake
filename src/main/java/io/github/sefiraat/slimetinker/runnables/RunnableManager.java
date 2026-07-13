package io.github.sefiraat.slimetinker.runnables;

import io.github.sefiraat.slimetinker.SlimeTinker;

public class RunnableManager {

    private final EffectTick effectTick;
    private final TrailTick trailTick;
    private final ArmourRemove armourRemove;
    private final FirstTick firstTick;

    public RunnableManager() {
        final SlimeTinker plugin = SlimeTinker.getInstance();

        this.effectTick = new EffectTick();
        effectTick.runTaskTimer(plugin, 0, plugin.getEffectTickPeriod());

        this.trailTick = new TrailTick();
        trailTick.runTaskTimer(plugin, 0, plugin.getTrailTickPeriod());

        this.armourRemove = new ArmourRemove();
        armourRemove.runTaskTimer(plugin, 0, plugin.getEffectTickPeriod());

        this.firstTick = new FirstTick();
        firstTick.runTaskLater(plugin, 1);
    }
}
