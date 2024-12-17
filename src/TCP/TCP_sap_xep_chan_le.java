package TCP;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;

public class TCP_sap_xep_chan_le {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("203.162.10.109", 2206);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		String code = "B21DCCN214;GgqMVu1F";
		os.write(code.getBytes());
		os.flush();
		
		byte [] buffer = new byte[1024];
		int bytesRead = is.read(buffer);
		String s = new String(buffer, 0, bytesRead);
		System.out.println(s);
		String []arrStr = s.split("\\,");
		ArrayList<Integer> chan = new ArrayList<>();
		ArrayList<Integer> le = new ArrayList<>();
		for (String x : arrStr) {
			int so = Integer.parseInt(x);
			if (so % 2 == 0) chan.add(so);
			else le.add(so);
		}
		Collections.sort(chan);
		Collections.sort(le);
		
		String res = "[";
		for (Integer x : chan) {
			res += x + ", ";
		}
		res = res.substring(0, res.length() - 2);
		res += "];[";
		for (Integer x : le) {
			res += x + ", ";
		}
		res = res.substring(0, res.length() - 2);
		res += "]";
		System.out.println(res);
		
		os.write(res.getBytes());
		os.flush();
		
		is.close();
		os.close();
		socket.close();
	}
}
