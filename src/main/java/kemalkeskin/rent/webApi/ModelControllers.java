package kemalkeskin.rent.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kemalkeskin.rent.business.abstracts.ModelService;
import kemalkeskin.rent.business.request.model.CreateModelRequest;
import kemalkeskin.rent.business.request.model.UpdateModelRequest;
import kemalkeskin.rent.business.response.model.GetAllModelResponse;
import kemalkeskin.rent.business.response.model.GetByIdModelResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelControllers {
	
	private ModelService modelService;
	
	
	@GetMapping	
	public List<GetAllModelResponse>getAll(){
		return modelService.getAll();
	}
	
	
	@GetMapping("/{id}")
	public GetByIdModelResponse getById(@PathVariable int id) {
		return this.modelService.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateModelRequest updateModelRequest) {
	 this.modelService.update(updateModelRequest);	
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.modelService.delete(id);
	}

}
