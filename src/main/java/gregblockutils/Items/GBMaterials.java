package gregblockutils.Items;

import gregtech.api.unification.material.IMaterialHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.IngotMaterial;

@IMaterialHandler.RegisterMaterialHandler
public class GBMaterials {
    static {
        Materials.Iron.addFlag(IngotMaterial.MatFlags.GENERATE_SMALL_GEAR);
    }
}
