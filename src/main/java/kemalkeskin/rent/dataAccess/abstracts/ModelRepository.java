package kemalkeskin.rent.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.rent.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

	
	boolean existsByName(String name);
}
