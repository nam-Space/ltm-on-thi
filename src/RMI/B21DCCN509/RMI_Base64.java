package RMI.B21DCCN509;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;

import RMI.CharacterService;

public class RMI_Base64 {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
		String studentCode = "B21DCCN509", qCode = "qIYTipuQ";
		String s = sv.requestCharacter(studentCode, qCode);
		System.out.println(s);
		byte []res = Base64.getEncoder().encode(s.getBytes());
		String ans = "";
		for (byte x : res) {
			ans += (char)x;
		}
		System.out.println(ans);
		sv.submitCharacter(studentCode, qCode, ans);
	}
}
