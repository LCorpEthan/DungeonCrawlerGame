# DungeonCrawlerGame

A simple Java dungeon crawler game where the player explores rooms, battles monsters, collects treasure, and faces a boss.

## Overview

- Uses object-oriented Java classes for cards, player stats, and dungeon rooms.
- Includes combat encounters, rest rooms, traps, treasure rewards, and a boss battle.
- A GUI is provided via `GamePanel` for exploring the dungeon.

## Run

From the project root, compile and run with:

```bash
javac *.java
java Runner
```

## Notes

- The player starts with a small action hand and can gain new cards from treasure rooms.
- The dungeon map tracks explored rooms and hidden boss location.
- The game ends when the player defeats the boss or runs out of HP.
