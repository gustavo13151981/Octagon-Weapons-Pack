package com.oc.common;

import com.fmum.common.FMUM;
import com.fmum.common.pack.FolderPack;
import com.fmum.common.pack.ILoadablePack;
import com.fmum.common.pack.IPreparedPack;
import com.fmum.common.pack.JarPack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(
	modid = "oc",
	name = "Octagon Weapons Pack",
	version = "0.3.3",
	acceptedMinecraftVersions = "1.12.2",
	dependencies = "required-after:" + FMUM.MODID
)
public final class OctagonWeapons implements ILoadablePack
{
	private final ILoadablePack wrapped_pack;
	
	public OctagonWeapons()
	{
		// Wrapped here to make it work in dev environment. If your pack only runs as released mod \
		// Then you can directly inherit JarPack and delete #wrapped_pack.
		final ModContainer mod_container = Loader.instance().activeModContainer();
		this.wrapped_pack = (
			mod_container.getSource().isFile()
			? new JarPack( mod_container )
			: new FolderPack( mod_container )
		);
	}
	
	@Override
	public IPreparedPack prepareLoadServerSide( IPrepareContext ctx ) {
		return this.wrapped_pack.prepareLoadServerSide( ctx );
	}
	
	@Override
	@SideOnly( Side.CLIENT )
	public IPreparedPack prepareLoadClientSide( IPrepareContext ctx ) {
		return this.wrapped_pack.prepareLoadClientSide( ctx );
	}
}
