package org.gotti.wurmunlimited.mods.creaturemod.creatures;

import org.gotti.wurmunlimited.modsupport.CreatureTemplateBuilder;
import org.gotti.wurmunlimited.modsupport.creatures.ModCreature;
import org.gotti.wurmunlimited.modsupport.creatures.ModTraits;
import org.gotti.wurmunlimited.modsupport.creatures.TraitsSetter;

import com.wurmonline.server.Server;
import com.wurmonline.server.creatures.CreatureTemplate;
import com.wurmonline.server.creatures.CreatureTemplateFactory;
import com.wurmonline.server.creatures.CreatureTemplateIds;
import com.wurmonline.server.creatures.NoSuchCreatureTemplateException;

public class Cat implements ModCreature {
	
	private static final int COLOR_MAINE_COON = 24;
	
	public CreatureTemplateBuilder createCreateTemplateBuilder() {
		return new CreatureTemplateBuilder(CreatureTemplateIds.CAT_WILD_CID) {
			public CreatureTemplate build() {
				try {
					return CreatureTemplateFactory.getInstance().getTemplate(CreatureTemplateIds.CAT_WILD_CID);
				} catch (NoSuchCreatureTemplateException e) {
					throw new RuntimeException((Throwable) e);
				}
			}
		};
	}

	public boolean hasTraits() {
		return true;
	}

	public String getTraitName(final int trait) {
		switch (trait) {
		case COLOR_MAINE_COON:
			return "mainecoon";
		default:
			return null;
		}
	}
	
	@Override
	public String getColourName(int trait) {
		switch (trait) {
		case COLOR_MAINE_COON:
			return "maine coon";
		default:
			return null;
		}
	}
	

	public void assignTraits(final TraitsSetter traitsSetter) {
		if (Server.rand.nextInt(3) == 0) {
			traitsSetter.setTraitBit(COLOR_MAINE_COON, true);
		}
	}
	
	@Override
	public long calcNewTraits(double breederSkill, boolean inbred, long mothertraits, long fathertraits) {
		return ModTraits.calcNewTraits(breederSkill, inbred, mothertraits, fathertraits, ModTraits.REGULAR_TRAITS, 1 << COLOR_MAINE_COON);
	}
}
