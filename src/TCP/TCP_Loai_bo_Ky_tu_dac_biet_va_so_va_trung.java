package TCP;

import java.io.*;
import java.net.Socket;

public class TCP_Loai_bo_Ky_tu_dac_biet_va_so_va_trung {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("203.162.10.109", 2208);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		String code = "B21DCCN214;TKviOFLV";
		bw.write(code);
		bw.newLine();
		bw.flush();
		
		String s = br.readLine();
		System.out.println(s);
		int cnt[] = new int[301];
		String res = "";
		for (char x : s.toCharArray()) {
			if (Character.isAlphabetic(x)) {
				cnt[x]++;
			}
		}
		for (char x : s.toCharArray()) {
			if (Character.isAlphabetic(x) && cnt[x] == 1) {
				res += x;
				cnt[x] = 0;
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
