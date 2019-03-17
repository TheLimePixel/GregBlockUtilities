package gregblockutils.Events;

import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class StoneGenEvents {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void stoneGen(BlockEvent.FluidPlaceBlockEvent event) {
        if (event.getOriginalState().getBlock() == Blocks.FLOWING_LAVA) {
            BlockPos lavaPos = event.getLiquidPos(), waterPos = null;
            World world = Minecraft.getMinecraft().world;
            for (BlockPos pos : new BlockPos[]{lavaPos.east(), lavaPos.west(), lavaPos.north(), lavaPos.south()})
                if (world.getBlockState(pos).getBlock().getMaterial(world.getBlockState(pos)) == Material.WATER) {
                    waterPos = pos;
                    break;
                }
            if (waterPos != null) {
                switch (world.getBlockState(waterPos).getBlock().getMetaFromState(world.getBlockState(waterPos))) {
                    case 2:
                    case 3:
                        event.setNewState(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE));
                        break;
                    case 4:
                    case 5:
                        event.setNewState(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE));
                        break;
                    case 6:
                    case 7:
                        event.setNewState(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE));
                        break;
                    default:
                        event.setNewState(Blocks.COBBLESTONE.getDefaultState());
                }
            }
        }
    }
}
