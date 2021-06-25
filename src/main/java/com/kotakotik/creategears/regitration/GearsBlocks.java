package com.kotakotik.creategears.regitration;

import com.kotakotik.creategears.blocks.GearBlock;
import com.kotakotik.creategears.util.Registration;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTileEntities;
import com.simibubi.create.content.contraptions.relays.elementary.BracketedKineticBlockModel;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.Registrate;
import com.simibubi.create.repack.registrate.util.entry.BlockEntry;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;

import java.util.function.Function;

public class GearsBlocks extends Registration {
    public static BlockEntry<GearBlock> GEAR;

    public GearsBlocks(Registrate r) {
        super(r);
    }

    @Override
    public void register() {
        GEAR = r.block("gear", GearBlock::new)
                .simpleItem()
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .recipe((ctx, prov) -> {
                    ShapedRecipeBuilder.shapedRecipe(ctx.get(), 8)
                            .patternLine("www")
                            .patternLine("w w")
                            .patternLine("www")
                            .key('w', ItemTags.BUTTONS)
                            .addCriterion("has_cogwheels", prov.hasItem(AllBlocks.COGWHEEL.get()))
                            .build(prov);
                })
                .register();
    }
}
