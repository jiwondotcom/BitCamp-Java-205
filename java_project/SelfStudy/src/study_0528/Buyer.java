package study_0528;

public class Buyer { // 고객, 물건을 구매하는 사람

	int money = 1000; // 소유금액
	int bonusPoint = 0; // 현재 포인트점수
	
	Product[] item = new Product[10]; // 구입한 물건을 담을 배열
	
	int i = 0;
	
	void buy(Product p) { // product 호출
		if(money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		money -= p.price; // 현재 갖고있는 돈 - 구입한 제품의 가격
		bonusPoint += p.bonusPoint; // 각 제품의 구매시 포인트점수를 추가한다.
		item[i++] = p;
		
		System.out.println(p + "을/를 구매완료 하였습니다.");
	}

	void summary() { // 구매한 물품에 대한 정보를 요약해서 보여준다.
		int sum = 0; // 구매한 물품의 가격 합계
		String itemList = ""; // 구매한 물품의 목록
		
		// 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
		for (int i = 0; i < item.length; i++) {
			if (item[i] == null) break;
				sum += item[i].price; // sum + item[i].price = sum에 값 저장
				itemList += item[i] + ", "; // itemList는 ,반점으로 각 요소를 구분지어둔 배열item
		}
		
		System.out.println("구입하신 물품의 총 금액은 " + sum + "만원 입니다.");
		System.out.println("구입하신 제품은 " + itemList + "입니다.");
	
	}

}
