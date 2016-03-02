package revision.utilityClasses;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortAndSearch {
	public static void main(String...args){
		Integer[] intArrays = {1,2,3,4,5,6,124,8,9,10};
		
		for(Integer i :intArrays){
			System.out.print(i  + " ");
		}
		
		System.out.println("\n");
		
		List<Integer> list = (List<Integer>) Arrays.asList(intArrays);
		for(Integer i : list){
			System.out.print(i + " ");
		}
		
		System.out.println("\n");
		
		Object[] objArray = list.toArray();
		for(Object i : objArray){
			System.out.print(i);
		}
		
		ReverseSortInteger sorter = new ReverseSortInteger();
		
		//Arrays.sort(intArrays, sorter);
		
		for(Integer i :intArrays){
			System.out.print(i  + " ");
		}
		
		//searching array
		System.out.println("found: " +Arrays.binarySearch(intArrays,121));
		
		List<Integer> pureList = new ArrayList<>(list);
		
		pureList.add(1000);
		
		System.out.println("pureList: "  +  pureList);
		
		Integer[] arrayFromList = new Integer[10];
		arrayFromList = pureList.toArray(arrayFromList);
		
		//print arrayFromList elements
		System.out.println("arrayFromList: ");
		for(Integer i : arrayFromList){
			System.out.print(i + " ");
		}
		System.out.println("\n" + arrayFromList.length);
		
		//search pureList
		
		//sort
		Collections.sort(pureList, sorter);
		System.out.println("pureList: "  + pureList);
		System.out.println(Collections.binarySearch(pureList,900,sorter));	
	}
}

class ReverseSortInteger implements Comparator<Integer>{
	public int compare(Integer a , Integer b){
		return b.compareTo(a);	}
}
