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
		} else if ("list".equals(actionName)) {
			action = new listAction();
		} else if ("insert".equals(actionName)) {
			action = new InstertAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		}
		else {
			action = new IndexAction();
		}
		return action;
	}

}
