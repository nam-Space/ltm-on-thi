package RMI.B21DCCN553;

import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.registry.*;
import java.util.Arrays;

import RMI.ByteService;

public class RMI_Phan_tu_lon_thu_K {
	public static void main(String[] args) throws IOException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ByteService sv = (ByteService) rg.lookup("RMIByteService");
		byte[]a = sv.requestData("B21DCCN553", "8HIN706I");
		for (byte x : a) System.out.print(x + " ");
		System.out.println();
//		byte k = a[a.length - 1];
//		System.out.println(k);
//		byte[]b = new byte[a.length];
//		for (int i = 0; i < a.length; i++) {
//			b[i] = a[i];
//		}
//		Arrays.sort(b);
//		System.out.println(b[b.length - k]);
//		int idx = 0;
//		for (int i = 0; i < b.length; i++) {
//			if (a[i] == b[b.length - k]) idx = i;
//		}
//		System.out.println(idx);
	}
}
