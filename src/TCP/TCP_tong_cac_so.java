package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_tong_cac_so {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("203.162.10.109", 2206);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		String code = "B21DCCN039;hX2zhWcT";
		os.write(code.getBytes());
		os.flush();
		
		byte[] buffer = new byte[1024];
		int bytesRead = is.read(buffer);
		String s = new String(buffer, 0, bytesRead);
		System.out.println(s);
		
		String []arrStr = s.split("\\|");
		int sum = 0;
		for (String x : arrStr) {
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
