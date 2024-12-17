package UDP;

import java.io.*;
import java.net.*;

public class UDP_so_nguyen_to {
	public static int prime[] = new int[1000001];
	
	public static void init() {
		for (int i = 2; i < 1000001; i++) prime[i] = 1;
		prime[0] = prime[1] = 0;
		for (int i = 2; i <= 1000; i++) {
			for (int j = i * i; j <= 1000000; j += i) {
				prime[j] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		DatagramSocket socket = new DatagramSocket();
		InetAddress sA = InetAddress.getByName("203.162.10.109");
		int sP = 2207;
		
		String code = ";B21DCCN553;AxuUJTUV";
		DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
		socket.send(dpGui);
		
		byte []buffer = new byte[1024];
		DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
		socket.receive(dpNhan);
		
		String s = new String(dpNhan.getData());
		System.out.println(s);
		
		String []arrStr = s.trim().split("\\;");
		String rqId = arrStr[0];
		int n = Integer.parseInt(arrStr[1]);
		String res = rqId + ";";
		int cnt = 0;
		for (int i = 2; i <= 1000000; i++) {
			if (cnt == n) break;
			else if (prime[i] == 1) {
				res += i + ",";
				cnt++;
			}
		}
		res = res.substring(0, res.length() - 1);
		System.out.println(res);
		
		DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
		socket.send(dpGui1);
		
		socket.close();
	} 
}
