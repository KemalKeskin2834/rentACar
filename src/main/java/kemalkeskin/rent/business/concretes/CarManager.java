package kemalkeskin.rent.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kemalkeskin.rent.business.abstracts.CarService;
import kemalkeskin.rent.business.request.car.CreateCarRequest;
import kemalkeskin.rent.business.request.car.UpdateCarRequest;
import kemalkeskin.rent.business.response.car.GetAllCarResponse;
import kemalkeskin.rent.business.response.car.GetByIdCarResponse;
import kemalkeskin.rent.business.rules.car.CarBusinessRules;
import kemalkeskin.rent.core.utilities.mappers.ModelMapperService;
import kemalkeskin.rent.dataAccess.abstracts.CarRepository;
import kemalkeskin.rent.entities.concretes.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

	private CarRepository carRepository;

	private ModelMapperService modelMapperService;
	
	private CarBusinessRules carBusinessRules;

	@Override
	public List<GetAllCarResponse> getAll() {
		List<Car> cars = this.carRepository.findAll();
		List<GetAllCarResponse> getAllCarResponses = cars.stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarResponse.class))
				.collect(Collectors.toList());
		return getAllCarResponses;
	}

	@Override
	public GetByIdCarResponse getById(int id) {
	
		this.carBusinessRules.checkIfId(id);
		Car cars=this.carRepository.findById(id).get();
		GetByIdCarResponse getByIdCarResponse=this.modelMapperService.forResponse().map(cars, GetByIdCarResponse.class);
		return getByIdCarResponse;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		this.carBusinessRules.checkIfDailyPrice(createCarRequest.getDailyPrice());
		this.carBusinessRules.checkIfModelYear(createCarRequest.getModelYear());
		this.carBusinessRules.checkIfPlate(createCarRequest.getPlate());
		this.carBusinessRules.checkIfState(createCarRequest.getState());
		Car car=this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carRepository.save(car);
		
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		this.carBusinessRules.checkIfId(updateCarRequest.getId());
		this.carBusinessRules.checkIfDailyPrice(updateCarRequest.getDailyPrice());
		this.carBusinessRules.checkIfModelYear(updateCarRequest.getModelYear());
		this.carBusinessRules.checkIfPlate(updateCarRequest.getPlate());
		this.carBusinessRules.checkIfState(updateCarRequest.getState());
		Car carUpdate=this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carRepository.save(carUpdate);
		
		
	}

	@Override
	public void delete(int id) {
		this.carBusinessRules.checkIfId(id);
		this.carRepository.deleteById(id);
		
	}
}
