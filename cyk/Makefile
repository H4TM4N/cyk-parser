#Makefile
SOURCE = ./src/CompositeKey.java ./src/CykBox.java ./src/Parser.java ./src/PartOfSpeech.java ./src/Rules.java ./src/PrintS.java
CLASS= CompositeKey.class CykBox.class Parser.class PartOfSpeech.class Rules.class PrintS.class
MAIN = ParseMain
MAINSOURCE = ParseMain.java
RESULT = ./result/child_res.txt ./result/girl_res.txt ./result/time_res.txt
DATA = ./data/
JC = javac
J = java
FLAG = -verbose

all:
	@echo compiling sub files.
	@$(JC) -d ./bin/ $(SOURCE)
	@echo compiling $(MAIN)
	@$(JC) $(MAINSOURCE)
	@echo compile finished

comp:
	$(JC) $(FLAG) $(MAINSOURCE)
	$(JC) $(FLAG) $(SOURCE)

run:
	@cd ./bin/
	@$(J) $(MAIN) ./text/child.txt $(DATA)gram.csv | tee ./result/child_res.txt
	@$(J) $(MAIN) ./text/girl.txt $(DATA)gram_girl.csv | tee ./result/girl_res.txt
	@$(J) $(MAIN) ./text/time.txt $(DATA)gram_time.csv | tee ./result/time_res.txt

show:
	@cat $(RESULT)

clean:
	@$(RM) $(RESULT) 
	@$(RM) $(MAIN).class
	@$(RM) -rf ./bin/src 
