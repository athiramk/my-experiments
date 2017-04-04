import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/***
 *  Transient keyword is used when we don't want to serialize a particular variable.
 *  It is used not to save private data on file such as password.
 *  It is used when we can calculate the value from other serialized objects such as age 
 *  or derive from system such as current date etc.
 */

public class TransientDemo implements Serializable {
	
	private String username;
	private transient String password;
	
	public TransientDemo(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public static void main(String[] args) throws Exception {
		TransientDemo td = new TransientDemo("athira","abc123");
		
		FileOutputStream fileout = new FileOutputStream("sample.txt");
		ObjectOutputStream objectout = new ObjectOutputStream(fileout);
		
		objectout.writeObject(td);
		
		objectout.close();
		fileout.close();
		
		System.out.println("Object has been serialized");		

		FileInputStream filein = new FileInputStream("sample.txt");
		ObjectInputStream objectin = new ObjectInputStream(filein);
		
		TransientDemo td2 = null;
		
		td2 = (TransientDemo)objectin.readObject();
		
		objectin.close();
		filein.close();
		
		System.out.println("Object has been deserialized ");
        System.out.println("username = " + td2.username);
        System.out.println("password = " + td2.password);

	}

}
