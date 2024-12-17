package TCP;

import java.io.*;
import java.net.*;

public class TCP_Vi_tri_cua_tu_dai_nhat_trong_chuoi_ban_dau {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("203.162.10.109", 2208);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		String code = "B21DCCN039;oooNY7es";
		bw.write(code);
		bw.newLine();
		bw.flush();
		
		String s = br.readLine();
		System.out.println(s);
		
		String[]arrStr = s.split("\\s+");
		String maxLen = "";
		for (String x : arrStr) {
			if (x.length() > maxLen.length()) maxLen = x;
		}
		System.out.println(maxLen);
		int idx = s.indexOf(maxLen);
		System.out.println(idx);
		
		bw.write(maxLen);
		bw.newLine();
		bw.flush();
		
		bw.write(idx + "");
		bw.newLine();
		bw.flush();
		
		br.close();
		bw.close();
		socket.close();
	}
}
