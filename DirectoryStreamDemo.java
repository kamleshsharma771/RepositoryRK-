package revision.javanio.interfaces;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirectoryStreamDemo {
	public static void main(String...args){
		Path p = Paths.get("c:\\Program Files\\");
				
		List<Path> sourceFiles = new ArrayList<>();
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(p)){
			
			for(Path p2 : stream){
				System.out.println(p2);
				
				DirectoryStream<Path> innerStream = Files.newDirectoryStream(p2);
				for(Path p3 : innerStream){
					System.out.println(p3);
				}
			}
			System.out.println("\n\n\n\n");
			/*Iterator<Path> streamIterator = stream.iterator();
			while(streamIterator.hasNext()) {
				System.out.println(streamIterator.next());
			}*/
		} catch (DirectoryIteratorException e) {
			System.out.println(e.getCause().getMessage());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
