package kemalkeskin.rent.business.abstracts;

import java.util.List;

import kemalkeskin.rent.business.request.car.CreateCarRequest;
import kemalkeskin.rent.business.request.car.UpdateCarRequest;
import kemalkeskin.rent.business.response.car.GetAllCarResponse;
import kemalkeskin.rent.business.response.car.GetByIdCarResponse;

public interface CarService {

	List<GetAllCarResponse>getAll();
	
	GetByIdCarResponse getById(int id);
	
	void add(CreateCarRequest createCarRequest);
	
	void update(UpdateCarRequest updateCarRequest);
	
	void delete(int id);
}
