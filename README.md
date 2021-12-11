# Monopoly-------AP Computer Science Final Project - README Template
Monopoly Game 
Authors: Or Yagour, Mika Peer, Nitzan Shachar
Revision: 05/11/20


Our program will represent the game monopoly where there are players and locations on the board, and the goal of each player is to become the richest person. 
Children and adults can use our program to pass the time, especially nowadays during the quarantine, and could play with their friends to stay social.
We all like playing this game, and thought it would be a better experience for us to program a game that we actually like playing, instead of one that none of us know or like. 
However, we did make some changes. Instead of having chance and community chest cards like regular monopoly, we have ice breakers and exercise. 
* Everyone starts on the space that says, “Go”.
* Each turn, one player will toss the dice and move accordingly
* Whenever you land on land that no one owns, you can buy it from the bank. All of the prices for the land area on the board. Once you own the land, players must pay rent if they are waiting on your land.
* If you land on an Ice Breaker or Exercise card, you must do what it says in order to get money in the game
* If you roll doubles (the same number on both dice) you get to roll again. If you roll doubles three times in a row you must go to jail.
* When you pass go, you collect $200 from the bank (Unless you have to go to jail). 
* “Free Parking” is an area that is free to be in. If you land in the area you do not have to worry about paying for anything.
* Jail- There are two ways to get into jail: you land on the space labeled “Go to Jail” or you roll doubles three times. And there are also two ways to get out of jail: you get three turns to roll a double, if you do not roll a double in the three turns you must pay the fine or pay a fine of $50.
* Once you own all of one color, you can start to build houses. Houses make the land more costly and every time you add a house the price goes up more.


Children and their friends are our audiences for the game. We are addressing younger generations as it is a board game usually played by younger kids. 
Instructions:
[Explain how to use the program. This needs to be specific: 
Which keyboard keys will do what? 
Where will you need to click? 
Will you have menus that need to be navigated? What will they look like? 
Do actions need to be taken in a certain order?]


Starting screen:
Right click on “instructions” to view the instructions, click on “start game” to start the game


Instruction screen:
Right click on exit to go back to the starting screen


Game screen:
Right click on the dice to roll the dice.
Right click on Chance or a Community Chest card to view the card at the top
When you land on a land, click on “buy” to get the land, and on the dice to keep playing
When you are able to buy houses, in each of your turns you can click on “build” to get houses / hotels
When you are in jail and have the “Get out of Jail Free” card, you can click on it to leave jail


Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
* Chance and opportunity cards for the players to have. If a player lands on a chance or an opportunity spot they will receive a chance/opportunity card depending on which spot they stepped on. After the player receives the card they must perform the action described on the card or keep it for later use if possible. These cards include a variety of positive and negative consequences for the player such as receiving money, moving to a different location and even being sent right to jail.
* Buying houses and hotels after owing all of one color of the land (buying land too). Once a player lands on a property they are allowed to buy it for the stated price from the bank. Once a player owns all of the cards belonging to a single color group they can start to build houses. Houses make the land more costly and every time you add a house the price goes up more, but houses must be added evenly to all properties in the color group. Once there are three houses on each property the player can buy a hotel (there can only be one hotel on any land).
* Two dice which are rolled by the players with players moving on the board the number of steps the dice show. The players in the game will move according to a pair of dice on the side of the board. Both the dice will be rolled by each player on their turn and show a random number between 1 and 6 giving the player an overall number between 2 and 12 and so the player moves 2-12 steps (depending on the dice) with their game piece.
* Getting into and out of jail based on the places you step in, and on the chance/ opportunity cards that determine whether or not you go to jail. There are three ways for a player to get into jail: 1) The player lands on the space labeled “Go to Jail” 2). The player picks a Chance or Community Chest card that says “Go to Jail” or 3) you roll doubles three times in a row. The player also has three ways to get out of jail: 1) the player gets three turns to roll a double, if the player doesn’t roll a double in the three turns they must pay the fine 2) the player can also use a “Get out of Jail Free” card (that can be found in Chance or Community Chest), 3) pay a fine of $50.
* The player’s amount of money presented on the screen. At any point in the duration of the game the amount of money each person holds will be presented on the screen next to their name. This feature will ensure that players know how much money they have, while also watching out for the wealth of other players.


Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
* Opening page with welcome message including the instructions and rules of the game. We want the players of the game to be able to review the instructions before playing the game by having the ability to read them before the game as there will be an option to click and see them. 
* Background music and clicking sounds while players are playing the game. We all agreed that having background music makes the game more fun, so by adding clicking sounds and background music the players can enjoy the game more. 
* Mortgaging cards instead of paying the price for the location. If a player does not have enough money, they are able to mortgage their other location cards in order to pay for a new location.  
* When stepping on the beginning square, a player will receive $400, while other players who just pass that square, will only receive $200. A player that steps in the welcome square should be greeted by more money as their luck has landed them in the beginning square.  
* If a player buys a whole colored section of the same color, the rent for his houses will increase as all the properties of the same color are owned by them.  


Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
* Allow trades between players for selected amounts of money and cards. During their turn, a player will be able to click the “trade” button, which will open a pop-up. The player will need to fill in the name of the location they want to trade and the selling price. If one of the other players in the game agrees to the terms, they will click the “accept” or “reject” button, and the trade will be completed.
* Playing the game against the computer. In the starting screen, the user will be able to choose if they want their opponents to be people or a computer program. The player will be able to choose the difficulty of the game (easy, medium, hard) which will affect their chances of winning.
* Allowing players who are not in the same household to play the game online. Rather than playing on the same computer, users will be able to create an account and send an invite for a game to others. The game will start after the invite was accepted.


