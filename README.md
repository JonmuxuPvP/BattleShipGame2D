# BattleShipGame2D
Welcome to my Java BattleShipGame2D. I clearly do not have an original name for it, but I doubt I will ever come up with something interesting. The game only features a demo mode where you can see the different Artificial Intelligence Levels I made. This project is just for testing purposes, I do not intend to make a battleship game to be playable on console. In the future, I will most likely develop this game again, implementing a real Graphical User Interface with gamemodes.

If you would like to check out the game, you can download the game on the releases tab of this repository, feel free to check the code as well!

## Artificial Intelligence Levels
When you first open up the game, you will find three AI levels. Here is what they do:
* Level 1: Shoots randomly across the board.
* Level 2: Also shoots randomly across the board, but upon hitting a ship, it will define four possible targets, shooting and discarding depending if the ship was hit or not.
* Level 3: Randomly shoots using the parity pattern, or more like a checker board pattern (imagine a chess board, meaning it will only fire on black or white tiles). Since every ship has a minimum length of two, we discard fifty possible spots, thus making it more efficient to find ships.

For reference if it wasn't clear enough, I recommend you check out this webpage: https://www.datagenetics.com/blog/december32011/

## Game Speed
For reference, here is the speed the console will be cleared at depending on the mode you selected
* Slow: 400 milliseconds
* Medium: 250 milliseconds
* Fast: 100 milliseconds

## Running the Game
In order to play the game, you first need to make sure Java is installed in your computer. Then, open up your cmd or terminal depending on your Operating System and execute the jar file with the following command:
```
java -jar [path]
```
Where [path] is either the relative or absolute path of your jar file. Ex: C:\Users\MyPC\Desktop\BattleShipGame2D.jar
This is the only way the game can be executed for now since there is no Graphical User Interface. Enjoy testing the demo and let me know if you encounter a bug!
