package revision.javanio.interfaces;

import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;

public class FileVisitorTest {
	public static void main(String...args){
		Path p = Paths.get("D:\\IDEA workspace");
		DirReplicator dirReplicator = new DirReplicator(Paths.get("D:\\TempWorkspace"),p);
		try {
			Files.walkFileTree(p,dirReplicator);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
 * for successful copy intermediate directories must be created before file can be copied to it.
 */
class DirReplicator extends SimpleFileVisitor<Path>{
	private Path destination ; 
	private Path source ;
	private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
	private int count; 
	
	public DirReplicator(Path target,Path source) {
		destination = target;
		this.source = source;
	}
	
	public FileVisitResult visitFile(Path dir, BasicFileAttributes attrib) throws IOException{
		
		if(matcher.matches(dir.getFileName())){
			count++;
			System.out.println(count + ": file - " + dir);
		}
		
		/*System.out.println(dir);
		String resolvedPath =  destination.resolve(destination.resolve(source).relativize(dir)).toString();
		System.out.println("final path : " + resolvedPath);*/
		Files.copy(dir,destination.resolve(destination.resolve(source).relativize(dir)),StandardCopyOption.REPLACE_EXISTING);
		return FileVisitResult.CONTINUE; 
	}
	
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes exec) throws IOException{
		/*String resolvedPath = destination.resolve(destination.resolve(source).relativize(dir)).toString();
		System.out.println(source);
		System.out.println(destination);
		System.out.println(dir);
		System.out.println("final Dir "  + resolvedPath);*/
		Files.createDirectories(destination.resolve(destination.resolve(source).relativize(dir)));
		return FileVisitResult.CONTINUE;
	}	
}
