package kemalkeskin.rent.business.response.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarResponse {

	private int id;
	
	private String plate;
	
	private double dailyPrice;
	
	private int modelYear;
	
	private int state;
	
	private String modelName;
}
