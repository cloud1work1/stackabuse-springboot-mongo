package com.stackabuse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stackabuse.entity.Candidate;
import com.stackabuse.exception.ResourceNotFoundException;
import com.stackabuse.repository.CandidateRepository;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@PostMapping
	@ResponseStatus(code= HttpStatus.CREATED)
	public Candidate save(@RequestBody Candidate candidate) {
		return candidateRepository.save(candidate);
	}
	
	@GetMapping
	public List<Candidate> findAll() {
		return candidateRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Candidate findById(@PathVariable("id") Long id) {
		return candidateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public void delete(@PathVariable("id") Long id) {
		Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		candidateRepository.delete(candidate);
	}

}
