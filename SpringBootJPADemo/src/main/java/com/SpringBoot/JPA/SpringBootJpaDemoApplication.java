package com.SpringBoot.JPA;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.SpringBoot.JPA.Dao.UserRepo;
import com.SpringBoot.JPA.Entities.User;

@SpringBootApplication
public class SpringBootJpaDemoApplication {

	public static void main(String[] args) {
		ApplicationContext con=SpringApplication.run(SpringBootJpaDemoApplication.class, args);
		
		UserRepo u=con.getBean(UserRepo.class);
		
//		User us=new User();
		
//		us.setName("Navneet raj");
//		us.setCity("pune");
//		us.setStatus("not reachable");
//		
//		User user=u.save(us);
//		System.out.println(user);
		
		
		User us1=new User();
		us1.setName("sumit");
		us1.setCity("patna");
		us1.setStatus("coming bro");
		
		
		User us2=new User();
		us2.setName("vikram");
		us2.setCity("Bhagalpur");
		us2.setStatus("artist");
		
		//for single object save
//		User user = u.save(us2);
//		System.out.println(user);
		
		
	    //for multple object save
  /*     List<User> list = List.of(us1,us2);
         Iterable<User> res = u.saveAll(list);
		
          //display
          res.forEach(users->{
          System.out.println(users);
            });
*/	
		
		
		//update
	/*	Optional<User> optional = u.findById(102);
		User user = optional.get();
		user.setName("Sumit raj");
		 User res = u.save(user);
		 System.out.println(res);
         System.out.println("done");
	*/
		
		//get single data
	/* Optional<User> opt = u.findById(1);
		User user = opt.get();
		System.out.println(user);
	*/
		
		// show multiple data
	/*	Iterable<User> iter= u.findAll();
	    iter.forEach(user->{System.out.println(user);});
	*/	
		
		//delete single object
	/*	u.deleteById(102);
		System.out.println("deleted");
	*/
		
		//delete multiple user element
	/*	Iterable<User> allUsers = u.findAll();
		allUsers.forEach(users->{System.out.println(users);});
		u.deleteAll(allUsers);
		System.out.println("deleted all");
	*/	
		
		
//	 List<User> Name = u.findByName("vikram");
//	Name.forEach(e->System.out.println(e));
	
	
	List<User> nAc = u.findByNameAndCity("sumit", "patna");
	nAc.forEach(e->System.out.println(e));
	}

}
