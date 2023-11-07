package kemalkeskin.rent.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.rent.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
	boolean existsByName(String name);

}
