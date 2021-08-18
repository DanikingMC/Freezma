package com.freezma.mixin;

import com.freezma.common.Freezma;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SnowballEntity.class)
public abstract class SnowBallEntityMixin {

    @Inject(method = "onEntityHit", at = @At("HEAD"))
    public void onEntityHit(EntityHitResult entityHitResult, CallbackInfo ci) {
        final Entity target = entityHitResult.getEntity();
        if (Freezma.config.worksOnPlayers && target instanceof PlayerEntity) {
            ((PlayerEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, Freezma.config.FreezingMs / 50, Freezma.config.amplifier));
        } else {
            if (!(target instanceof PlayerEntity)) {
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, Freezma.config.FreezingMs / 50, Freezma.config.amplifier));
            }
        }
    }
}
