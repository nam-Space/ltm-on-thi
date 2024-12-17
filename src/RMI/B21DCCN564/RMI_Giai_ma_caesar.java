package RMI.B21DCCN564;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.CharacterService;

public class RMI_Giai_ma_caesar {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
		String studentCode = "B21DCCN564", qCode = "MEaaUyM9";
		String s = sv.requestCharacter(studentCode, qCode);
		System.out.println(s);
		String res = "";
		int dich = s.length() % 7; 
		for (char x : s.toCharArray()) {
			char base = Character.isUpperCase(x) ? 'A' : 'a';
			res += (char)((x - base - dich + 26) % 26 + base);
		}
		System.out.println(res);
		sv.submitCharacter(studentCode, qCode, res);
	}
}
