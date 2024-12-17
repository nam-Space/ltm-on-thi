package RMI.B21DCCN214;

import java.rmi.registry.*;

import RMI.CharacterService;

public class RMI_JSON_so_lan_xuat_hien {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
		String studentCode = "B21DCCN214", qCode = "QXIhAbQY";
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
		res = res.substring(0, res.length() - 2);
		res += "}";
		System.out.println(res);
		sv.submitCharacter(studentCode, qCode, res);
	}
}
