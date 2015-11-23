package com.mttsltr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mttsltr.model.Widget;
import com.mttsltr.services.WidgetService;

@Controller
public class WidgetController {
	
	private WidgetService widgetService;
	
	@Autowired
	public void setWidgetService(WidgetService widgetService) {
		this.widgetService = widgetService;
	}
	
	//CREATE
	
	@RequestMapping("widget/new")
	public String newWidget(Model model) {
		model.addAttribute("widget", new Widget());
		return "widgetform";
	}
	
	@RequestMapping(value="widget", method = RequestMethod.POST)
	public String saveWidget(Widget widget) {
		widgetService.saveWidget(widget);
		return "redirect:/widget/" + widget.getId(); 
	}
	
	//READ
	
	@RequestMapping("widget/{id}")
	public String showWidget(@PathVariable Integer id, Model model) {
		model.addAttribute("widget", widgetService.getWidgetbyId(id));
		return "widgetview";
	}
	
	@RequestMapping(value="widgets", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("widgets", widgetService.listAllWidgets());
		return "widgets";
	}
	
	//UPDATE
	
	@RequestMapping("widget/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("widget", widgetService.getWidgetbyId(id));
		return "widgetform";
	}
	
	//DELETE
	
	@RequestMapping("widget/delete/{id}")
	public String delete(@PathVariable Integer id) {
		widgetService.deleteWidget(id);
		return "redirect:/widgets";
	}
	
	
	
}
