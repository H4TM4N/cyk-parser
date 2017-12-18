package src;
/**
*PrintS exists for only to get S-expression
*
*<p>coded by recursion algorithm
*
*@author Ryo Hatakenaka
*/
public class PrintS{
	protected static String printS(CykBox s, int n){
		if(s.right.isEmpty() && s.left.isEmpty())
			return "(" + s.part.get(n) + "\"" + s.word + "\"" + ")";
		int idxL = s.indexLeft.get(n);
		int idxR = s.indexRight.get(n);
		return "("+s.part.get(n)+printS(s.left.get(n),idxL) + printS(s.right.get(n),idxR)+")"; 
	}
}
