package guest.domain;

import java.util.List;

public class MessageListView {

	private List<Message> messageList; 	// 게시물 Message 객체 3개
	private int messageTotalCount; 		// 전체 게시물의 개수
	private int currentPageNum; 		// 현재 페이지 번호
	private int pageTotalCount; 		// 페이지의 개수
	private int messageCountPerPage; 	// 한페이지에 표현할 메시지의 개수
	private int firstRow; 				// DB 게시물의 시작 위치 (index)
	private int endRow;					// DB 게시물의 마지막 위치 (index)
	
	
}
