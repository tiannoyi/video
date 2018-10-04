package com.hniu.service;

import org.springframework.stereotype.Repository;

import com.hniu.entity.Give;
import com.hniu.util.State;

@Repository
public interface GiveService {

	State<Object> getGiveByid(Integer id);

	State<Object> insertGive(Give give);

	State<Object> updateGive(Give give);

	State<Object> deleteByidGive(Integer id);

	State<Object> getAllByid(Integer id);

	
	
}
