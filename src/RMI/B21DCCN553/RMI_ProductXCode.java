package RMI.B21DCCN553;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

import RMI.ObjectService;
import RMI.ProductX;

public class RMI_ProductXCode {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
		ProductX product = (ProductX) sv.requestObject("B21DCCN553", "iUPTTYqA");
		System.out.println(product);
		
		String discountCode = product.getDiscountCode();
		int sum = 0;
		for (char x : discountCode.toCharArray()) {
			if (Character.isDigit(x)) sum += Integer.parseInt(x + "");
		}
		System.out.println(sum);
		product.setDiscount(sum);
		System.out.println(product);
		
		sv.submitObject("B21DCCN553", "iUPTTYqA", product);
	}
}
