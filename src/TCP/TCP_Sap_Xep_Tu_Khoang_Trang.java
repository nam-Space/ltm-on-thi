package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_Sap_Xep_Tu_Khoang_Trang {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("203.162.10.109", 2208);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		String code = "B21DCCN509;sWdrIVZb";
		bw.write(code);
		bw.newLine();
		bw.flush();
		
		String s = br.readLine();
		System.out.println(s);
		
		String []arrStr = s.split("\\s+");
		ArrayList<String> a = new ArrayList<>();
		for (String x : arrStr) {
			a.add(x);
		}
		Collections.sort(a);
		String res = "";
		for (String x : a) {
			res += x + " ";
		}
		res = res.substring(0, res.length() - 1);
		System.out.println(res);
		
		bw.write(res);
		bw.newLine();
		bw.flush();
		
		br.close();
		bw.close();
		socket.close();
	}
}
