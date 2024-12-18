package RMI.B21DCCN021;

import java.rmi.registry.*;
import java.util.ArrayList;

import RMI.ByteService;

public class RMI_NenRLE {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ByteService sv = (ByteService) rg.lookup("RMIByteService");
		String studentCode = "B21DCCN021", qCode = "mxlGHDdO";
		byte []a = sv.requestData(studentCode, qCode);
		for (byte x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
		ArrayList<Byte> lst = new ArrayList<>();
		int cnt = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[i - 1] == a[i]) cnt++;
			else {
				lst.add(a[i - 1]);
				lst.add((byte)cnt);
				cnt = 1;
			}
		}
		lst.add(a[a.length - 1]);
		lst.add((byte)cnt);
		byte []res = new byte[lst.size()];
		for (int i = 0; i < lst.size(); i++) {
			res[i] = lst.get(i);
			System.out.print(res[i] + " ");
		}
		System.out.println();
		sv.submitData(studentCode, qCode, res);
	}
}
