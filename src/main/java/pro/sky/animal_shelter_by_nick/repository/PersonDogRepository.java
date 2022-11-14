package pro.sky.animal_shelter_by_nick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.animal_shelter_by_nick.model.PersonDog;

import java.util.Set;

/**
 * Репозиторий для работы с пользователем собаки
 */
@Repository
public interface PersonDogRepository extends JpaRepository<PersonDog, Long> {
    Set<PersonDog> findByChatId(Long chatId);

}
