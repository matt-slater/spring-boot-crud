package com.mttsltr.services;

import com.mttsltr.model.Widget;

public interface WidgetService {
	
	Iterable<Widget> listAllWidgets();
	
	Widget getWidgetbyId(int id);
	
	Widget saveWidget(Widget widget);
	
	void deleteWidget(int id);

}
