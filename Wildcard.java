package revision.generics;

import java.util.ArrayList;
import java.util.List;

public class Wildcard {

	public static void main(String...args){
		List<? extends Number> upperBoundedList = new ArrayList<Integer>();
		List<? super Number> lowerBoundedList = new ArrayList<Object>();
	
		lowerBoundedList.add(new Integer(10));
		lowerBoundedList.add(new Double(14));
	
		System.out.println(lowerBoundedList.size());
	}
	
	public static <T extends Number> List<T> getList(){
		return null;
	}
}
