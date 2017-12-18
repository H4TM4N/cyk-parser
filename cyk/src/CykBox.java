package src;
import java.util.*;
/**
*CykBox is struct(class) for cyk-parse array.
*
*<p>This class have 5 Vector and 1 String
*<p>| part : this Vector contains Terminal and Nonterminal
*<p>| right : right side source to derivation of part
*<p>| left : left side source to derivation of part
*<p>| indexLeft : left source part number
*<p>| indexRight : right source part number
*
*@author Ryo Hatakenaka
*/
public class CykBox{
    public Vector<String> part;
    public Vector<CykBox> right;
    public Vector<CykBox> left;
    public Vector<Integer> indexLeft;
    public Vector<Integer> indexRight;
    public String word;    
    
	/**
	*CykBox() : basic constructor;
	*
	*<p>Set 5 Vectors and set word null
	*/
	public CykBox(){
        this.part = new Vector<>();
        this.right = new Vector<>();
        this.left = new Vector<>();
        this.indexRight = new Vector<>();
        this.indexLeft = new Vector<>();
        this.word = null;
    }
	
	/**
	*CykBox(Vector<String> part, String word) : set part and word
	*
	*<p>This constructor is only used for cyk-parse array[i][i]
	*/
    public CykBox(Vector<String> part,String word){
        this();
        this.part = part;
        this.word = word;
    }
    
}
