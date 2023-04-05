public class StringMethod {
// Returns the string created by adding 's2' after position 'index' of 's1'.
static String addString(String s1, int index, String s2) {
	String sf = s1.substring(0,index+1);
	String se = s1.substring(index+1);
	String s = sf.concat(s2);
	s=s.concat(se);
	return s;
}

// Returns reversed string of 's'
static String reverse(String s) {
	String s1="";
	for(int i=s.length();i>0;i--)
	{
		String s2 = Character.toString(s.charAt(i-1));
		s1= s1.concat(s2);
	}
	return s1;
}

// Returns a string with all 's2's removed from 's1'
static String removeString (String s1, String s2) {
	String[] rmv = s1.split(s2);
	String s="";
	for (int i=0;i<rmv.length;i++)
		s=s.concat(rmv[i]);
	return s;
}

public static void main(String[] args) {
	System.out.println(addString("0123456",3,"-"));
	System.out.println(reverse("abc"));
	System.out.println(removeString("01001000","00"));
	
}
}

