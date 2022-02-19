# ColorTiles
An Undertale-inspired game where the player must navigate an obstacle-filled board to reach the other side.

GOAL: 


Reach any of the pink tiles on the right side of the board.

TILES:


```Red```: Sends you one square to the left of it. If there are multiple red tiles next to each other, you will be sent to the left of all of them. No matter where you land, you will be safe.

```Blue```: Safe to walk on, as long as there is no yellow square directly next to it (diagonal is safe).
```Yellow```: Has a 50% chance to reroll the entire board.

```Orange```: Deadly.

```Purple```: Changes once you step on it.

Uses [StdDraw libraries](https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html#:~:text=The%20StdDraw%20class%20provides%20a,the%20drawings%20to%20a%20file.) from Princeton.
