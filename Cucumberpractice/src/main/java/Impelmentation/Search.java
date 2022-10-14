package Impelmentation;

public class Search {
	public static String disaplayProduct(Product product)
	{
		if(product.getProductList().contains(product.getProductname()))
		{
		return product.getProductname();
	    }
	return null;
	}
}
