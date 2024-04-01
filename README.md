# Lachryvisions for 1.7.10
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

<img src="./src/main/resources/logo.png" alt="drawing" width="600"/>

**Lachryvisions** (pronounced Lack-REVISIONS, name has multiple meanings, Revisions and Vision) 
is a mod for **1.7.10** that aims to extend the functionality of the Minecraft version **1.7.10** 
with new features and certain backported features that are designed to maintain the look and feel of Vanilla Minecraft,
whilst also making the game better.
### TLDR: I HATE MICROSOFT.
1.9+ are the worst versions of the game, especially 1.19 and 1.20. In my eyes, there is just so much bloat
that doesn't need to be in the game, and Microsoft's acquisition of Minecraft aswell as annexing of Notch and kicking him
out from events, made me resent Microsoft even more. Even with Account Migration and 1.19 "Online Safety Features" it's just... 
<br><br>
It's not Minecraft anymore.<br><br>So I made a mod that allows me to modify Minecraft... well...
 however I envision! I also really wanted to get into Java and modding so this is how I was gonna do that. This mod exists so I can play Minecraft the way I intend to play it.
 And Microsoft cannot stop me. 
# Features
* Improved Sign Editing
* Boats no longer crash into planks and sticks
* More blocks and slabs 
* More wearable blocks, place a Dispenser on your head!
* Leather boots allow you to avoid trampling on your crops!
* More commands, like /gmc, /gms, /gma
* Improved stack limits of items that are limited to 16, to 64.
# Roadmap / Todo
* Backport good features from new versions (according to my personal tastes)
* Fix bugs and annoyances in 1.7.10
* Add Vanilla items that respect the artstyle of the game.
## Will you port to 1.9+?
No! Although I'm down for making a similar mod for 1.8.9 but removing stuff is harder than adding.

# Installation
Lachryvisions requires [Unimixins](https://www.curseforge.com/minecraft/mc-mods/unimixins) to load mixins and operate correctly. Once you have both mods downloaded, simply
drag and drop them into your mods folder. You must be using the latest version of **1.7.10 Forge**.
# Setup

You must use Java 8 to build the mod. (You can force a specific Java version in your IDE settings, or by setting the `JAVA_HOME` environmental variable if you are building from the command line.)

Building the mod:

```
./gradlew build
```

Running via Gradle:

```
./gradlew runClient
```

To run using a native IDE run configuration, you must add the following program arguments...

```
--tweakClass org.spongepowered.asm.launch.MixinTweaker --mixin mixins.unimixinsexample.json
```

...And the following JVM argument:

```
-Dfml.coreMods.load=me.lachrymogenic.lachryvision.Core
```

## License

This mod extends off of the Unimixins Example Mod and is licensed under the 
[MIT license](LICENSE).
