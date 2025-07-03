package com.Spring.Api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Spring.Api.Dao.SportRepo;
import com.Spring.Api.Entities.Sport;
@Component
public class SportService {
   
	@Autowired
	private SportRepo sr;

	public List<Sport> getAllSports() {
		List<Sport> l=(List<Sport>) this.sr.findAll();
		return l;
	}

	public Sport getSportById(int id) {
		Sport s=null;
		
		try {
			s=this.sr.findById(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
				
		return s;
	}

	public Sport addSport(Sport s) {
		Sport res=sr.save(s);
		return res;
	}

	public void deleteSport(int sId) {
		sr.deleteById(sId);
		
	}

	public void updateSport(Sport s, int sId) {
		s.setsId(sId);
		sr.save(s);
		
	}
}
