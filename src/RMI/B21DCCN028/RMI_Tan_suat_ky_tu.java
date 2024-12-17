package RMI.B21DCCN028;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.CharacterService;

public class RMI_Tan_suat_ky_tu {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
		String studentCode = "B21DCCN028", qCode = "kDu4POf7";
		String s = sv.requestCharacter(studentCode, qCode);
		System.out.println(s);
		int []cnt = new int[301];
		for (char x : s.toCharArray()) {
			cnt[x]++;
		}
		String res = "{";
		for (char x : s.toCharArray()) {
			if (cnt[x] >= 1) {
				res += "\"" + x + "\": " + cnt[x] + ", ";
				cnt[x] = 0;
			}
		}
		System.out.println(res);
		res = res.substring(0, res.length() - 2);
		res += "}";
		System.out.println(res);
		sv.submitCharacter(studentCode, qCode, res);
	}
}
