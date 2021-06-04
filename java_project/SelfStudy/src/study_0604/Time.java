package study_0604;

class Time {
	private int hour;
	private int minute;
	private float second;
	
	public int getHour() {
		return hour;
	}
	
	public void setHour(int h) {
		if (h < 0 || h > 23)
			return;
		hour = h;
	}
	
	public int minute() {
		return minute;
	}
	
	public void setMinute(int m) {
		if(m < 0 || m > 59)
			return;
		minute = m;
		}

	public float second() {
		return second;
	}
	
	public void setSecond(float s) {
		if(s < 0 || s > 59)
			return;
		second = s;
	}


}

