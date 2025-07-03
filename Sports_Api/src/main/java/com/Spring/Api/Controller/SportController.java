package com.Spring.Api.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Api.Entities.Sport;
import com.Spring.Api.Service.SportService;

@RestController
public class SportController {
	@Autowired
	private SportService ss;
	
	@GetMapping("/sport")
	private ResponseEntity<List<Sport>> getSports(){
		
		    List<Sport> l=ss.getAllSports();
			if(l.size()<=0) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(l);
	}
	
	  @GetMapping("/sport/{sId}")
	  private ResponseEntity<Sport> getSport(@PathVariable("sId") int sId) {
		    Sport s=ss.getSportById(sId);
		    if(s==null) {
		    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		    }
		  
		return ResponseEntity.of(Optional.of(s));
		  
	  }
	  
	  @PostMapping("/sport")
	  private ResponseEntity<Sport> addSport(@RequestBody Sport s){
		  Sport st=null;
				  
		  try {
			st=this.ss.addSport(s);
			System.out.println(st);
			return ResponseEntity.of(Optional.of(st));
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		  }
	  @DeleteMapping("/sport/{sId}")
	  private ResponseEntity<Sport> deleteSport(@PathVariable("sId")int sId) {
		  try {
			this.ss.deleteSport(sId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	  }
	  @PutMapping("sport/{sId}")
	  private ResponseEntity<Sport> updateSport(@RequestBody Sport s,@PathVariable("sId") int sId) {
		    try {
				this.ss.updateSport(s,sId);
				return ResponseEntity.ok().body(s);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		  
	  }
	  
	

}
