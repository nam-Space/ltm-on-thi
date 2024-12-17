package RMI.B21DCCN036;

import java.rmi.registry.*;

import RMI.ByteService;

public class RMI_Phan_tu_so_lan_xuat_hien_it_nhat {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ByteService sv = (ByteService) rg.lookup("RMIByteService");
		String studentCode = "B21DCCN036", qCode = "JViHiYDE";
		byte[]a = sv.requestData(studentCode, qCode);
		for (byte x : a) System.out.print(x + " ");
		System.out.println();
		int []cnt = new int[1000001];
		for (byte x : a) {
			cnt[(int)x]++;
		}
		int ptu = -1, cntMin = 2000000000;
		for (int i = 0; i < a.length; i++) {
			if (cnt[(int)a[i]] < cntMin) {
				cntMin = cnt[(int)a[i]];
				ptu = (int)a[i];
			}
		}
		System.out.println(ptu);
		System.out.println(cntMin);
		byte[] res = new byte[2];
		res[0] = (byte)ptu;
		res[1] = (byte)cntMin;
		sv.submitData(studentCode, qCode, res);
	}
}
