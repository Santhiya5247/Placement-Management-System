package com.tnsif.pm.college;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; 

@RestController

public class CollegeController 
{
	@Autowired   
    private CollegeService collegeService;

//RESTful API methods for Retrieval operations
	@GetMapping("/colleges")
	public List<College> list()
	{
		return collegeService.listAll();
	
    }

    @GetMapping("/colleges/{id}")
    public ResponseEntity<College> get (@PathVariable Long id) 
    {
      try
      {
    	  College college = collegeService.get(id);
    	  return new ResponseEntity<College>(college,HttpStatus.OK); 
      }
      catch(Exception e)
      {
    	  return new ResponseEntity<College>(HttpStatus.NOT_FOUND); 
      }
    }
//create 
    
    @PostMapping("/colleges")
    public void add(@RequestBody College college)
    {
        collegeService.save(college);
    }
// Update
    @PutMapping("/colleges/{id}")
    public ResponseEntity<College> update(@RequestBody College college, @PathVariable Long id) {
        try {
            College existCollege = collegeService.get(id);
            if (existCollege != null) {
                // Set the existing college ID to the new college object to ensure it's updated
                college.setId(id);
                collegeService.save(college);
                return new ResponseEntity<>(college, HttpStatus.OK);
            } 
            else 
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//Delete operation
    
    @DeleteMapping("/colleges/{id}")
    public void delete(@PathVariable Long id)
    {
        collegeService.delete(id);
        
    }
}
