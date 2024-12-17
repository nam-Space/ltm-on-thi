package TCP;

import java.io.*;
import java.net.*;

public class TCP_KyTu_Va_So_Va_Dac_Biet {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("203.162.10.109", 2208);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		String code = "B21DCCN028;wARzqMpj";
		bw.write(code);
		bw.newLine();
		bw.flush();
		
		String s = br.readLine();
		System.out.println(s);
		
		String kytu_so = "", dac_biet = "";
		for (char x : s.toCharArray()) {
			if (Character.isDigit(x) || Character.isAlphabetic(x)) kytu_so += x;
			else dac_biet += x;
		}
		
		System.out.println(kytu_so);
		System.out.println(dac_biet);
		
		bw.write(kytu_so);
		bw.newLine();
		bw.flush();
		bw.write(dac_biet);
		bw.newLine();
		bw.flush();
		
		br.close();
		bw.close();
		socket.close();
	}
}
