package kemalkeskin.rent.business.abstracts;

import java.util.List;

import kemalkeskin.rent.business.request.brand.CreateBrandRequest;
import kemalkeskin.rent.business.request.brand.UpdateBrandRequest;
import kemalkeskin.rent.business.response.brand.GetAllBrandResponse;
import kemalkeskin.rent.business.response.brand.GetByIdBrandResponse;

public interface BrandService {

	List<GetAllBrandResponse>getAll();
	
	GetByIdBrandResponse getById(int id);
	
	void add(CreateBrandRequest createBrandRequest);
	
	void update(UpdateBrandRequest updateBrandRequest);
	
	void delete(int id);
}
