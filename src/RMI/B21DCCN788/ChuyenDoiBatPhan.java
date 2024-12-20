package RMI.B21DCCN788;

import java.rmi.registry.*;

import RMI.ByteService;

public class ChuyenDoiBatPhan {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ByteService sv = (ByteService) rg.lookup("RMIByteService");
		String studentCode = "B21DCCN788", qCode = "JKd18Lw6";
		byte[] a = sv.requestData(studentCode, qCode);
		for (byte x : a) System.out.print(x + " ");
		System.out.println();
		String res = "";
		for (byte x : a) {
			res += String.format("%03o", x & 0xFF);
		}
		System.out.println(res);
		sv.submitData(studentCode, qCode, res.getBytes());
	}
}