Class List:
[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]


* Screen
   * Represents a screen object
* Screen Switcher -  changes between the three screens in the game.
   *  starting screen with two buttons (Starts the game - “click to start” button and Instructions - “click to see instructions” button)
   * Instruction panel with an exit button (go back to the starting screen - “exit” button)
   * The game itself (connect to the graphics class)
* Rules Page
   * Instruction page
* Opening screen
   *  starting screen
* Drawing Surface
* Player - represents a player in the game
   * Will contain
      * Name of the player
      * Location on the board
      * Balance amount
      * Properties owned by player
      * Any special cards they get (as get out of jail card)
   * Can
      * Move the player
      * Add/take money from the balance amount
* Property
   * Name
   * Price
   * Rent 
   * Who owns it (no one/player 1/player 2)
   * 4 squares for train stations
   * Electric company 
   * Water Works
* Die - will roll the dice and display the number
   * Two dice
   * Random numbers (1-6)
* Ice Breaker cards
   * give different ice breakers such as “Tell a funny joke and earn $100 for it” or "Tell the other player about your favorite new hobby for $30"
* Exercise Cards
   * give different exercise such as "Do ten pushups for $100" or "Do ten jumping jacks for $25"
* Game Screen
   * Board game
   * Square
* Main




Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
* List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
* Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.]


Mika:
* Created the Dice class
* Display properties, houses, and special cards and show which properties each player owns
* rent of properties
* Jail functionality 
* Roll dice, buy property, and buy house buttons


Or:
* Move the players each time the dice is rolled
* Made the Ice breaker cards and Exercise cards 
* Switch screens function
   * Screen, Screen switching, Opening screen, Rules page, and Drawing surface classes


Nitzan
* Display amount of money on the screen
* Game over screen
* buy property and buy house buttons


All together:
* Worked on the Game Board, Player, Property, and Main class


Board game (https://www.amazon.com/Hasbro-Monopoly-Replacement-Board/dp/B017MNUCXC):
  



Used to decide how many classes we are going to have:
https://github.com/yogurt-lover/APCS-final-project
Idea for the graphics:
https://www.youtube.com/watch?v=aVbuVKRdJNY
Pictures of all the properties:
https://monopoly.fandom.com/wiki/List_of_Monopoly_Properties
Die class - used some of the code from the existing project “craps” that we had last year
Screen Switching Demo
