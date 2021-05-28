package study_0528;

class Product {

	int price; // 제품의 가격
	int bonusPoint; // 제품구매시 제공하는 보너스점수
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0); // 보너스 점수는 제품가격의 10%
	}
}
