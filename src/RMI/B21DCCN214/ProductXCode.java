package RMI.B21DCCN214;

import java.rmi.registry.*;

import RMI.ObjectService;
import RMI.ProductX;

public class ProductXCode {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
		String studentCode = "B21DCCN214", qCode = "uQJccEj9";
		ProductX product = (ProductX) sv.requestObject(studentCode, qCode);
		System.out.println(product);
		
		String discountCode = product.getDiscountCode();
		int discount = 0;
		for (char x : discountCode.toCharArray()) {
			if (Character.isDigit(x)) {
				discount += Integer.parseInt(x + "");
			}
		}
		product.setDiscount(discount);
		
		System.out.println(product);
		sv.submitObject(studentCode, qCode, product);
	}
}
