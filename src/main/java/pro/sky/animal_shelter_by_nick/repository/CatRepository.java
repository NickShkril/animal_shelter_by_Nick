package pro.sky.animal_shelter_by_nick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.animal_shelter_by_nick.model.Cat;

/**
 * Репозиторий для работы с кошками
 */
@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
