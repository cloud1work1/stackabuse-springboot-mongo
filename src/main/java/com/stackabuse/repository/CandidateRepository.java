package com.stackabuse.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackabuse.entity.Candidate;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate, Long> {

	Optional<Candidate> findByEmail(String email);
	
	List<Candidate> findByExpGreaterThanEqual(double exp);
	
	List<Candidate> findByExpBetween(double start, double end);
}
