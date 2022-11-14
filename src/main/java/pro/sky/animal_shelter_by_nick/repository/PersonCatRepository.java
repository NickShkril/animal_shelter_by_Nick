package pro.sky.animal_shelter_by_nick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.animal_shelter_by_nick.model.PersonCat;

import java.util.Set;

/**
 * Репозиторий для работы с пользователем кошки
 */

public interface PersonCatRepository extends JpaRepository<PersonCat, Long> {
    Set<PersonCat> findByChatId(Long chatId);

}
