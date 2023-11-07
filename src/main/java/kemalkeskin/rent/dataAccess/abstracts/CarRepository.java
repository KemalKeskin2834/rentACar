package kemalkeskin.rent.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.rent.entities.concretes.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
	
	boolean existsByPlate(String plate);
	
	Car findByModelYear(int modelYear);
	
	Car findByState(int State);
	
	Car existsByDailyPrice(double dailyPrice);

}
