package kemalkeskin.rent.business.rules.car;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import kemalkeskin.rent.core.utilities.exception.BusinessException;
import kemalkeskin.rent.dataAccess.abstracts.CarRepository;
import kemalkeskin.rent.entities.concretes.Car;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CarBusinessRules {
	
	private CarRepository carRepository;
	
	
	public void checkIfId(int id) {
		if(!this.carRepository.existsById(id)) {
			throw new BusinessException("dont avaliable id");
		}
	}
	
	
	public void checkIfPlate(String plate) {
		if(this.carRepository.existsByPlate(plate)) {
			throw new BusinessException("this plate avaliable");
		}
	}
	
	
	public void checkIfModelYear(int modelYear) {
		
		Car car= this.carRepository.findByModelYear(modelYear);
		
		if(car.getModelYear()<2000 || Calendar.YEAR<modelYear) {
			throw new BusinessException("model year must be between 2000 and current year");
		}
	}
	
	
	public void checkIfState(int state) {
		
		Car carState= this.carRepository.findByState(state);
		
		if(carState.getState()<=0 || carState.getState()>=4) {
			throw new BusinessException("The state range must be between 3 and 1");
		}
		
	}
	
	public void checkIfDailyPrice(double dailyPrice) {
		
		Car car=this.carRepository.existsByDailyPrice(dailyPrice);
		
		if(car.getDailyPrice()<500 || car.getDailyPrice()>3000) {
			throw new BusinessException("The state range must be between 3000 TL and 500 TL");
		}
	}

}
