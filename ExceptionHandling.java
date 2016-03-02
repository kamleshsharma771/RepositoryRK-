package revision.exceptions;
//delete this
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class ExceptionHandling {
	public static void main(String...args) throws IOException, SQLException {
		try(FileInputStream fis = new FileInputStream("file1.txt");
			BufferedInputStream io = new BufferedInputStream(fis)){
			testTryFinally();
		}catch(Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}
	
	public static int testTryFinally() throws IOException{
		try{
			throw new ArrayIndexOutOfBoundsException();
			
		}catch(ArrayIndexOutOfBoundsException e){
			throw new RuntimeException();
		}finally{
			System.out.println("finally called");
		}
	}
}
