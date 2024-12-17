package UDP;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;

public class UDP_dien_gia_tri_con_thieu {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress sA = InetAddress.getByName("203.162.10.109");
		int sP = 2207;
		
		String code = ";B21DCCN039;Ih0jvyb2";
		DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
		socket.send(dpGui);
		
		byte[]buffer = new byte[1024];
		DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
		socket.receive(dpNhan);
		
		String s = new String(dpNhan.getData());
		System.out.println(s);
		
		String []arrStr = s.trim().split("\\;");
		String rqId = arrStr[0];
		int n = Integer.parseInt(arrStr[1]);
		String [] daySo = arrStr[2].split("\\,");
		
		ArrayList<Integer> a = new ArrayList<>();
		for (String x : daySo) {
			a.add(Integer.parseInt(x));
		}
		Collections.sort(a);
		System.out.println(a);
		ArrayList<Integer> thieu = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (!a.contains(i)) {
				thieu.add(i);
			}
		}
		System.out.println(thieu);
		
		String res = rqId + ";";
		for (Integer x : thieu) {
			res += x + ",";
		}
		res = res.substring(0, res.length() - 1);
		System.out.println(res);
		
		DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
		socket.send(dpGui1);
		
		socket.close();
	}
}
