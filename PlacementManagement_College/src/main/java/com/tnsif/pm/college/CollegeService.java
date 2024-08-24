package com.tnsif.pm.college;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository; 

    public List<College> listAll() {
        return collegeRepository.findAll();
    }

    public College get(long id) 
    {
        return collegeRepository.findById(id).get();
    }

    public College save (College college)
    
    {
        return collegeRepository.save(college);
    } 
    
    public Optional<College>getById(long id)
    
    {
    	return collegeRepository.findById(id);
    }
    
    public void delete(Long id) 
    {
       collegeRepository.deleteById(id);
      
    }

}

