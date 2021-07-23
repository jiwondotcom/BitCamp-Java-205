package product;

import java.util.Arrays;

// beans 형식의 클래스로 정의 : 상품정보를 저장한다.
public class Product {

	// 상품 목록 : 배열 활용
	private String[] productList = {"item1", "item2", "item3", "item4", "item5"};

	// 변수 : el테스트용
	private int price = 100;
	private int amount = 1000;
	
	
	public String[] getProductList() {
		return productList;
	}
	public void setProductList(String[] productList) {
		this.productList = productList;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	// ${product.display}
	public String getDisplay() {
		return "price : " + this.price + ", amount : " + this.amount;
	}
	
	
	@Override
	// util.Arrays : 배열 모양으로 출력해준다.
	public String toString() {
		return "Product [productList=" + Arrays.toString(productList) + ", price=" + price + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
	
}
