package RMI.B21DCCN028;

import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.ByteService;

public class RMI_XOR_Mang_nhi_phan {
	public static void main(String[] args) throws IOException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ByteService sv = (ByteService) rg.lookup("RMIByteService");
		byte[] a = sv.requestData("B21DCCN028", "NSwu8by5");
		for (byte x : a) System.out.print(x + " ");
		String ptit = "PTIT";
		byte[] ptitByte = ptit.getBytes();
		for (int i = 0; i < a.length; i++) {
			a[i] = (byte) ((int)a[i] ^ ((int)ptitByte[i % ptitByte.length]));
		}
		System.out.println();
		for (byte x : a) System.out.print(x + " ");
		sv.submitData("B21DCCN028", "NSwu8by5", a);
	}
}
