package gsf.oc.common;

import com.fmum.FMUM;
import com.fmum.load.ModPackFactory;
import net.minecraftforge.fml.common.Mod;

@Mod(
	modid = "oc",
	name = "Octagon Weapons Pack",
	version = "0.3.3",
	acceptedMinecraftVersions = "1.12.2",
	dependencies = "required-after:" + FMUM.MODID + ";"
)
public final class OctagonWeapons extends ModPackFactory {
	// Pass.
}
