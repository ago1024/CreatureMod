package org.gotti.wurmunlimited.mods.creaturemod.creatures;

import com.wurmonline.server.Server;
import org.gotti.wurmunlimited.modsupport.creatures.TraitsSetter;
import com.wurmonline.server.creatures.NoSuchCreatureTemplateException;
import com.wurmonline.server.creatures.CreatureTemplateFactory;
import com.wurmonline.server.creatures.CreatureTemplateIds;
import com.wurmonline.server.creatures.CreatureTemplate;
import org.gotti.wurmunlimited.modsupport.CreatureTemplateBuilder;
import org.gotti.wurmunlimited.modsupport.creatures.ModCreature;
import org.gotti.wurmunlimited.modsupport.creatures.ModTraits;

public class Cow implements ModCreature {
	private static final int COLOR_BELTED_GALLOWAY = 25;
	private static final int COLOR_BLACK_ANGUS = 24;

	public CreatureTemplateBuilder createCreateTemplateBuilder() {
		return new CreatureTemplateBuilder(CreatureTemplateIds.COW_BROWN_CID) {
			public CreatureTemplate build() {
				try {
					return CreatureTemplateFactory.getInstance().getTemplate(CreatureTemplateIds.COW_BROWN_CID);
				} catch (NoSuchCreatureTemplateException e) {
					throw new RuntimeException((Throwable) e);
				}
			}
		};
	}

	public boolean hasTraits() {
		return true;
	}

	@Override
	public String getTraitName(final int trait) {
		switch (trait) {
		case COLOR_BLACK_ANGUS:
			return "blackangus";
		case COLOR_BELTED_GALLOWAY:
			return "beltedgalloway";
		default:
			return null;
		}
	}

	public String getColourName(final int trait) {
		switch (trait) {
		case COLOR_BLACK_ANGUS:
			return "black angus";
		case COLOR_BELTED_GALLOWAY:
			return "belted galloway";
		default:
			return null;
		}
	}

	public void assignTraits(final TraitsSetter traitsSetter) {
		if (Server.rand.nextInt(3) == 0) {
			traitsSetter.setTraitBit(COLOR_BLACK_ANGUS, true);
		} else if (Server.rand.nextInt(3) == 0) {
			traitsSetter.setTraitBit(COLOR_BELTED_GALLOWAY, true);
		}
	}
	
	@Override
	public long calcNewTraits(double breederSkill, boolean inbred, long mothertraits, long fathertraits) {
		return ModTraits.calcNewTraits(breederSkill, inbred, mothertraits, fathertraits, ModTraits.REGULAR_TRAITS, 1 << COLOR_BLACK_ANGUS | 1 << COLOR_BELTED_GALLOWAY);
	}
	
}
