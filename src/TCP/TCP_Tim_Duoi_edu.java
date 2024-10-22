package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCP_Tim_Duoi_edu {
	public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        String code = "B21DCCN553;i4Ux0CtA";
        bw.write(code);
        bw.newLine();
        bw.flush();
        
        String s = br.readLine();
        System.out.println(s);
        String res = "";
        String []a = s.split("\\, ");
        for (String x : a) {
        	if (x.contains(".edu")) res += x + ", ";
        }
        res = res.substring(0, res.length() - 2);
        System.out.println(res);
        
        bw.write(res);
        bw.newLine();
        bw.flush();
        
        br.close();
        bw.close();
        socket.close();
    }
}
