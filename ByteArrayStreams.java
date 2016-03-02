package revision.javaio.streams;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/*
 * Demonstrate the ByteArrayInputStream and ByteOutputStream classes
 */

public class ByteArrayStreams {
	public static void main(String...args) throws IOException{
		byte[] b = new byte[]{12,13,14,15,16,17,18,19,20};
		byte[] c = new byte[]{1,2,3,4,5,6,7,8,9,10};
		ByteArrayInputStream bis =  new ByteArrayInputStream(b);
		
		System.out.println(bis.markSupported());
		int i = 0 ;
		while((i = bis.read(c,3,6)) != -1){
			System.out.print(i + " ");
		}
		
		System.out.println("\n");
		for(byte i1 : c){
			System.out.print(i1 + " ");
		}
	}
}