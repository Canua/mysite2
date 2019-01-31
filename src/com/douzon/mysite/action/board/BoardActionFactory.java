package com.douzon.mysite.action.board;

import com.douzon.mvc.action.AbstractActionFactory;
import com.douzon.mvc.action.Action;

public class BoardActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if ("write".equals(actionName)) {
			action = new BoardWriteAction();
		} else if ("insert".equals(actionName)) {
			action = new InsertAction();
		} else if ("view".equals(actionName)) {
			action = new ViewAction();
		} else if ("modify".equals(actionName)) {
			action = new BoardModifyFormAction();
		} else if ("modifyform".equals(actionName)) {
			action = new BoardModifyAction();
		} else if ("deleteboard".equals(actionName)) {
			action = new BoardDeleteAction();
		}else if ("replyform".equals(actionName)) {
			action = new ReplyFormAction();
		}else if ("reply".equals(actionName)) {
			action = new ReplyAction();
		}else if ("search".equals(actionName)) {
			action = new searchAction();
		} 
//		else if ("page".equals(actionName)) {
//			action = new BoardPageAction();
//		}
		else {
//			action = new BoardAction();
			action = new BoardPageAction();
		}
		return action;
	}
}
