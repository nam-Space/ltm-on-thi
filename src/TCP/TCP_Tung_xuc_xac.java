package TCP;

import java.io.*;
import java.net.*;

public class TCP_Tung_xuc_xac {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("203.162.10.109", 2207);
		DataInputStream is = new DataInputStream(socket.getInputStream());
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		
		String code = "B21DCCN214;acz7SqbE";
		os.writeUTF(code);
		os.flush();
		
		int n = is.readInt();
		System.out.println(n);
		
		int cnt[] = new int[7];
		for (int i = 0; i < n; i++) {
			int x = is.readInt();
			cnt[x]++;
		}
		String res = "";
		for (int i = 1; i <= 6; i++) {
			float p = (float) cnt[i] / n;
			System.out.println(p);
			os.writeFloat(p);
			os.flush();
		}
		
		is.close();
		os.close();
		socket.close();
	}
}
