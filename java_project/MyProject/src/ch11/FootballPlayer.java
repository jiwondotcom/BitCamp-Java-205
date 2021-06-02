package ch11;

	public class FootballPlayer implements Comparable<FootballPlayer> {

		private String name;
		private int number;
		private String team;
		private int age;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getTeam() {
			return team;
		}

		public void setTeam(String team) {
			this.team = team;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		
		public FootballPlayer(String name, int number, String team, int age) {
			this.name = name;
			this.number = number;
			this.team = team;
			this.age = age;
		}

		
	
		@Override 
		public boolean equals(Object obj) { // 이름, 번호, 팀, 나이가 같으면 true값 리턴
			boolean chk = false;
			
			if (obj != null && obj instanceof FootballPlayer) {
				FootballPlayer player = (FootballPlayer) obj;
				if (player.name.equals(name) && (player.number == number)
						&& player.team.equals(team) && (player.age == age)) {
				chk = true;
			} else {
				chk = false;;
			}
				}
			return chk;
		}
		
		@Override
		public int hashCode() { // name과 age, number의 값이 같으면 동일한 hashcode를 리턴.
			return name.hashCode() + age + number;
		} // String의 hashCode() 이용	
	
		
	
		@Override
		public String toString() {
			return "이름: " + name + '\n' +
					"번호: " + number + '\n' +
					"소속팀: " + team + '\n' +
					"나이: " + age + 
					"\n==============";
		}
		
		
		// 03.
		// TreeSet<E>을 이용해서 팀 이름순으로 정렬,
		// 같은 팀의 선수들은 이름 순으로 정렬하고,
		// 같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
		
		public int compareTo(FootballPlayer p) {
			
			int result = this.team.compareTo(p.getTeam()); // 음수or양수or0
		        if (result == 0) { // 같을시 result 값 0
		            result = this.name.compareTo(p.getName()); // 이름 비교
		            	if(result == 0){ // 이름이 같을시,
		            		result = this.number - p.getNumber(); // 번호 비교, 오름차순
		                }
		            }
		return result;
}
	}

