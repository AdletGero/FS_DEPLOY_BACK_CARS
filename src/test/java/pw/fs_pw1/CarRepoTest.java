package pw.fs_pw1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class CarRepoTest {

    @Autowired
    private CarRepo repository;

    @Test
    void saveCar() {
        repository.save(new Car("Toyota", "Corolla", "Blue", "ABC-123", 2020, 15000));
        assertThat(repository.findAll()).isNotEmpty();
    }

    @Test
    void deleteCars() {
        repository.save(new Car("Honda", "Civic", "White", "XYZ-987", 2019, 18000));
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }
}
