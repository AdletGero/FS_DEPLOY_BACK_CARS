package pw.fs_pw1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {
    List<Car> findByBrand(String brand);
    List<Car> findByColor(String color);
    List<Car> findByModelYear(int modelYear);
}
