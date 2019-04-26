# aot-reflection-test
A test with Graal ahead-of-time compiler and reflection

## Executing insinde the JVM as a jar

1. Build the fat JAR: `./gradlew jar`
2. Execute the default Jar:

        $ java -jar build/libs/aot-reflection-test.jar
        Hello, world!
 
3. Pass configuration by the environment:

        $ GREETING="What's up" NAME="gang" java -jar build/libs/aot-reflection-test.jar
        What's up, gang!
        
## Allow reflection with GraalVM AOT

Aot-test without reflection:

        $ ./gradlew jar
        $ native-image --no-fallback -H:ReflectionConfigurationFiles=reflectconfig.json\
                -jar build/libs/aot-reflection-test.jar aot-test
        $ GREETING="What's up" NAME="gang" ./aot-test
        What's up, gang!

Limitations: can't write in final variables neither static:

	public static final String GREETING = KA.def("Hello");
	
nor simple final variables with the config: `{ "name" : "name", "allowWrite" : true }`
