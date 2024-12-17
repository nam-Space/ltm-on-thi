package RMI.B21DCCN214;

import java.rmi.registry.*;
import java.util.Arrays;

import RMI.ByteService;

public class RMI_Phan_tu_lon_thu_k {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ByteService sv = (ByteService) rg.lookup("RMIByteService");
		String studentCode = "B21DCCN214", qCode = "jgbJ2u7l";
		byte[] a = sv.requestData(studentCode, qCode);
		for (byte x : a) System.out.print(x + " ");
		System.out.println();
		byte k = a[a.length - 1];
		System.out.println(k);
		int ptK = (int) k;
		System.out.println(ptK);
		int idx = 0;
		byte[] b = new byte[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		Arrays.sort(b);
		byte maxK = b[a.length - ptK];
		System.out.println(maxK);
		for (int i = 0; i < a.length; i++) {
			if (a[i] == maxK) {
				idx = i + 1;
			}
		}
		System.out.println(idx);
		byte [] res = new byte[2];
		res[0] = maxK;
		res[1] = (byte)idx;
		sv.submitData(studentCode, qCode, res);
	}
}
