package RMI.B21DCCN036;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;

import RMI.CharacterService;

public class RMI_Ma_hoa_Base64 {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
		String studentCode = "B21DCCN036", qCode = "b63ewogG";
		String s = sv.requestCharacter(studentCode, qCode);
		System.out.println(s);
		byte[] base64 = Base64.getEncoder().encode(s.getBytes());
		String res = "";
		for (byte x : base64) {
			res += (char)x;
		}
		System.out.println(res);
		sv.submitCharacter(studentCode, qCode, res);
	}
}
