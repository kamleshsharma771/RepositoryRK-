package revision.assertions;

interface intf {
	void info();
}

class Exception1 extends RuntimeException implements intf{

	@Override
	public void info() {
		System.out.println("exception1");	
	}	
}

class Exception2 extends RuntimeException implements intf{

	@Override
	public void info() {
		System.out.println("Exception2");
	}
	
}

public class TestAssertion {
	public static void main(String...args){
		try{
			throw new Exception1();
			
		}catch(Exception1 | Exception2 e){
			e.info();
		}
	}
}