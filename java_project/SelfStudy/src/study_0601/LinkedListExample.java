package study_0601;

//import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.*;

// ArrayList와 LinkedList의 실행 성능 비교
// 끝에서부터(순차적으로) 추가 또는 삭제하는 경우에는 ArrayList가 빠르지만,
// 중간에 추가, 삭제하는 경우 앞뒤 링크 정보만 변경하면 되는 LinkedList가 더 빠르다.
// ArrayList는 뒤쪽 인덱스들을 모두 1씩 증가 또는 감소시키는 시간이 피룡하므로 속도가 상대적으로 느리다.
public class LinkedListExample {
	public static void main(String[] args) {

		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		
		endTime = System.nanoTime();
		System.out.println("ArrayList 걸린 시간: " + (endTime - startTime) + " ns");
		
		
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
	
		endTime = System.nanoTime();
		System.out.println("LinkedList 걸린 시간: " + (endTime - startTime) + " ns");
	
	}
}
