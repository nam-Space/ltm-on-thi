package RMI.B21DCCN021;

import java.rmi.registry.*;

import RMI.CharacterService;

public class RMI_ChuyenLaMaThanhThapPhan {
	public static int convert(char x) {
		if (x == 'I') return 1;
		if (x == 'V') return 5;
		if (x == 'X') return 10;
		if (x == 'L') return 50;
		if (x == 'C') return 100;
		if (x == 'D') return 500;
		return 1000;
	}
	
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
		String studentCode = "B21DCCN021", qCode = "klyAmvMM";
		String s = sv.requestCharacter(studentCode, qCode);
		System.out.println(s);
		int sum = 0;
		sum += convert(s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; i--) {
			if (convert(s.charAt(i + 1)) > convert(s.charAt(i))) {
				sum -= convert(s.charAt(i));
			}
			else {
				sum += convert(s.charAt(i));
			}
		}
		System.out.println(sum);
		sv.submitCharacter(studentCode, qCode, (sum + ""));
	}
}
