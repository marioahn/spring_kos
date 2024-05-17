package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.board.DeleteBoardController;
import com.springbook.view.board.GetBoardController;
import com.springbook.view.board.GetBoardListController;
import com.springbook.view.board.InsertBoardController;
import com.springbook.view.board.UpdateBoardController;
import com.springbook.view.user.LoginController;
import com.springbook.view.user.LogoutController;


public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	// !!controller를 만들었으면, 각각 모든 경로를 mappings에 등.록.을 해줘야 한다!
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	/*- 음.. path를 get으로 가져오네.. 어떻게 내부적으로 동작하는거지 이 함수가;;
	  -> HashMap은 key:value형태임ㅇㅇ. 그니까 그냥 key값으로 value찾는거임;;
	  -> URL 요청 경로를 적절한 컨트롤러 객체에 매핑하는 역할의 메서드
	  -> mappings 맵에서 주어진 path를 키로 사용하여 해당 경로에 매핑된 컨트롤러 객체를 반환 */
	public Controller getController(String path) { // return타입은 Controller!
		return mappings.get(path);
	}
}
