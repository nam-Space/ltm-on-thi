package UDP;

import java.io.*;
import java.net.*;
import java.util.*;

public class UDP_lon_nho {
	public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        
        String code = ";B21DCCN509;bXvQxB9q";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        System.out.println(s);
        
        String[]arrStr = s.trim().split("\\;");
        String rqId = arrStr[0];
        String []daySo = arrStr[1].split("\\,");
        ArrayList<Integer> a = new ArrayList<>();
        for (String x : daySo) {
        	a.add(Integer.parseInt(x));
        }
        Collections.sort(a);
        int nho = a.get(0);
        int lon = a.get(a.size() - 1);
        String res = rqId + ";" + lon + "," + nho;
        System.out.println(res);
        
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        
        socket.close();
    }
}