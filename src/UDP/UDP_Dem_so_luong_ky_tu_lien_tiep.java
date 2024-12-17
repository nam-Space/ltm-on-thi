package UDP;

import java.io.*;
import java.net.*;

public class UDP_Dem_so_luong_ky_tu_lien_tiep {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress sA = InetAddress.getByName("203.162.10.109");
		int sP = 2208;
		
		String code = ";B21DCCN214;xSR2byzl";
		DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
		socket.send(dpGui);
		
		byte[] buffer = new byte[1024];
		DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
		socket.receive(dpNhan);
		
		String s = new String(dpNhan.getData());
		System.out.println(s);
		
		String []arrStr = s.trim().split("\\;");
		String rqId = arrStr[0];
		String data = arrStr[1];
		
		int cnt[] = new int[301];
		for (char x : data.toCharArray()) {
			cnt[x]++;
		}
		
		String res = rqId + ";";
		for (char x : data.toCharArray()) {
			if (cnt[x] >= 1) {
				res += cnt[x] + "" + x;
				cnt[x] = 0;
			}
		}
		System.out.println(res);
		
		DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
		socket.send(dpGui1);
		
		socket.close();
	}
}
