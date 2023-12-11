package kemalkeskin.rent.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kemalkeskin.rent.entities.concretes.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
