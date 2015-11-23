package com.mttsltr.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mttsltr.model.Widget;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {}
