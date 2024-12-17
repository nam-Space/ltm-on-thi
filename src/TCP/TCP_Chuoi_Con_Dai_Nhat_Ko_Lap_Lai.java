package TCP;

import java.io.*;
import java.net.*;

public class TCP_Chuoi_Con_Dai_Nhat_Ko_Lap_Lai {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("203.162.10.109", 2206);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		String code = "B21DCCN509;Nml8abEC";
		os.write(code.getBytes());
		os.flush();
		
		byte[] buffer = new byte[1024];
		int bytesRead = is.read(buffer);
		String s = new String(buffer, 0, bytesRead);
		System.out.println(s);
		
		String res = "";
		int maxL = 0;
		for (int i = 0; i < s.length(); i++) {
			String tmp = "";
			int []cnt = new int[301];
			for (int j = i; j < s.length(); j++) {
				if (cnt[s.charAt(j)] == 1) break;
				cnt[s.charAt(j)]++;
				tmp += s.charAt(j);
				if (tmp.length() > res.length()) {
					res = tmp;
					maxL = tmp.length();
				}
			}
		}
		String ans = res + ";" + maxL;
		System.out.println(ans);
		os.write(ans.getBytes());
		os.flush();
		
		is.close();
		os.close();
		socket.close();
	}
}
