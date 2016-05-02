package org.gotti.wurmunlimited.mods.samplemod;

import java.util.logging.Logger;

import org.gotti.wurmunlimited.modloader.interfaces.Initable;
import org.gotti.wurmunlimited.modloader.interfaces.ItemTemplatesCreatedListener;
import org.gotti.wurmunlimited.modloader.interfaces.PreInitable;
import org.gotti.wurmunlimited.modloader.interfaces.ServerStartedListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmMod;

import com.wurmonline.server.MiscConstants;
import com.wurmonline.server.items.ItemTypes;

public class SampleMod implements WurmMod, Initable, PreInitable, ServerStartedListener, ItemTemplatesCreatedListener, ItemTypes, MiscConstants {

	private static final Logger LOGGER = Logger.getLogger(SampleMod.class.getName());

	@Override
	public void onItemTemplatesCreated() {
		LOGGER.info("onItemTemplatesCreated");
	}

	@Override
	public void onServerStarted() {
		LOGGER.info("onServerStarted");
	}

	@Override
	public void init() {
		LOGGER.info("init");
	}

	@Override
	public void preInit() {
		LOGGER.info("preInit");
	}

}
