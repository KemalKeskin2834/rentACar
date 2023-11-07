package kemalkeskin.rent.business.rules.model;

import org.springframework.stereotype.Service;

import kemalkeskin.rent.core.utilities.exception.BusinessException;
import kemalkeskin.rent.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
	
	private ModelRepository modelRepository;
	
	
	public void checkIfId(int id) {
		if(!this.modelRepository.existsById(id)) {
			throw new BusinessException("this dont avaliable id");
		}
	}
	
	public void checkIfModelName(String name) {
		if(this.modelRepository.existsByName(name)) {
			throw new BusinessException("this name avaliable");
		}
	}

}
