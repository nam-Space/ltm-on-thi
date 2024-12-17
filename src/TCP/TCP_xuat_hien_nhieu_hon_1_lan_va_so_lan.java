package TCP;

import java.io.*;
import java.net.*;

public class TCP_xuat_hien_nhieu_hon_1_lan_va_so_lan {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("203.162.10.109", 2208);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		String code = "B21DCCN028;go8qJCiz";
		bw.write(code);
		bw.newLine();
		bw.flush();
		
		String s = br.readLine();
		System.out.println(s);
		int []cnt = new int[301];
		for (char x : s.toCharArray()) {
			if (Character.isAlphabetic(x) || Character.isDigit(x)) cnt[x]++;
		}
		String res = "";
		for (char x : s.toCharArray()) {
			if (cnt[x] >= 2) {
				res += x + ":" + cnt[x] + ",";
				cnt[x] = 0;
			}
		}
//		res = res.substring(0, res.length() - 1);
		System.out.println(res);
		
		bw.write(res);
		bw.newLine();
		bw.flush();
		
		br.close();
		bw.close();
		socket.close();
	}
}
