package kemalkeskin.rent.business.abstracts;

import java.util.List;

import kemalkeskin.rent.business.request.model.CreateModelRequest;
import kemalkeskin.rent.business.request.model.UpdateModelRequest;
import kemalkeskin.rent.business.response.model.GetAllModelResponse;
import kemalkeskin.rent.business.response.model.GetByIdModelResponse;

public interface ModelService {

	List<GetAllModelResponse>getAll();
	
	GetByIdModelResponse getById(int id);
	
	void add(CreateModelRequest createModelRequest);
	
	void update(UpdateModelRequest updateModelRequest);
	 
	void delete(int id);
	
}
