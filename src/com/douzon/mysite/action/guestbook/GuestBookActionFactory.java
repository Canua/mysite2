package com.douzon.mysite.action.guestbook;

import com.douzon.mvc.action.AbstractActionFactory;
import com.douzon.mvc.action.Action;
import com.douzon.mysite.action.main.IndexAction;

public class GuestBookActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if ("deleteform".equals(actionName)) {
			action = new DeleteFormAction();
		} else if ("insert".equals(actionName)) {
			action = new InstertAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if ("ajax".equals(actionName)) { // ajax 프로그래밍이 되어 있는 jsp를 보여달라 // ajax 요청이 아니다
			action = new AjaxAction();
		} else {
			action = new ListAction();
		}
		return action;
	}

}
