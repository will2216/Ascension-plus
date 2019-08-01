package ascensionMod.stspatches.plus;

import com.evacipated.cardcrawl.modthespire.lib.ByRef;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
//import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;

import ascensionMod.AscensionMod;
import ascensionMod.UI.CharSelectScreenUI;
 

public class HealPatch 
{ 
	private static float lessHealPct = 0.20f;
	
	@SpirePatch(
		cls = "com.megacrit.cardcrawl.core.AbstractCreature",
		method = "heal",
		paramtypes={"int", "boolean"}
	)
	public static class HealthGainCreaturePatch{
		public static void Prefix(AbstractCreature __instance, @ByRef int[] healAmt) {
			if(AscensionMod.AbsoluteAscensionLevel >= 23 || (AscensionMod.customAscensionRun && CharSelectScreenUI.ascScreen.posAscButtons.get(22).toggledOn)) {
				healAmt[0] -= Math.round(healAmt[0]*lessHealPct);
			}
		}
	}
} 	 