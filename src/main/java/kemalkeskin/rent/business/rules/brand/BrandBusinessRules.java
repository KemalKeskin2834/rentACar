package kemalkeskin.rent.business.rules.brand;

import org.springframework.stereotype.Service;

import kemalkeskin.rent.core.utilities.exception.BusinessException;
import kemalkeskin.rent.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	
	private BrandRepository brandRepository;
	
	
	public void checkIfId(int id) {
		
		if(!brandRepository.existsById(id)) {
			throw new BusinessException("dont avaliable id");
		}
	}
	
	public void checkIfBrandName(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("this name avaliable");
		}
	}
	

}
