package guest.service;

import guest.domain.MessageListView;

public class MessageListService {

	// 싱글톤 처리
	private MessageListService() {}
	
	private static MessageListService service = new MessageListService();
	
	public static MessageListService getInstance() {
		return service;
	}
	
	
	
	public MessageListView getMessageList(int pageNumber) {
		
		MessageListView listView = null;
		
		
		
		
		return listView;
	}
	
	
}
