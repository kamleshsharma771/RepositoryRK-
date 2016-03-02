package revision.generics;

import java.util.ArrayList;
import java.util.List;

public class RawGenericsInterop {
	public static void main(String...args){
		Vehicle<String, Integer> v = new Vehicle<>();
		List<Integer> list = new ArrayList<>();
		v.takeWildcardList(list);
	}
}

//generic class
class Vehicle<E,F>{
	private E handle;
	private F wheels;
	//method that accept List<? extends String> 
	
	public void takeWildcardList(List<? super Integer> list){
		list.add(0,124);
	}
}