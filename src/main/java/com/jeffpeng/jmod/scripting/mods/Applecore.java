package com.jeffpeng.jmod.scripting.mods;

import com.jeffpeng.jmod.JMODRepresentation;
import com.jeffpeng.jmod.primitives.OwnedObject;

import cpw.mods.fml.common.event.FMLInterModComms;

import com.jeffpeng.jmod.actions.applecore.ModifyFoodValue;

public class Applecore extends OwnedObject {

	public Applecore(JMODRepresentation owner){
		super(owner);
	}
	
	public void modifyFoodValue(String food, int hunger, float saturationModifier) {
		if(owner.testForMod("AppleCore")) new ModifyFoodValue(owner, food, hunger, saturationModifier);
	}
	
	public void blackListFoodFromHungerOverhaulChanges(String foodName) {
		if(owner.testForMod("AppleCore") && owner.testForMod("HungerOverhaul")) {
			FMLInterModComms.sendMessage("HungerOverhaul", "BlacklistFood", foodName);
		}
	}
}
