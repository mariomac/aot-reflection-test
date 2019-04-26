package info.macias.aotrt;

import info.macias.kaconf.Configurator;
import info.macias.kaconf.ConfiguratorBuilder;

public class App {
	public static void main(String[] args) {
		Configurator c = new ConfiguratorBuilder()
				.addSource(System.getenv())
				.build();

		Config cfg = new Config();
		c.configure(cfg);
		c.configure(StaticConfig.class);

		System.out.println(StaticConfig.GREETING + ", " + cfg.getName() + "!");
	}
}
