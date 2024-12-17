package TCP;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class TCP_Khoang_cach_nho_nhat {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("203.162.10.109", 2206);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		String code = "B21DCCN553;3ZIQs9Vo";
		os.write(code.getBytes());
		os.flush();
		
		byte[] buffer = new byte[1024];
		int bytesRead = is.read(buffer);
		String s = new String(buffer, 0, bytesRead);
		System.out.println(s);
		
		ArrayList<Integer> a = new ArrayList<>();
		String []arrStr = s.split("\\,");
		for (String x : arrStr) {
			a.add(Integer.parseInt(x));
		}
		Collections.sort(a);
		System.out.println(a);
		int minKc = 2000000000, max1 = -2000000000, max2 = -2000000000;
		for (int i = 0; i < a.size() - 1; i++) {
			if (a.get(i + 1) - a.get(i) <= minKc) {
				if (max1 < a.get(i + 1) && max2 < a.get(i)) {
					minKc = a.get(i + 1) - a.get(i);
					max1 = a.get(i + 1);
					max2 = a.get(i);
				}
			}
		}
		System.out.println(minKc);
		System.out.println(max2);
		System.out.println(max1);
		
		String res = minKc + "," + max2 + "," + max1;
		System.out.println(res);
		
		os.write(res.getBytes());
		os.flush();
		
		is.close();
		os.close();
		socket.close();
	}
}
