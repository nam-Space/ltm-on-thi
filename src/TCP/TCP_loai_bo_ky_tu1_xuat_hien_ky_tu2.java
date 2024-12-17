package TCP;

import java.io.*;
import java.net.*;

public class TCP_loai_bo_ky_tu1_xuat_hien_ky_tu2 {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("203.162.10.109", 2208);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		String code = "B21DCCN622;ypEQTPWH";
		bw.write(code);
		bw.newLine();
		bw.flush();
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		System.out.println(s1);
		System.out.println(s2);
		String res = "";
		for (char x : s1.toCharArray()) {
			if (!s2.contains(x + "")) {
				res += x;
			}
		}
		System.out.println(res);
		bw.write(res);
		bw.newLine();
		bw.flush();
		
		br.close();
		bw.close();
		socket.close();
	}
}
