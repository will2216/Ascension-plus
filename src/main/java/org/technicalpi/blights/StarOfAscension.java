package org.technicalpi.blights;

import com.badlogic.gdx.graphics.Texture;

import org.technicalpi.AscensionMod;
import org.technicalpi.UI.CharSelectScreenUI;

public class StarOfAscension extends CustomBlight {
	public static final String ID = "AscMod:StarOfAscension";
    private static final String IMG = "blights/StarOfAscension.png";
    private static final String OUTLINE = "blights/outline/StarOfAscension.png";

    private static final int newPurgecost = 100;
    
    
    public StarOfAscension() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), true);   
    }
    
    @Override
    public void onEquip() {
    	if(AscensionMod.AbsoluteAscensionLevel >= 21 || (AscensionMod.customAscensionRun && CharSelectScreenUI.ascScreen.posAscButtons.get(20).toggledOn)) {
    		com.megacrit.cardcrawl.shop.ShopScreen.purgeCost = newPurgecost;
        	com.megacrit.cardcrawl.shop.ShopScreen.actualPurgeCost = newPurgecost;
    	}
    }
    
    @Override
    public int onPlayerHeal(int healAmount) {
    	if(AscensionMod.AbsoluteAscensionLevel >= 23 || (AscensionMod.customAscensionRun && CharSelectScreenUI.ascScreen.posAscButtons.get(22).toggledOn)) {
    		flash();
    	}
    	
    	return healAmount;
    }
}
