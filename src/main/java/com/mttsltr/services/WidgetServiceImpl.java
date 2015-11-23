package com.mttsltr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mttsltr.model.Widget;
import com.mttsltr.repositories.WidgetRepository;

@Service
public class WidgetServiceImpl implements WidgetService {

	private WidgetRepository widgetRepo;
	
	@Autowired
	public void setWidgetRepository(WidgetRepository widgetRepo) {
		this.widgetRepo = widgetRepo;
	}
	
	@Override
	public Iterable<Widget> listAllWidgets() {
		return widgetRepo.findAll();
	}

	@Override
	public Widget getWidgetbyId(int id) {
		return widgetRepo.findOne(id);
	}

	@Override
	public Widget saveWidget(Widget widget) {
		return widgetRepo.save(widget);
	}

	@Override
	public void deleteWidget(int id) {
		widgetRepo.delete(id);

	}

}
