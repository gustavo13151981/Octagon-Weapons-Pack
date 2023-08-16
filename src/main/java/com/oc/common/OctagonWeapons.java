package com.oc.common;

import com.fmum.common.FMUM;
import com.fmum.common.pack.FolderPack;
import com.fmum.common.pack.IContentPack;
import com.fmum.common.pack.IContentPackFactory;
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
public final class OctagonWeapons implements IContentPackFactory
{
	private final IContentPackFactory wrapped_pack;
	
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
	public IContentPack createServerSide( IPrepareContext ctx ) {
		return this.wrapped_pack.createServerSide( ctx );
	}
	
	@Override
	@SideOnly( Side.CLIENT )
	public IContentPack createClientSide( IPrepareContext ctx ) {
		return this.wrapped_pack.createClientSide( ctx );
	}
}
