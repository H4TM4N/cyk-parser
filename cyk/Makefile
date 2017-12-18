#Makefile
SOURCE = ./src/*.java
MAIN = ParseMain
MAINSOURCE = ParseMain.java
RESULT = ./result
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
	@$(J) $(MAIN) ./text/child.txt $(DATA)gram.csv | tee $(RESULT)/child_res.txt
	@$(J) $(MAIN) ./text/girl.txt $(DATA)gram_girl.csv | tee $(RESULT)/girl_res.txt
	@$(J) $(MAIN) ./text/time.txt $(DATA)gram_time.csv | tee $(RESULT)/time_res.txt

show:
	@cat $(RESULT)/*.txt

clean:
	@$(RM) $(RESULT)/*.txt
	@$(RM) $(MAIN).class
	@$(RM) -rf ./bin/src 
