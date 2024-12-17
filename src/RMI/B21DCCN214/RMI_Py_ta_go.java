package RMI.B21DCCN214;

import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.List;

import RMI.DataService;

public class RMI_Py_ta_go {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		DataService sv = (DataService) rg.lookup("RMIDataService");
		
		String studentCode = "B21DCCN214", qCode = "k1hvlIyn";
		int n = (int) sv.requestData(studentCode, qCode);
		System.out.println(n);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i <= n - 2; i++) {
			for (int j = i + 1; j <= n - 1; j++) {
				for (int z = j + 1; z <= n; z++) {
					if (i * i + j * j == z * z) {
						List<Integer> a = new ArrayList<>();
						a.add(i);
						a.add(j);
						a.add(z);
						System.out.println(a);
						res.add(a);
					}
				}
			}
		}
		sv.submitData(studentCode, qCode, res);
	}
}
