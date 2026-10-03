package net.jahus.nocushionhop.mixin;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.decoration.Cushion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * If the player is already riding a cushion, cancel interact on another cushion.
 * Stops the "cushion highway" hop exploit.
 */
@Mixin(Cushion.class)
public class CushionMixin {
	@Inject(method = "interact", at = @At("HEAD"), cancellable = true)
	private void noCushionHop$blockWhileSeated(
			Player player,
			InteractionHand hand,
			Vec3 location,
			CallbackInfoReturnable<InteractionResult> cir) {
		if (player.getVehicle() instanceof Cushion) {
			cir.setReturnValue(InteractionResult.PASS);
		}
	}
}
