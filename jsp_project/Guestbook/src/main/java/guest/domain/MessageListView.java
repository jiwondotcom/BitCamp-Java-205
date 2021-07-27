package guest.domain;

import java.util.List;

public class MessageListView {

	private List<Message> messageList; 	// 게시물 Message 객체 3개
	private int messageTotalCount; 		// 전체 게시물의 개수
	private int currentPageNum; 		// 현재 페이지 번호
	private int pageTotalCount; 		// 페이지의 개수
	private int messageCountPerPage; 	// 한페이지에 표현할 메시지의 개수
	private int firstRow; 				// DB 게시물의 시작 위치 (index)
	private int endRow;					// 마지막 위치
	
	
	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPageNum,
			int messageCountPerPage, int firstRow, int endRow) {
		super();
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPageNum = currentPageNum;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calPageTotalCount();
	}


	private void calPageTotalCount() {

		if(this.messageTotalCount == 0) { // 전체 게시물의 개수가 0이면
			this.pageTotalCount = 0; // 페이지 넘버 표현이 필요없다.
		} else {
			// (전체 게시물 개수) / (한페이지에 표현할 메시지의 개수)
			// ex. (전체 게시물 10개) / (한페이지에 3개씩 표현) = 총 페이지 개수는 3 = pageTotalCount
			this.pageTotalCount = this.messageTotalCount /  this.messageCountPerPage;
			if (this.messageTotalCount / this.messageCountPerPage > 0) {
				this.pageTotalCount++;
			}
		
		}
		
	}

	// getter 기능만 
	// DB에서 가져오는 값이기 떄문에, setter 기능은 필요가 없다. 
	public List<Message> getMessageList() {
		return messageList;
	}


	public int getMessageTotalCount() {
		return messageTotalCount;
	}


	public int getCurrentPageNum() {
		return currentPageNum;
	}


	public int getPageTotalCount() {
		return pageTotalCount;
	}


	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}


	public int getFirstRow() {
		return firstRow;
	}


	public int getEndRow() {
		return endRow;
	}
	
	
}
