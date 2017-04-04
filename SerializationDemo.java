/**
 * This is a sample program which shows serialization and de-serialization
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo implements Serializable {
	int length;
	int breadth;
	
	public SerializationDemo(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	public static void main(String[] args) throws Exception {
		SerializationDemo sd = new SerializationDemo(10,12);
		
		FileOutputStream fileout = new FileOutputStream("sample.txt");
		ObjectOutputStream objectout = new ObjectOutputStream(fileout);
		
		objectout.writeObject(sd);
		
		objectout.close();
		fileout.close();
		
		System.out.println("Object has been serialized");


		FileInputStream filein = new FileInputStream("sample.txt");
		ObjectInputStream objectin = new ObjectInputStream(filein);
		
		SerializationDemo sd2 = null;
		
		sd2 = (SerializationDemo)objectin.readObject();
		
		objectin.close();
		filein.close();
		
		System.out.println("Object has been deserialized ");
        	System.out.println("length = " + sd2.length);
        	System.out.println("breadth = " + sd2.breadth);
		
	}

}
