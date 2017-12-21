CYK-Parser
====
Parser by CYK-algorithm.

`https://en.wikipedia.org/wiki/CYK_algorithm`

## Description

this parser judge whether a given English sentence complies with a given Rule or not.

## Usage
to test : go cyk/ and use `make all` & `make run`  
to parse your original text:  

1st: Put your text-file in cyk/text/(***).txt

2nd: Write the relation of word and part into cyk/data/dics.csv ,separate word and part-of-speech with `,`
```
a-DET     : a,DET
pen-NOUN  : pen,NOUN
```
3rd: Put rule-to-parse data file in cyk/data/ following with format csv  
```
S->NP+VP      : S,NP,VP
S->NP         : S,NP,
NP->DET+NOUN  : NP,DET,NOUN 
```
Finally: Run
```
java ParseMain ./text/your-textfile-name ./data/your-rulefile.csv 
```
