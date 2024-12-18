package RMI.B21DCCN053;

import java.net.URLEncoder;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.CharacterService;

public class RMI_Ma_hoa_URL {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
		String studentCode = "B21DCCN053", qCode = "4r7rXYTJ";
		String s = sv.requestCharacter(studentCode, qCode);
		System.out.println(s);
		String res = URLEncoder.encode(s, "UTF-8");
		System.out.println(res);
		sv.submitCharacter(studentCode, qCode, res);
	}
}
