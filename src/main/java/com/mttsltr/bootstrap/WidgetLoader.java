package com.mttsltr.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mttsltr.model.Widget;
import com.mttsltr.repositories.WidgetRepository;

@Component
public class WidgetLoader implements ApplicationListener<ContextRefreshedEvent>{
	
	private WidgetRepository widgetRepo;
	private Logger log = Logger.getLogger(WidgetLoader.class);
	
	@Autowired
	public void setWidgetRepository(WidgetRepository widgetRepo) {
		this.widgetRepo = widgetRepo;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Widget x = new Widget();
		x.setName("Broken Printer");
		x.setDescription("A broken printer from 1997.");
		widgetRepo.save(x);
		
		log.info(String.format("Saved %s with id: %d", x.getName(), x.getId()));
		
		Widget y = new Widget();
		y.setName("Ghost Scanner");
		y.setDescription("A piece of equipment that detects spirits and spooks.");
		widgetRepo.save(y);
		
		log.info(String.format("Saved %s with id: %d", y.getName(), y.getId()));
		
		Widget z = new Widget();
		z.setName("Ice Sphere Tray");
		z.setDescription("Makes ice spheres instead of normal ice cubes.");
		widgetRepo.save(z);
		
		log.info(String.format("Saved %s with id: %d", z.getName(), z.getId()));
		
		Widget zz = new Widget();
		zz.setName("Decontamination Device");
		zz.setDescription("Decontaminates any contaminated item.");
		widgetRepo.save(zz);
		
		log.info(String.format("Saved %s with id: %d", zz.getName(), zz.getId()));
		
	}

}
