package RMI.B21DCCN564;

import java.rmi.registry.*;

import RMI.ObjectService;
import RMI.Student;

public class StudentCode {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
		String studentCode = "B21DCCN564", qCode = "lhfGn7Ic";
		Student student = (Student) sv.requestObject(studentCode, qCode);
		System.out.println(student);
		
		String newCode = "B";
		String enrollmentYear = (student.getEnrollmentYear()+"").substring(2);
		newCode += enrollmentYear;
		String name = student.getName();
		String []arrName = name.split("\\s+");
		newCode += arrName[arrName.length - 1].toUpperCase() + "_";
		for (int i = 0; i < arrName.length - 1; i++) {
			newCode += arrName[i].substring(0, 1).toUpperCase();
		}
		System.out.println(newCode);
		student.setCode(newCode);
		String newName = "";
		for (int i = 0; i < arrName.length; i++) {
			newName += arrName[i].substring(0, 1).toUpperCase() + arrName[i].substring(1).toLowerCase() + " ";
		}
		newName = newName.trim();
		System.out.println(newName);
		student.setName(newName);
		sv.submitObject(studentCode, qCode, student);
	}
}
