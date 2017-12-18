package src;
/**
*CompositeKey is used for HashMap with Multiple-key
*
*<p>This class used for make rule to parse
*
*/
public class CompositeKey{
    private final String left;
    private final String right;

    public CompositeKey(String left, String right){
        this.left = left;
        this.right = right;
    }
	//one keys for one value
    public CompositeKey(String left){
        this.left = left;
        this.right = null;
    }
	/**
	*To set unique hash.
	*
	*<p>this method Override java.lang.Object.hashCode();
	*<p>This method is called by HashMap.put(Key k,Value v);
	*
    */
	@Override
    public int hashCode(){
        final int prime = 10;
        int result = 1;
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result + ((right== null) ? 0 : right.hashCode());
        return result;
    }
	/**
	*Judge whether this and obj are equivalent.
	*
	*<p>this method Override java.lang.Object.equals(Object obj).
	*This method is called by HashMap.containsKey(Key k) and HashMap.get(Key k)
	*
	*/
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        CompositeKey other = (CompositeKey) obj;
        if(left == null){
            if(other.left != null)
                return false;
        }else if(!left.equals(other.left))
            return false;
        if(right == null){
            if(other.right != null)
                return false;
        }else if(!right.equals(other.right))
            return false;
        return true;
    }
}
