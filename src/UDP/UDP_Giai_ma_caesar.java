package UDP;

import java.net.*;

public class UDP_Giai_ma_caesar {
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
		InetAddress sA = InetAddress.getByName("203.162.10.109");
		int sP = 2207;
		
		String code = ";B21DCCN319;2Xr7F9zM";
		DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
		socket.send(dpGui);
		
		byte[] buffer = new byte[1024];
		DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
		socket.receive(dpNhan);
		
		String s = new String(dpNhan.getData());
		System.out.println(s);
		
		String arrStr[] = s.trim().split("\\;");
		String rqId = arrStr[0], data = arrStr[1];
		int dich = Integer.parseInt(arrStr[2]);
		
		String res = rqId + ";";
		for (char x : data.toCharArray()) {
			char base = Character.isUpperCase(x) ? 'A' : 'a';
			char tmp = (char)((x - base + dich) % 26 + base);
			res += tmp;
		}
		System.out.println(res);
		
		DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
		socket.send(dpGui1);
		
		socket.close();
	}
}
