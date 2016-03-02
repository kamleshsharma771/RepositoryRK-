package revision.javaio.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class SerializationDemo {
	public static void main(String...args){
		FileInputStream fis;
		ObjectInputStream ois;
		OutputStream os;
		ObjectOutputStream oos;
		Phone phone = new Phone();
		OS androidKitKat = new OS("microkernel","Andriod","4.4");
		
		phone.setBrand("SAMSUNG");
		phone.setPhoneNumber(9000000000L);
		phone.setOperatingSystem(androidKitKat);				
		try {
			os = new FileOutputStream(new File("D:\\Phone.dat"));
			oos = new ObjectOutputStream(os);
			oos.writeObject(phone);
		
			fis = new FileInputStream(new File("D:\\Phone.dat"));
			ois = new ObjectInputStream(fis);
		
			Phone p1 = (Phone)ois.readObject();
		
			System.out.println(p1 + " " + p1.getOperatingSystem() );
			
			Car c = new Car("Ford Endeavour");
			os = new FileOutputStream(new File("D:\\Car.dat"));
			oos = new ObjectOutputStream(os);
			oos.writeObject(c);
		
			fis = new FileInputStream(new File("D:\\Car.dat"));
			ois = new ObjectInputStream(fis);
			c.name ="Toyota";
			Car c1 = (Car)ois.readObject();
			
			System.out.println(c);
			System.out.println(c1);
			//Phone deSerializedPhone = (Phone)ois.readObject();
		
			//System.out.println(deSerializedPhone);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}/* catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/ catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

enum type{
	MOBILE("SMARTPHONE"){
		String getType(){
			return type;
		}
	}, TELEPHONE("WIRELESS PHONE"){
		String getType(){
			return type;
		}
	};
	private type(String type){
		this.type = type;
	}
	String type; 
	abstract String getType();
}

class Phone implements Serializable{
	private Long phoneNumber;
	private String brand; 
	transient private OS operatingSystem;
	
	private void readObject(ObjectInputStream is){
		try {
			System.out.println("private readObject()");
			is.defaultReadObject();
			String name = is.readUTF();
			String version = is.readUTF();
			String kernelType = is.readUTF();
			this.operatingSystem = new OS(kernelType, name,version);
			System.out.println("private readObject() complete");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void writeObject(ObjectOutputStream oos){
		try {
			System.out.println("private writeObject()");
			oos.defaultWriteObject();
			 oos.writeUTF(this.operatingSystem.getName());
			 oos.writeUTF(operatingSystem.getVersion());
			 oos.writeUTF(operatingSystem.getKernelType());
			 oos.flush();
			 System.out.println("private writeObject() complete");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public OS getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(OS operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	@Override
	public String toString() {
		return "Phone [phoneNumber=" + phoneNumber + ", brand=" + brand + ", operatingSystem=" + operatingSystem + "]";
	}	
}

class OS implements Serializable{
	private String kernelType;
	private String name;
	private String version;

	public OS(String kernelType, String name, String version) {
		super();
		this.kernelType = kernelType;
		this.name = name;
		this.version = version;
	}

	@Override
	public String toString() {
		return "OS [kernelType=" + kernelType + ", name=" + name + ", version=" + version + "]";
	}

	public String getKernelType() {
		return kernelType;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public void setKernelType(String kernelType) {
		this.kernelType = kernelType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVersion(String version) {
		this.version = version;
	}	
}

class Car implements Serializable{
	static String name ;

	Car(String carname ){
		this.name = carname;
	}
	
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Car.name = name;
	}
	
	public String toString(){
		return "Car [" + name + "]";
	}
}