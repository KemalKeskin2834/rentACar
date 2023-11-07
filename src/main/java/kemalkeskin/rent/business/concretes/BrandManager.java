package kemalkeskin.rent.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kemalkeskin.rent.business.abstracts.BrandService;
import kemalkeskin.rent.business.request.brand.CreateBrandRequest;
import kemalkeskin.rent.business.request.brand.UpdateBrandRequest;
import kemalkeskin.rent.business.response.brand.GetAllBrandResponse;
import kemalkeskin.rent.business.response.brand.GetByIdBrandResponse;
import kemalkeskin.rent.business.rules.brand.BrandBusinessRules;
import kemalkeskin.rent.core.utilities.mappers.ModelMapperService;
import kemalkeskin.rent.dataAccess.abstracts.BrandRepository;
import kemalkeskin.rent.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;

	private ModelMapperService modelMapperService;
	
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandResponse> getAll() {
		List<Brand> brands = this.brandRepository.findAll();
		List<GetAllBrandResponse> getAllBrandResponses = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class))
				.collect(Collectors.toList());
		return getAllBrandResponses;
	}
	
	@Override
	public GetByIdBrandResponse getById(int id) {
		
		this.brandBusinessRules.checkIfId(id);
		Brand brand=this.brandRepository.findById(id).get();
		GetByIdBrandResponse getByIdBrandResponse= this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return getByIdBrandResponse;
	}


	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		this.brandBusinessRules.checkIfBrandName(createBrandRequest.getName());
		Brand brand=this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}


	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		
		this.brandBusinessRules.checkIfId(updateBrandRequest.getId());
		this.brandBusinessRules.checkIfBrandName(updateBrandRequest.getName());
		Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}

	@Override
	public void delete(int id) {
	
		this.brandBusinessRules.checkIfId(id);
		this.brandRepository.deleteById(id);
		
	}
}
