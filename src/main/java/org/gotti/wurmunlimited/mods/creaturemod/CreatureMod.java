package org.gotti.wurmunlimited.mods.creaturemod;

import org.gotti.wurmunlimited.modloader.interfaces.Initable;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Bull;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Calf;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Cat;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Chicken;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Cow;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Dog;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Foal;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Hen;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Horse;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Ocelot;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.PandaBear;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Pig;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Rooster;
import org.gotti.wurmunlimited.mods.creaturemod.creatures.Zebra;
import org.gotti.wurmunlimited.modsupport.creatures.ModCreature;
import org.gotti.wurmunlimited.modsupport.creatures.ModCreatures;

public class CreatureMod implements WurmServerMod, Initable {
	public void init() {
		ModCreatures.init();
		ModCreatures.addCreature((ModCreature) new PandaBear());
		ModCreatures.addCreature((ModCreature) new Zebra());
		ModCreatures.addCreature((ModCreature) new Ocelot());
		ModCreatures.addCreature((ModCreature) new Cat());
		ModCreatures.addCreature((ModCreature) new Horse());
		ModCreatures.addCreature((ModCreature) new Chicken());
		ModCreatures.addCreature((ModCreature) new Rooster());
		ModCreatures.addCreature((ModCreature) new Hen());
		ModCreatures.addCreature((ModCreature) new Pig());
		ModCreatures.addCreature((ModCreature) new Cow());
		ModCreatures.addCreature((ModCreature) new Dog());
		ModCreatures.addCreature((ModCreature) new Calf());
		ModCreatures.addCreature((ModCreature) new Bull());
		ModCreatures.addCreature((ModCreature) new Foal());
	}
}
