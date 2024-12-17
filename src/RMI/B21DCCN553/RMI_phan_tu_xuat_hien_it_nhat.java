package RMI.B21DCCN553;

import java.rmi.*;
import java.rmi.registry.*;

import RMI.ByteService;

public class RMI_phan_tu_xuat_hien_it_nhat {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ByteService sv = (ByteService) rg.lookup("RMIByteService");
		byte[]a = sv.requestData("B21DCCN553", "vhCyYF2M");
		for (byte x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
		int[] cnt = new int[2048];

		for (byte x : a) {
			cnt[x]++;
		}
		byte pt = a[0];
		int dem = 2000000000;
		for (byte x : a) {
			if (cnt[x] >= 1) {
				if (cnt[x] < dem) {
					dem = cnt[x];
					pt = x;
				}
			}
		}
		byte [] res = new byte[2];
		res[0] = pt;
		res[1] = (byte)dem;
		System.out.println(pt);
		System.out.println(dem);
		
		sv.submitData("B21DCCN553", "vhCyYF2M", res);
	} 
}
