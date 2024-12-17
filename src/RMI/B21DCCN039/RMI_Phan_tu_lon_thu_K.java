package RMI.B21DCCN039;

import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.registry.*;
import java.util.Arrays;

import RMI.ByteService;

public class RMI_Phan_tu_lon_thu_K {
	public static void main(String[] args) throws IOException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ByteService sv = (ByteService) rg.lookup("RMIByteService");
		byte[]a = sv.requestData("B21DCCN039", "CPQUBnYK");
		for (byte x : a) System.out.print(x + " ");
		System.out.println();
		byte k = a[a.length - 1];
		System.out.println(k);
		byte[] b = new byte[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		Arrays.sort(b);
		for (byte x : b) System.out.print(x + " ");
		System.out.println();
		byte max_k = b[b.length - k];
		int idx = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == max_k) {
				idx = i;
			}
		}
		byte[] res = new byte[2];
		res[0] = max_k;
		res[1] = (byte) (idx + 1);
		System.out.println(res[0]);
		System.out.println(res[1]);
		sv.submitData("B21DCCN039", "CPQUBnYK", res);
	}
}
