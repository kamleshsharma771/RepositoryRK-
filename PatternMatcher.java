package revision.javanio.interfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher("Here is room no.1542");
		System.out.println(Pattern.quote("ace123"));
		while(m.find()){
			System.out.println(m.group() + ": " + m.start() + " " + m.end() );
		}
		for(String a : p.split("12 312 1321 4")){
			System.out.println(a);
		}
		
		System.out.println(p.flags());
		
	
	}
}
