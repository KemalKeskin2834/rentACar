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

import kemalkeskin.rent.business.abstracts.CarService;
import kemalkeskin.rent.business.request.car.CreateCarRequest;
import kemalkeskin.rent.business.request.car.UpdateCarRequest;
import kemalkeskin.rent.business.response.car.GetAllCarResponse;
import kemalkeskin.rent.business.response.car.GetByIdCarResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarControllers {
	
	private CarService carService;
	
	@GetMapping
	public List<GetAllCarResponse>getAll(){
		return carService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdCarResponse getById(@PathVariable int id) {
		return carService.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateCarRequest createCarRequest) {
		this.carService.add(createCarRequest);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateCarRequest updateCarRequest) {
		this.carService.update(updateCarRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.carService.delete(id);
	}
}
