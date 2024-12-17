package RMI.B21DCCN734;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.ObjectService;
import RMI.Product;

public class ProductCode {
	public static void main(String[] args) throws Exception {
		Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
		ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
		String studentCode = "B21DCCN734", qCode = "u68Bd6cy";
		Product product = (Product) sv.requestObject(studentCode, qCode);
		System.out.println(product);
		
		String code = product.getCode();
		String newCode = code.toUpperCase();
		product.setCode(newCode);
		
		double importPrice = product.getImportPrice();
		double exportPrice = importPrice * 1.2f;
		product.setExportPrice(exportPrice);
		
		System.out.println(product);
		sv.submitObject(studentCode, qCode, product);
	}
}
