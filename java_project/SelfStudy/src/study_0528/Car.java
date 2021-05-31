package study_0528;

public class Car {
	int gasolineGauge;
	
	Car(int gg) {
		this.gasolineGauge = gg;
	}
}


class HybridCar extends Car {
	int electronicGauge;
	
	HybridCar(int gg, int eg) {
		super(gg);
		electronicGauge = eg;
	}
	
	HybridCar(int gg) {
		super(gg);
	}
	
}

class HybridWaterCar extends HybridCar {
	int waterGauge;
	
	HybridWaterCar(int gg, int eg, int wg) {
		super(gg, eg);
		waterGauge = wg;
	}
	
	HybridWaterCar(int gg, int eg) {
		super(gg, eg);
	}
	
	HybridWaterCar(int gg) {
		super(gg);
	}
	
	public void showCurrentGauge() {
		System.out.println("잔여 가솔린 : " + gasolineGauge);
		System.out.println("잔여 가솔린 : " + electronicGauge);
		System.out.println("잔여 가솔린 : " + waterGauge);
		
	}
	
}
