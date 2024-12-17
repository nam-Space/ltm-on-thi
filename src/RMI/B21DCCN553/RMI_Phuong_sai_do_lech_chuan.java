package RMI.B21DCCN553;

import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.registry.*;
import java.util.ArrayList;

import RMI.DataService;

public class RMI_Phuong_sai_do_lech_chuan {
	public static void main(String[] args) throws IOException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		DataService sv = (DataService) rg.lookup("RMIDataService");
		String s = (String) sv.requestData("B21DCCN553", "UdhAuGdi");
		System.out.println(s);
		
		s = s.replace(",", " ");
		String []arrStr = s.split("\\s+");
		
		ArrayList<Double> a = new ArrayList<>();
		for (String x : arrStr) {
			a.add(Double.parseDouble(x));
		}
		System.out.println(a);
		double tbc = 0;
		int cnt = 0;
		for (Double x : a) {
			tbc += x;
			cnt++;
		}
		tbc = tbc / cnt;
		double ps = 0;
		for (Double x : a) {
			ps += (x - tbc) * (x - tbc);
		}
		ps = ps / cnt;
		System.out.println(ps);
		double doLechChuan = Math.sqrt(ps);
		System.out.println(doLechChuan);
		String res = String.format("%.2f : %.2f", ps, doLechChuan);
		System.out.println(res);
		sv.submitData("B21DCCN553", "UdhAuGdi", res);
	}
}
