# Java Adventure Game

Welcome to the Java Adventure Game, a text-based adventure written in Java. In this game, players choose a hero and embark on a journey filled with monsters, events, and challenges.

## Overview

The Java Adventure Game is a single-player text-based adventure where the player's chosen hero navigates through various challenges to defeat the final boss, the Dragon. Along the way, players encounter events like markets and pet encounters, as well as battles with randomly spawned monsters. The game features four unique hero classes, each with its own abilities and attributes, providing different gameplay experiences.

## Getting Started

### Prerequisites

To run the game, you need:

- Java Development Kit (JDK) installed on your system
- Git (optional) for cloning the repository

## Gameplay

### Choosing a Hero

Players can choose from four different hero classes:

1. **Archer**: Agile and skilled with the bow, the Archer excels at ranged combat.
2. **Wizard**: Master of arcane magic, the Wizard wields powerful spells to vanquish foes.
3. **Warrior**: Strong and resilient, the Warrior specializes in close-quarters combat.
4. **Assassin**: Stealthy and deadly, the Assassin strikes from the shadows with precision.

Each hero has unique attributes, abilities, and starting equipment, providing different playstyles and strategies.

### Starting the Journey

Once a hero is chosen, the player's journey begins. The hero must traverse a distance of 100 meters, encountering various challenges and events along the way.

### Encountering Events

Events occur every 25 meters of the journey:

- **Market Events**: Players can visit markets to purchase items such as potions and scrolls using coins earned from defeating monsters.
- **Pet Encounters**: Players may encounter wild pets and attempt to tame them using a Pet Whisperer item.

### Fighting Monsters

Randomly spawned monsters engage the player in battles. Players must choose actions such as fighting or fleeing. Defeating monsters rewards the player with experience points, coins, and other rewards.

### Leveling Up

Players gain experience points from defeating monsters. Upon reaching certain experience thresholds, the hero levels up, gaining increased health, attack, and other benefits.

### Final Boss Battle

Upon reaching the 100-meter mark, players face the Dragon Boss in a final battle. Victory against the Dragon Boss concludes the game.

## Classes and Components

The game consists of several classes and components:

- **Heroes**: Contains classes for each hero type, defining their attributes, abilities, and starting equipment.
- **Monsters**: Classes for different types of monsters encountered during the journey, each with unique stats and abilities.
- **Pets**: Classes representing different pet types that players can encounter and tame during their journey.
- **Events**: Manages random events encountered during the journey, such as markets and monster encounters.
- **Ability**: Represents special abilities that heroes and monsters can use during battles.
- **Game**: Entry point for running the game, handling hero selection and game progression.

## Contributing

Contributions to the game are welcome! If you have any suggestions, bug fixes, or new features to add, feel free to fork this repository and submit a pull request.

## Acknowledgments

- Inspired by classic text-based adventure games.
