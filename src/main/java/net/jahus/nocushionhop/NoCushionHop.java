package net.jahus.nocushionhop;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoCushionHop implements ModInitializer {
	public static final String MOD_ID = "no-cushion-hop";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("No Cushion Hop loaded — no hopping while seated");
	}
}
