package RMI.B21DCCN788;

import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.List;

import RMI.DataService;

public class LietKeSoChinhPhuong {
	public static boolean check(int n) {
		return (int)Math.sqrt(n) * (int)Math.sqrt(n) == n;
	}
	
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		DataService sv  = (DataService) rg.lookup("RMIDataService");
		String studentCode = "B21DCCN788", qCode = "Ug4aUVQ1";
		int n = (int) sv.requestData(studentCode, qCode);
		System.out.println(n);
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			if (check(i)) res.add(i);
		}
		System.out.println(res);
		sv.submitData(studentCode, qCode, res);
	}
}
