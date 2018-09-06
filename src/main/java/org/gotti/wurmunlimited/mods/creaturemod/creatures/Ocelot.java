package org.gotti.wurmunlimited.mods.creaturemod.creatures;

import org.gotti.wurmunlimited.modsupport.creatures.EncounterBuilder;
import com.wurmonline.mesh.Tiles;
import com.wurmonline.server.combat.ArmourTemplate;

import org.gotti.wurmunlimited.modsupport.CreatureTemplateBuilder;
import com.wurmonline.shared.constants.CreatureTypes;
import com.wurmonline.shared.constants.ItemMaterials;

import org.gotti.wurmunlimited.modsupport.creatures.ModCreature;
import static com.wurmonline.server.skills.SkillList.*;
import static com.wurmonline.server.items.ItemList.*;

public class Ocelot implements ModCreature, CreatureTypes, ItemMaterials {

	private static final String MOD_CREATURE_OCELOT = "mod.creature.ocelot";
	private int templateId;

	public CreatureTemplateBuilder createCreateTemplateBuilder() {

		final int[] types = { C_TYPE_MOVE_LOCAL, C_TYPE_ANIMAL, C_TYPE_AGG_HUMAN, C_TYPE_HUNTING, C_TYPE_CLIMBER, C_TYPE_DOMINATABLE, C_TYPE_CARNIVORE };
		final int[] itemsButchered = new int[] { meat, paw, pelt };
		
		CreatureTemplateBuilder builder = new CreatureTemplateBuilder(MOD_CREATURE_OCELOT, "Ocelot", "Looking like a huge cat, with a dappled coat.", "model.creature.quadraped.lion.ocelot", types, (byte) 3, (short) 5, (byte) 0, (short) 60, (short) 30, (short) 90, "sound.death.lion",
				"sound.death.lion", "sound.combat.hit.lion", "sound.combat.hit.lion", 0.95f, 3.0f, 0.0f, 5.0f, 0.0f, 0.0f, 1.0f, 1200, itemsButchered, 10, 40, MATERIAL_MEAT_CAT);

		this.templateId = builder.getTemplateId();

		builder.skill(BODY_STRENGTH, 15.0f);
		builder.skill(BODY_CONTROL, 3.0f);
		builder.skill(BODY_STAMINA, 15.0f);
		builder.skill(MIND_LOGICAL, 7.0f);
		builder.skill(MIND_SPEED, 8.0f);
		builder.skill(SOUL_STRENGTH, 25.0f);
		builder.skill(SOUL_DEPTH, 4.0f);
		builder.skill(WEAPONLESS_FIGHTING, 6.0f);

		builder.handDamString("claw");
		builder.kickDamString("claw");
		builder.maxAge(100);
		builder.armourType(ArmourTemplate.ARMOUR_TYPE_CLOTH);
		builder.baseCombatRating(3.0f);
		builder.combatDamageType((byte) 1);
		builder.maxGroupAttackSize(2);
		builder.denName("ocelot hideout");
		builder.denMaterial((byte) 15);
		builder.maxPercentOfCreatures(0.06f);

		return builder;
	}

	public void addEncounters() {
		if (templateId == 0)
			return;

		new EncounterBuilder(Tiles.Tile.TILE_TREE.id).addCreatures(templateId, 2).build(1);

		new EncounterBuilder(Tiles.Tile.TILE_CAVE.id, (byte) -1).addCreatures(templateId, 2).build(1);
	}
}