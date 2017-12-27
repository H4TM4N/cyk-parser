package src;
import java.util.*;
/**
*Parser is class for cyk-parsing and show result.
*
*@author Ryo Hatakenaka
*/
public class Parser{
    public static void cykParse(String[] word){
		//make Array of structure(CykBox) [size]:length*length
        CykBox[][] cyk = new CykBox[word.length][word.length];
        //Initialize the part to use for cyk parsing
		for(int i=0; i<word.length;i++)
            for(int j = i+1;j<word.length;j++)
                cyk[i][j] = new CykBox();
        for(int i=0; i<word.length; i++){
            //Make a variable length array ,Vector(which is in java.util.Vector);
			Vector<String> part = PartOfSpeech.getPart(word[i]);
            //word was not found in ./data/dics.csv
			if(part.size() == 0){
                System.out.println("\u001b[00;41m[Error\t]\u001b[00m Not Found: "+"\""+word[i]+"\" in dics.csv");
                return ;
            }
            String s;
            int size = part.size();
			//if the one-to-one change is exist,set in cyk list(e.g. NP->NOUN: getNP)
            for(int j=0; j<size; j++)
                if((s = Rules.getRule(part.get(j))) != null)
                    part.add(s);
            //set the part in cyk
            cyk[i][i] = new CykBox(part,word[i]);

        }
		//------Parsing from hear-----------
		//cnt is line to realize oblique transition
        for(int cnt = 1; cnt<word.length; cnt++){
			//i is start index to parse
            for(int i = 0; i<word.length-cnt; i++){
                //j is end index to parse
				int j = cnt + i;
				//m is midterm index 
				//means [i][j] -> [i][m] + [m+1][j]
                for(int m = i; m<j; m++){
                    if(cyk[i][m].part.isEmpty() || cyk[m+1][j].part.isEmpty())
                        continue;
                    //search all combination
					int leftSize = cyk[i][m].part.size();
                    int rightSize = cyk[m+1][j].part.size();
                    for(int a=0;a<leftSize; a++){
                        for(int b=0;b<rightSize;b++){
                            String s = Rules.getRule(cyk[i][m].part.get(a),cyk[m+1][j].part.get(b));
                            if(s == null)
                                continue;
                            cyk[i][j].part.add(s);
                            cyk[i][j].left.add(cyk[i][m]);
                            cyk[i][j].right.add(cyk[m+1][j]);
                            cyk[i][j].indexLeft.add((Integer)a);
                            cyk[i][j].indexRight.add((Integer)b);
                        }
                    }
                }
				//for debug (show cyk list)
                /*System.out.println("i:"+i+", j:"+j);
                int tmp = cyk[i][j].part.size();
                String pS="",lS="",rS="",ilS="",irS="";
                for(int hoge = 0; hoge < tmp;hoge++){
         	  		pS += cyk[i][j].part.get(hoge)+",";
                 	lS += cyk[i][j].left.get(hoge).part.get(cyk[i][j].indexLeft.get(hoge))+",";
                 	rS += cyk[i][j].right.get(hoge).part.get(cyk[i][j].indexRight.get(hoge))+",";
                 	ilS += cyk[i][j].indexLeft.get(hoge)+",";
                 	irS += cyk[i][j].indexRight.get(hoge)+",";
                }
                System.out.println("part:"+pS);
                System.out.println("left:"+lS);
				System.out.println("right:"+rS);
				System.out.println("idxL:"+ilS);
				System.out.println("idxR:"+irS);
				System.out.println("");
                //System.out.println("cnt:"+cnt+", i:"+i+", m:"+m+", j:"+j);
                */
            }
        }
        int len = word.length-1;
        CykBox tmp = cyk[0][len];
        
		int num = 0;
        for(int i=0; i<tmp.part.size(); i++){
            if(tmp.part.get(i).equals("S")){
                System.out.println(PrintS.printS(tmp,i));
				num++;
			}
			//if(tmp.part.get(i).equals("VP") || tmp.part.get(i).equals("NP")){
			if(tmp.part.get(i).equals("VP")){
				System.out.println("(S"+PrintS.printS(tmp,i)+")");
				num++;
			}
			
        }
        if(num == 0){
            System.out.println("\u001b[00;41m[Error\t]\u001b[00m Parsing Error: Sentence not accepted");
			System.out.println("\n-----------------------------");
            return ;
        }

		System.out.println("");
		if(num > 0){
			System.out.println("[Info\t] Parsing success: Sentence accepted");
		    System.out.println("[Info\t] "+num+" parse tree was found");
        }
		System.out.println("");
		System.out.println("--------------------------------");
    }
}

