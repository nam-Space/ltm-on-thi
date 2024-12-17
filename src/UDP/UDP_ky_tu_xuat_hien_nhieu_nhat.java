package UDP;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UDP_ky_tu_xuat_hien_nhieu_nhat {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress sA = InetAddress.getByName("203.162.10.109");
		int sP = 2208;
		
		String code = ";B21DCCN553;JD4x4aTU";
		DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
		socket.send(dpGui);
		
		byte [] buffer = new byte[1024];
		DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
		socket.receive(dpNhan);
		
		String s = new String(dpNhan.getData());
		System.out.println(s);
		
		String []arrStr = s.trim().split("\\;");
		String qCode = arrStr[0];
		String data = arrStr[1];
		int []cnt = new int[301];
		for (char x : data.toCharArray()) {
			cnt[x]++;
		}
		int max_cnt = 0;
		char ky_tu_max = 0;
		for (int i = 0; i < 301; i++) {
			if (max_cnt < cnt[i]) {
				max_cnt = cnt[i];
				ky_tu_max = (char)i;
			}
		}
		System.out.println(max_cnt);
		System.out.println(ky_tu_max);
		String res = qCode + ";" + ky_tu_max + ":";
		for (int i = 0; i < data.length(); i++) {
			if (ky_tu_max == data.charAt(i)) {
				res += (i + 1) + ",";
			}
		}
//		res = res.substring(0, res.length() - 1);
		System.out.println(res);
		
		DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
		socket.send(dpGui1);
		
		socket.close();
	}
}
