package RMI.B21DCCN553;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.Base64;

import RMI.CharacterService;

public class RMI_Ma_hoa_Base64 {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
		
		String s = sv.requestCharacter("B21DCCN553", "OMxNXWSg");
		System.out.println(s);
		
		String res = Base64.getEncoder().encodeToString(s.getBytes());
		System.out.println(res);
		
		sv.submitCharacter("B21DCCN553", "OMxNXWSg", res);
	}
}
