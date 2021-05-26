package com.sarinsa.dumb_ores.common.network;

import com.sarinsa.dumb_ores.common.capability.CapabilityHelper;
import com.sarinsa.dumb_ores.common.network.message.S2CUpdateEntityCactusAttract;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;

public class NetworkHelper {

    public static void updateEntityCactusAttract(ServerPlayerEntity playerEntity, LivingEntity entity, boolean marked) {
        PacketHandler.sendToClient(new S2CUpdateEntityCactusAttract(marked, entity.getId()), playerEntity);
    }

    public static void updateEntityCactusAttract(ServerPlayerEntity playerEntity, LivingEntity entity) {
        PacketHandler.sendToClient(new S2CUpdateEntityCactusAttract(CapabilityHelper.getCactusAttract(entity), entity.getId()), playerEntity);
    }
}
