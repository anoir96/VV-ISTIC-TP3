package fr.istic.vv;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
    	if(str == null) return true;
    	List<Character> l = new ArrayList<Character>();
    	while(str.length() != 0) {
    		char c = str.charAt(0);
    		if(c == ')') {
    			if(l.isEmpty() || !l.remove(l.size()-1).equals('(')) return false;
    		}else if(c == '}'){
    			if(l.isEmpty() || !l.remove(l.size()-1).equals('{')) return false;
    		}else if(c == ']'){
    			if(l.isEmpty() || !l.remove(l.size()-1).equals('[')) return false;
    		}else {
    			l.add(str.charAt(0));
    		}
    		str = str.substring(1);
    	}
    	return l.isEmpty();
    }

}
