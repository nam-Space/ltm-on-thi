package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_tong_tbc_phuong_sai {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("203.162.10.109", 2207);
		DataInputStream is = new DataInputStream(socket.getInputStream());
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		
		String code = "B21DCCN036;UHfZHbEm";
		os.writeUTF(code);
		os.flush();
		
		int n = is.readInt();
		System.out.println(n);
		
		String daySo = "";
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int so = is.readInt();
			a.add(so);
			daySo += so + ",";
		}
		System.out.println(daySo);
		int sum = 0, cnt = 0;
		for (int i = 0; i < a.size(); i++) {
			sum += a.get(i);
			cnt++;
		}
		System.out.println(sum);
		float tbc = (float)sum / cnt;
		float ps = 0;
		System.out.println(tbc);
		for (int i = 0; i < a.size(); i++) {
			ps += (a.get(i) - tbc) * (a.get(i) - tbc);
		}
		ps = (float)ps / cnt;
		System.out.println(ps);
		
		os.writeInt(sum);
		os.flush();
		os.writeFloat(tbc);
		os.flush();
		os.writeFloat(ps);
		os.flush();
		
		is.close();
		os.close();
		socket.close();
	}
}
