package RMI.B21DCCN622;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.ByteService;

public class ChuyenDoiSangHex {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ByteService sv = (ByteService) rg.lookup("RMIByteService");
		String studentCode = "B21DCCN622", qCode = "PHU7EeSj";
		byte[] a = sv.requestData(studentCode, qCode);
		for (byte x : a) System.out.print(x + " ");
		System.out.println();
		String res = "";
		for (byte x : a) {
			res += String.format("%02x", x & 0xFF);
//			System.out.println(String.format("%02x", x & 0xFF));
		}
		System.out.println(res);
		sv.submitData(studentCode, qCode, res.getBytes());
	}
}
