package RMI.B21DCCN039;

import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

import RMI.DataService;

public class RMI_So_chinh_phuong {
	public static boolean check(int n) {
		return (int)Math.sqrt(n) * Math.sqrt(n) == n;
	}
	
	public static void main(String[] args) throws IOException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		DataService sv = (DataService) rg.lookup("RMIDataService");
		int n = (int) sv.requestData("B21DCCN039", "Uk8Io5wr");
		System.out.println(n);
		
		List<Integer> a = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			if (check(i)) a.add(i);
		}
		System.out.println(a);
		sv.submitData("B21DCCN039", "Uk8Io5wr", a);
	}
}
