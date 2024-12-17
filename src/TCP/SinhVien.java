package TCP;

import java.io.*;
import java.net.*;

public class SinhVien {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Socket socket = new Socket("203.162.10.109", 2209);
		ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
		
		String code = "B21DCCN214;iDHqEyTK";
		os.writeObject(code);
		os.flush();
		
		Student student = (Student) is.readObject();
		System.out.println(student);
		
		float gpa = student.getGpa();
		if (gpa >= 3.7) student.setGpaLetter("A");
		else if (gpa >= 3.0) student.setGpaLetter("B");
		else if (gpa >= 2.0) student.setGpaLetter("C");
		else if (gpa >= 1.0) student.setGpaLetter("D");
		else student.setGpaLetter("F");
		
		System.out.println(student);
		os.writeObject(student);
		os.flush();
		
		is.close();
		os.close();
		socket.close();
	}
}
