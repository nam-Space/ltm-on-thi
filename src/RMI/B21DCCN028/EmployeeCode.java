package RMI.B21DCCN028;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.Employee;
import RMI.ObjectService;

public class EmployeeCode {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
		String studentCode = "B21DCCN028", qCode = "sOLPYw4W";
		Employee employee = (Employee) sv.requestObject(studentCode, qCode);
		System.out.println(employee);
		double baseSalary = employee.getBaseSalary();
		int experienceYears = employee.getExperienceYears();
		String experienceYearsStr = experienceYears + "";
		int tongChuSo = 0;
		for (char x : experienceYearsStr.toCharArray()) {
			tongChuSo += Integer.parseInt(x + "");
		}
		System.out.println(tongChuSo);
		int soUocSo = 0;
		for (int i = 1; i <= experienceYears; i++) {
			if (experienceYears % i == 0) soUocSo++;
		}
		System.out.println(soUocSo);
		double factor = (experienceYears + tongChuSo + soUocSo) / 100.0;
		double finalSalary = baseSalary * (1 + factor);
		System.out.println(finalSalary);
		employee.setFinalSalary(finalSalary);
		
		sv.submitObject(studentCode, qCode, employee);
	}
}
