package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCP_tong_tich {
	public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());
        
        String code = "B21DCCN553;obNrNZNz";
        os.writeUTF(code);
        os.flush();
        
        int a = is.readInt();
        int b = is.readInt();
        
        System.out.println(a);
        System.out.println(b);
        
        int tong = a + b;
        int tich = a * b;
        
        System.out.println(tong);
        System.out.println(tich);
        
        os.writeInt(tong);
        os.flush();
        os.writeInt(tich);
        os.flush();
        
        is.close();
        os.close();
        socket.close();
    }
}
