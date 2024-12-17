package TCP;

import java.io.*;
import java.net.*;

public class TCP_giai_ma_caesar {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("203.162.10.109", 2207);
		DataInputStream is = new DataInputStream(socket.getInputStream());
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		
		String code = "B21DCCN622;RUUupauh";
		os.writeUTF(code);
		os.flush();
		
		String s = is.readUTF();
		System.out.println(s);
		int n = is.readInt();
		System.out.println(n);
		
		String res = "";
		for (char x : s.toCharArray()) {
			char goc = Character.isUpperCase(x) ? 'A' : 'a';
			res += (char)((x - goc + n) % 26 + goc);
		}
		System.out.println(res);
		os.writeUTF(res);
		os.flush();
		
		is.close();
		os.close();
		socket.close();
	}
}
