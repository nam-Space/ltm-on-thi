package RMI.B21DCCN016;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import RMI.DataService;

public class RMI_PhuongSaiDoLechChuan {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		DataService sv = (DataService) rg.lookup("RMIDataService");
		String studentCode = "B21DCCN016", qCode = "e7L2h8xi";
		String s = (String) sv.requestData(studentCode, qCode);
		s = s.replace(",", "");
		System.out.println(s);
		String []arrStr = s.trim().split("\\s+");
		double ps = 0;
		double sum = 0;
		double tbc = 0;
		for (String x : arrStr) {
			sum += Double.parseDouble(x);
		}
		System.out.println(sum);
		tbc = sum / arrStr.length;
		System.out.println(tbc);
		for (String x : arrStr) {
			ps += (Double.parseDouble(x) - tbc) * (Float.parseFloat(x) - tbc);
		}
		ps /= arrStr.length;
		System.out.println(ps);
		double doLechChuan = Math.sqrt(ps);
		System.out.println(doLechChuan);
		String res = String.format("%.2f", ps) + " : " + String.format("%.2f", doLechChuan);
		System.out.println(res);
		sv.submitData(studentCode, qCode, res);
	}
}
