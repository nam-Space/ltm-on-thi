package RMI.B21DCCN029;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.CharacterService;

public class RMI_Ma_hoa_XOR {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
		String studentCode = "B21DCCN029", qCode = "jYXzshII";
		String s = sv.requestCharacter(studentCode, qCode);
		System.out.println(s);
		String []arrStr = s.trim().split("\\;");
		String key = arrStr[0];
		String data = arrStr[1];
		System.out.println(key);
		System.out.println(data);
		String res = "";
		for (int i = 0; i < data.length(); i++) {
			res += (char)(data.charAt(i) ^ key.charAt(i % key.length()));
		}
		System.out.println(res);
		sv.submitCharacter(studentCode, qCode, res);
	}
}
