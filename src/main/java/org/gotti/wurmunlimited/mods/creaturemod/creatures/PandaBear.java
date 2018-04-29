// 
// Decompiled by Procyon v0.5.31
// 

package org.gotti.wurmunlimited.mods.creaturemod.creatures;

import org.gotti.wurmunlimited.modsupport.CreatureTemplateBuilder;
import org.gotti.wurmunlimited.modsupport.creatures.EncounterBuilder;
import org.gotti.wurmunlimited.modsupport.creatures.ModCreature;
import org.gotti.wurmunlimited.modsupport.vehicles.ModVehicleBehaviour;
import org.gotti.wurmunlimited.modsupport.vehicles.VehicleFacade;

import com.wurmonline.mesh.Tiles;
import com.wurmonline.server.behaviours.Vehicle;
import com.wurmonline.server.combat.ArmourTypes;
import com.wurmonline.server.creatures.AttackAction;
import com.wurmonline.server.creatures.AttackIdentifier;
import com.wurmonline.server.creatures.AttackValues;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.shared.constants.CreatureTypes;
import com.wurmonline.server.items.Item;
import com.wurmonline.shared.constants.ItemMaterials;

import static com.wurmonline.server.skills.SkillList.*;
import static com.wurmonline.server.items.ItemList.*;

public class PandaBear implements ModCreature, CreatureTypes, ItemMaterials, ArmourTypes {

	private int templateId;

	public CreatureTemplateBuilder createCreateTemplateBuilder() {

		final int[] types = { C_TYPE_MOVE_GLOBAL, C_TYPE_VEHICLE, C_TYPE_ANIMAL, C_TYPE_AGG_HUMAN, C_TYPE_SWIMMING, C_TYPE_HUNTING, C_TYPE_DOMINATABLE, C_TYPE_CARNIVORE, C_TYPE_NON_NEWBIE };
		final int[] itemsButchered = new int[] { meat, tooth, fur };
		
		CreatureTemplateBuilder builder = new CreatureTemplateBuilder("mod.creature.panda", "Panda bear", "The panda bear has large, distinctive black patches around its eyes, over the ears, and across its round body.", "model.creature.quadraped.bear.panda", types, (byte) 2, (short) 5, (byte) 0,
				(short) 230, (short) 50, (short) 50, "sound.death.bear", "sound.death.bear", "sound.combat.hit.bear", "sound.combat.hit.bear", 0.75f, 7.0f, 0.0f, 10.0f, 0.0f, 0.0f, 1.2f, 1500, itemsButchered, 10, 70, MATERIAL_MEAT_BEAR);

		this.templateId = builder.getTemplateId();

		builder.skill(BODY_STRENGTH, 30.0f);
		builder.skill(BODY_CONTROL, 30.0f);
		builder.skill(BODY_STAMINA, 30.0f);
		builder.skill(MIND_LOGICAL, 4.0f);
		builder.skill(MIND_SPEED, 4.0f);
		builder.skill(SOUL_STRENGTH, 30.0f);
		builder.skill(SOUL_DEPTH, 4.0f);
		builder.skill(WEAPONLESS_FIGHTING, 40.0f);

		builder.boundsValues(-0.5f, -1.0f, 0.5f, 1.42f);
		builder.handDamString("maul");
		builder.maxAge(200);
		builder.armourType(ARMOUR_STUDDED);
		builder.baseCombatRating(9.0f);
		builder.combatDamageType((byte) 0);
		builder.maxGroupAttackSize(4);
		builder.denName("bear cave");
		builder.denMaterial(MATERIAL_STONE);
		builder.maxPercentOfCreatures(0.02f);
		builder.usesNewAttacks(true);
		builder.addPrimaryAttack(new AttackAction("maul", AttackIdentifier.STRIKE, new AttackValues(7.0f, 0.01f, 6.0f, 3, 1, (byte) 0, false, 2, 1.0f)));
		builder.addPrimaryAttack(new AttackAction("gnaw", AttackIdentifier.BITE, new AttackValues(5.0f, 0.02f, 8.0f, 3, 1, (byte) 3, false, 4, 1.1f)));
		builder.addSecondaryAttack(new AttackAction("bite", AttackIdentifier.BITE, new AttackValues(10.0f, 0.05f, 6.0f, 2, 1, (byte) 3, false, 3, 1.1f)));
		builder.addSecondaryAttack(new AttackAction("scratch", AttackIdentifier.STRIKE, new AttackValues(7.0f, 0.05f, 6.0f, 2, 1, (byte) 1, false, 8, 1.0f)));

		return builder;
	}

	public ModVehicleBehaviour getVehicleBehaviour() {

		return new ModVehicleBehaviour() {

			@Override
			public void setSettingsForVehicle(Item item, Vehicle vehicle) {
			}

			@Override
			public void setSettingsForVehicle(Creature creature, Vehicle v) {
				VehicleFacade vehicle = wrap(v);

				vehicle.createPassengerSeats(0);
				vehicle.setSeatFightMod(0, 0.8f, 1.1f);
				vehicle.setSeatOffset(0, 0.0f, 0.0f, 0.0f);
				vehicle.setCreature(true);
				vehicle.setSkillNeeded(23.0f);
				vehicle.setName(creature.getName());
				vehicle.setMaxHeightDiff(0.04f);
				vehicle.setMaxDepth(-0.7f);
				vehicle.setMaxSpeed(20.0f);
				vehicle.setCommandType((byte) 3);
			}
		};
	}

	@Override
	public void addEncounters() {
		if (templateId == 0)
			return;

		new EncounterBuilder(Tiles.Tile.TILE_TREE.id).addCreatures(templateId, 2).build(1);

		new EncounterBuilder(Tiles.Tile.TILE_CAVE.id, (byte) -1).addCreatures(templateId, 2).build(4);
	}

}