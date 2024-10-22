package UDP;

import java.io.IOException;
import java.net.*;

public class UDP_Chuan_Hoa_Chuoi {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress sA = InetAddress.getByName("203.162.10.109");
		int sP = 2208;
		
		String code = ";B21DCCN553,DuU2AJAS";
		DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
		socket.send(dpGui);
		
		byte []buffer = new byte[1024];
		DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
		socket.receive(dpNhan);
		String tmp = new String(dpNhan.getData()).trim();
		System.out.println(tmp);
		
		tmp = tmp.replace(";", " ");
		String []tmp1 = tmp.split("\\s+");
		String rqId = tmp1[0];
		String res = "";
		for (int i = 1; i < tmp1.length; i++) {
			res += Character.toUpperCase(tmp1[i].charAt(0)) + tmp1[i].substring(1).toLowerCase() + " ";
		}
		res = res.substring(0, res.length() - 1);
		res = rqId + ";" + res;
		System.out.println(res);
		
		DatagramPacket dpNhan1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
		socket.send(dpNhan1);
		
		socket.close();
    }
}
