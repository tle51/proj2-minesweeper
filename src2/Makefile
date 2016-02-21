#Minesweeper

#Compiler and compiler flag -Xlint
JFLAGS = -g
JCC = javac

default: Frame.class Button.class Panel.class

Button.class:
	$(JCC) $(JFLAGS) Button.java
	
Panel.class:
	$(JCC) $(JFLAGS) Panel.java	
	
Frame.class:
	$(JCC) $(JFLAGS) Frame.java
	


	
clean:
	$(RM) *.class