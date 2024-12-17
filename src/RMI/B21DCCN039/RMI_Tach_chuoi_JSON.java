package RMI.B21DCCN039;

import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.registry.*;
import RMI.CharacterService;

public class RMI_Tach_chuoi_JSON {
	public static void main(String[] args) throws IOException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
		String json = sv.requestCharacter("B21DCCN039", "U6dIYKTu");
		System.out.println(json);
		json = json.replace("\"", "");
		json = json.replace("{", "");
		json = json.replace("}", "");
		String []arrStr = json.trim().split("\\,");
		String chuoi1 = "", chuoi2 = "";
		for (int i = 0; i < arrStr.length; i++) {
			if (i % 2 == 0) {
				chuoi1 += arrStr[i] + ",";
			}
			else {
				chuoi2 += arrStr[i] + ",";
			}
		}
		chuoi1 = chuoi1.substring(0, chuoi1.length() - 1);
		chuoi2 = chuoi2.substring(0, chuoi2.length() - 1);
		System.out.println(chuoi1);
		System.out.println(chuoi2);
		String res = chuoi1 + ";" + chuoi2;
		System.out.println(res);
		
		sv.submitCharacter("B21DCCN039", "U6dIYKTu", res);
	}
}
