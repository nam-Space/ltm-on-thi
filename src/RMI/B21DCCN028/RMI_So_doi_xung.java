package RMI.B21DCCN028;

import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import RMI.DataService;

public class RMI_So_doi_xung {
	public static boolean check(int n) {
		String s = n + "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		DataService sv = (DataService) rg.lookup("RMIDataService");
		String studentCode = "B21DCCN028", qCode = "Ugriit8n";
		String s = (String) sv.requestData(studentCode, qCode);
		s = s.replace(" ", "");
		String []arrStr = s.split("\\;");
		int n = Integer.parseInt(arrStr[0]);
		int k = Integer.parseInt(arrStr[1]);
		System.out.println(n);
		System.out.println(k);
		List<Integer> res = new ArrayList<>();
		for (int i = n; i < k; i++) {
			if (check(i)) res.add(i);
		}
		System.out.println(res);
		sv.submitData(studentCode, qCode, res);
	}
}
