package RMI.B21DCCN053;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import RMI.DataService;

public class RMI_To_hop_ke_tiep {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		DataService sv = (DataService) rg.lookup("RMIDataService");
		String studentCode = "B21DCCN053", qCode = "rgJiYI3t";
		String s = (String) sv.requestData(studentCode, qCode);
		s = s.replace(" ", "");
		System.out.println(s);
		String []arrStr = s.split("\\,");
		int a[] = new int[arrStr.length + 1];
		for (int i = 0; i < arrStr.length; i++) {
			a[i + 1] = Integer.parseInt(arrStr[i]);
		}
		int n = arrStr.length;
		int i = n - 1;
		while(i >= 1 && a[i] >= a[i + 1]) {
			i--;
		}
		if (i == 0) {
			Arrays.sort(a);
		}
		else {
			int j = n;
			while(a[i] >= a[j]) {
				j--;
			}
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
			int l = i + 1, r = n;
			while(l < r) {
				int tmp1 = a[l];
				a[l] = a[r];
				a[r] = tmp1;
				l++;
				r--;
			}
		}
		String res = "";
		for (int u = 1; u <= n; u++) {
			res += a[u] + ",";
		}
		res = res.substring(0, res.length() - 1);
		System.out.println(res);
		sv.submitData(studentCode, qCode, res);
	}
}
