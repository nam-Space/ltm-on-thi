package RMI.B21DCCN553;

import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

import RMI.DataService;

public class RMI_Ba_so_py_ta_go {
	public static void main(String[] args) throws IOException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		DataService sv = (DataService) rg.lookup("RMIDataService");
		int n = (int) sv.requestData("B21DCCN553", "tPmKSzNx");
		System.out.println(n);
		
		List<List<Integer>> a = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				for (int z = j + 1; z <= n; z++) {
					if (i * i + j * j == z * z) {
						List<Integer> b = new ArrayList<>();
						b.add(i);
						b.add(j);
						b.add(z);
						a.add(b);
					}
				}
			}
		}
		System.out.println(a);
		sv.submitData("B21DCCN553", "tPmKSzNx", a);
	}
}
