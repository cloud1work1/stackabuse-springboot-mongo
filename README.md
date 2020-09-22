# stackabuse-springboot-mongo

## Controller
```
@PostMapping
@ResponseStatus(code=HttpStatus.CREATED)

@GetMapping("/{id}")

Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
```

## ResourceNotFoundException
```
public class ResourceNotFoundException extends RuntimeException
```
