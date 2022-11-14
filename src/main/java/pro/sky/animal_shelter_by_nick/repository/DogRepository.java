package pro.sky.animal_shelter_by_nick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.animal_shelter_by_nick.model.Dog;

/**
 * Репозиторий для работы с собаками
 */
@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {


}
