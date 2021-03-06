# achievementSystemDesign

The fictional game is played online between two teams. Each team can have 3-5 players (but must be evenly matched – i.e., if one team has 4 players, the other must have 4 players). The below statistics are compiled for each player during/after each game:

● Number of attempted attacks

● Number of hits

● Total Amount of damage done

● Number of kills

● Number of “first hit” kills

● Number of assists

● Total number of spells cast

● Total spell damage done

● Total time played

In addition, historical player statistics are maintained as well. For instance, each player is credited with a win/loss based upon the performance of his/her team during the game. Other historical player-level stats can be tracked as well – such as total number of games played, total duration of games played, total number of kills, etc.

Achievements are awarded based upon any combination of these statistics (historical OR game-specific). Players collect achievements over time, and these will be displayed on their profile page (the display is outside the scope of this exercise). This profile page is visible to all other players, so achievements act as a kind of “badge of honor”. After each game has ended, the achievements logic is called and achievements are awarded to each of the players if applicable.


The system is capable of below

● The achievements system can assign achievements to each player involved in the game that just ended, if applicable.

● All the domain objects suggested in the above description are outlined and created.

● The achievements system awards the following achievements as of now:

o “Sharpshooter Award” – a user receives this for landing 75% of their attacks, assuming they have at least attacked once.

o “Bruiser” Award – a user receives this for doing more than 500 points of damage in one game

o “Veteran” Award – a user receives this for playing more than 1000 games in their lifetime.

o “Big Winner” Award – a user receives this for having 200 wins

● The system is extensible in the following ways:

o The system must easily handle the tracking of additional statistics at
any level listed above (historical by player or game-specific by
player)

o The system must easily handle the addition of new achievements

●  The app has unit tests to demonstrate that the code is functional using the latest JUnit.

● A driver class that sets up sample data and calls the achievements system, printing out achievements to the console.

● Persistence, messaging, and other potential concerns are considered ancillary to this app.
