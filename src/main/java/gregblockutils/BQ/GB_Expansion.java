package gregblockutils.BQ;

import betterquesting.api.api.IQuestExpansion;
import betterquesting.api.api.QuestExpansion;
import gregblockutils.GregBlockUtils;

@QuestExpansion
public class GB_Expansion implements IQuestExpansion {
    @Override
    public void loadExpansion() {
        GregBlockUtils.proxy.registerExpansion();
    }
}