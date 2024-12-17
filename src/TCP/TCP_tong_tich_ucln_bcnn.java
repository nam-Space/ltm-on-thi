package TCP;

import java.io.*;
import java.net.*;

public class TCP_tong_tich_ucln_bcnn {
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("203.162.10.109", 2207);
		DataInputStream is = new DataInputStream(socket.getInputStream());
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		
		String code = "B21DCCN553;pyavpILT";
		os.writeUTF(code);
		os.flush();
		
		int a = is.readInt();
		int b = is.readInt();
		System.out.println(a);
		System.out.println(b);
		
		int ucln = gcd(a, b);
		int bcnn = a * b / ucln;
		int tong = a + b;
		int tich = a * b;
		
		System.out.println(ucln);
		System.out.println(bcnn);
		System.out.println(tong);
		System.out.println(tong);
		
		os.writeInt(ucln);
		os.flush();
		os.writeInt(bcnn);
		os.flush();
		os.writeInt(tong);
		os.flush();
		os.writeInt(tich);
		os.flush();
		
		is.close();
		os.close();
		socket.close();
	}
}
