#Minesweeper

#Compiler and compiler flag -Xlint
JFLAGS = -g
JCC = javac

default: MyJButton.class GameBoard.class Game.class

MyJButton.class:
	$(JCC) $(JFLAGS) MyJButton.java
	
GameBoard.class:
	$(JCC) $(JFLAGS) GameBoard.java	
	
Game.class:
	$(JCC) $(JFLAGS) Game.java
	


	
clean:
	$(RM) *.class
	$(RM) *.txt