package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class TCP_tong_cac_so {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("203.162.10.109", 2206);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        
        String code = "B21DCCN139;NNyxUbRi";
        os.write(code.getBytes());
        os.flush();
        
        byte[] buffer = new byte[1024];
        int bytesRead = is.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        
        String[]a = s.split("\\|");
        int sum = 0;
        for (String x : a) {
        	sum += Integer.parseInt(x);
        }
        
        System.out.println(sum);
        os.write((sum + "").getBytes());
        os.flush();
        
        is.close();
        os.close();
        socket.close();
    }
}
