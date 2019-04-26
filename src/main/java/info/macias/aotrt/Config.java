package info.macias.aotrt;

import info.macias.kaconf.Property;

public class Config {
	@Property("NAME")
	private String name = "world";

	public String getName() {
		return name;
	}
}
