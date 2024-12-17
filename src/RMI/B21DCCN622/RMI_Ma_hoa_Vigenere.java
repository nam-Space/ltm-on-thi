package RMI.B21DCCN622;

import java.rmi.registry.*;

import RMI.CharacterService;

public class RMI_Ma_hoa_Vigenere {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
		String studentCode = "B21DCCN622", qCode = "SrfgHbCO";
		String s = sv.requestCharacter(studentCode, qCode);
		System.out.println(s);
		String []arrStr = s.split("\\;");
		String khoa = arrStr[0], data = arrStr[1];
		String res = "";
		for (int i = 0; i < data.length(); i++) {
			char x = data.charAt(i);
			char y = khoa.charAt(i % khoa.length());
			char z;
			if (Character.isUpperCase(x)) {
				z = (char) ((x - 'A' + y - 'A') % 26 + 'A');
			}
			else {
				z = (char) ((x - 'a' + y - 'a') % 26 + 'a');
			}
			res += z;
		}
		System.out.println(res);
		sv.submitCharacter(studentCode, qCode, res);
	}
}
