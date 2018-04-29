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

public class Horse implements ModCreature {

	private static final int COLOR_PIEBALD = 33;
	private static final int COLOR_MANGA_LARGA_MARCHADOR = 32;
	private static final int COLOR_ROCKY_MOUNTAIN = 30;
	private static final int COLOR_XAPPALOOSA = 34;
	private static final int COLOR_KNABSTRUPPER = 35;
	private static final int COLOR_SKEWBALD = 26;
	private static final int COLOR_REGULAR_BAY = 31;
	private static final int COLOR_EBONY_BLACK = ModTraits.COLOR_EBONY_BLACK;
	private static final int COLOR_BLOOD_BAY = ModTraits.COLOR_BLOOD_BAY;
	private static final int COLOR_PIEBALD_PINTO = ModTraits.COLOR_PIEBALD_PINTO;
	private static final int COLOR_WHITE = ModTraits.COLOR_WHITE;
	private static final int COLOR_BLACK = ModTraits.COLOR_BLACK;
	private static final int COLOR_GOLD = ModTraits.COLOR_GOLD;
	private static final int COLOR_BROWN = ModTraits.COLOR_BROWN;
	
	private static final int COLOR_TRAITS = 
			1 << COLOR_PIEBALD |
			1 << COLOR_MANGA_LARGA_MARCHADOR | 
			1 << COLOR_ROCKY_MOUNTAIN | 
			1 << COLOR_XAPPALOOSA |
			1 << COLOR_KNABSTRUPPER | 
			1 << COLOR_SKEWBALD |
			1 << COLOR_REGULAR_BAY |
			1 << COLOR_EBONY_BLACK |
			1 << COLOR_BLOOD_BAY |
			1 << COLOR_PIEBALD_PINTO |
			1 << COLOR_WHITE |
			1 << COLOR_BLACK |
			1 << COLOR_GOLD |
			1 << COLOR_BROWN;

	public CreatureTemplateBuilder createCreateTemplateBuilder() {
		return new CreatureTemplateBuilder(CreatureTemplateIds.HORSE_CID) {
			public CreatureTemplate build() {
				try {
					return CreatureTemplateFactory.getInstance().getTemplate(CreatureTemplateIds.HORSE_CID);
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
		case COLOR_EBONY_BLACK:
			return "ebonyblack";
		case COLOR_PIEBALD_PINTO:
			return "piebaldpinto";
		case COLOR_BLOOD_BAY:
			return "bloodbay";
		case COLOR_SKEWBALD:
			return "skewbald";
		case COLOR_KNABSTRUPPER:
			return "knabstrupper";
		case COLOR_XAPPALOOSA:
			return "knabstrupperxappaloosa";
		case COLOR_ROCKY_MOUNTAIN:
			return "rockymountain";
		case COLOR_REGULAR_BAY:
			return "regularbay";
		case COLOR_MANGA_LARGA_MARCHADOR:
			return "mangalargamarchador";
		case COLOR_PIEBALD:
			return "piebald";
		default:
			return null;
		}
	}

	public void assignTraits(final TraitsSetter traitsSetter) {
		int rand = Server.rand.nextInt(110);
		if (rand < 30) {
			traitsSetter.setTraitBit(COLOR_BROWN, true);
		} else if (rand < 40) {
			traitsSetter.setTraitBit(COLOR_GOLD, true);
		} else if (rand < 50) {
			traitsSetter.setTraitBit(COLOR_BLACK, true);
		} else if (rand < 60) {
			traitsSetter.setTraitBit(COLOR_WHITE, true);
		} else if (rand < 65) {
			traitsSetter.setTraitBit(COLOR_PIEBALD_PINTO, true);
		} else if (rand < 70) {
			traitsSetter.setTraitBit(COLOR_BLOOD_BAY, true);
		} else if (rand < 75) {
			traitsSetter.setTraitBit(COLOR_EBONY_BLACK, true);
		} else if (rand < 80) {
			traitsSetter.setTraitBit(COLOR_REGULAR_BAY, true);
		} else if (rand < 85) {
			traitsSetter.setTraitBit(COLOR_MANGA_LARGA_MARCHADOR, true);
		} else if (rand < 90) {
			traitsSetter.setTraitBit(COLOR_SKEWBALD, true);
		} else if (rand < 95) {
			traitsSetter.setTraitBit(COLOR_PIEBALD, true);
		} else if (rand < 100) {
			traitsSetter.setTraitBit(COLOR_KNABSTRUPPER, true);
		} else if (rand < 105) {
			traitsSetter.setTraitBit(COLOR_XAPPALOOSA, true);
		} else if (rand < 110) {
			traitsSetter.setTraitBit(COLOR_ROCKY_MOUNTAIN, true);
		}
	}
	
	@Override
	public long calcNewTraits(double breederSkill, boolean inbred, long mothertraits, long fathertraits) {
		return ModTraits.calcNewTraits(breederSkill, inbred, mothertraits, fathertraits, ModTraits.REGULAR_TRAITS, COLOR_TRAITS);
	}
}
