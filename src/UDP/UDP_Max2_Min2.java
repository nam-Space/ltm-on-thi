package UDP;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;

public class UDP_Max2_Min2 {
	public static void main(String[] args) throws IOException, UnknownHostException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        
        String code = ";B21DCCN214;kvmzsjdJ";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        
        byte [] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        
        String s = new String(dpNhan.getData());
        s = s.replace(",", ";");
        System.out.println(s);
        String []arrStr = s.trim().split("\\;");
        String rqId = arrStr[0];
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 1; i < arrStr.length; i++) {
        	a.add(Integer.parseInt(arrStr[i]));
        }
        Collections.sort(a);
        int max2 = a.get(a.size() - 2);
        int min2 = a.get(1);
        String res = rqId + ";" + max2 + "," + min2;
        System.out.println(res);
        
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        
        socket.close();
    }
}
