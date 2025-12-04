package pw.fs_pw1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/cars")
public class CarController {
    private final CarRepo repo;

    public CarController(CarRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Car> GetAllCars(){
        return (List<Car>) repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> GetCar(@PathVariable Long id){
        return repo.findById(id);
    }
    @PostMapping
    public Car PostCar(@RequestBody Car car){
        return repo.save(car);
    }
    @PutMapping("/{id}")
    public Car UpdateCar(@PathVariable Long id, @RequestBody Car updatedCar){
        return repo.findById(id)
                .map(car -> {
                    car.setBrand(updatedCar.getBrand());
                    car.setModel(updatedCar.getModel());
                    car.setColor(updatedCar.getColor());
                    car.setRegistrationNumber(updatedCar.getRegistrationNumber());
                    car.setModelYear(updatedCar.getModelYear());
                    car.setPrice(updatedCar.getPrice());
                    return repo.save(car);
                })
                .orElseGet(() -> {
                    updatedCar.setId(id);
                    return repo.save(updatedCar);
                });
    }
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        repo.deleteById(id);
    }

}
