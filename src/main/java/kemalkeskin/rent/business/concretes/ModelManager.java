package kemalkeskin.rent.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kemalkeskin.rent.business.abstracts.ModelService;
import kemalkeskin.rent.business.request.model.CreateModelRequest;
import kemalkeskin.rent.business.request.model.UpdateModelRequest;
import kemalkeskin.rent.business.response.model.GetAllModelResponse;
import kemalkeskin.rent.business.response.model.GetByIdModelResponse;
import kemalkeskin.rent.business.rules.model.ModelBusinessRules;
import kemalkeskin.rent.core.utilities.mappers.ModelMapperService;
import kemalkeskin.rent.dataAccess.abstracts.ModelRepository;
import kemalkeskin.rent.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;

	private ModelMapperService modelMapperService;
	
	private ModelBusinessRules modelBusinessRules;

	@Override
	public List<GetAllModelResponse> getAll() {
		List<Model> models = this.modelRepository.findAll();
		List<GetAllModelResponse> getAllModelResponses = models.stream()
				.map(model -> this.modelMapperService.forResponse().map(model, GetAllModelResponse.class))
				.collect(Collectors.toList());
		return getAllModelResponses;
	}

	@Override
	public GetByIdModelResponse getById(int id) {
		
		this.modelBusinessRules.checkIfId(id);
		Model model=this.modelRepository.findById(id).get();
		GetByIdModelResponse getByIdModelResponse=this.modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
		return getByIdModelResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
	
		this.modelBusinessRules.checkIfModelName(createModelRequest.getName());
		Model model=this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		this.modelBusinessRules.checkIfId(updateModelRequest.getId());
		this.modelBusinessRules.checkIfModelName(updateModelRequest.getName());
		Model model=this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}

	@Override
	public void delete(int id) {
		this.modelBusinessRules.checkIfId(id);
		this.modelRepository.deleteById(id);
		
	}
}
