package pro.sky.animal_shelter_by_nick.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.animal_shelter_by_nick.exception.PersonDogNotFoundException;
import pro.sky.animal_shelter_by_nick.model.PersonDog;
import pro.sky.animal_shelter_by_nick.repository.PersonDogRepository;

import java.util.Collection;

/**
 * Сервис содержащий методы для работы с пользователями собаки
 */
@Service
public class PersonDogService {

    private final PersonDogRepository repository;

    private final Logger logger = LoggerFactory.getLogger(PersonDogService.class);

    public PersonDogService(PersonDogRepository repository) {
        this.repository = repository;
    }

    // Получить пользователя собаки по id
    public PersonDog getById(Long id) {
        logger.info("Was invoked method to get a personDog by id={}", id);
        return repository.findById(id).orElseThrow(PersonDogNotFoundException::new);
    }

    // Создать пользователя собаки
    public PersonDog create(PersonDog personDog) {
        logger.info("Was invoked method to create a personDog");
        return repository.save(personDog);
    }

    // Обновить пользователя собаки
    public PersonDog update(PersonDog personDog) {
        logger.info("Was invoked method to update a personDog");
        if (personDog.getId() != null) {
            if (getById(personDog.getId()) != null) {
                return repository.save(personDog);
            }
        }
        throw new PersonDogNotFoundException();
    }

    // Удалить пользователя собаки по id
    public void removeById(Long id) {
        logger.info("Was invoked method to remove a personDog by id={}", id);
        repository.deleteById(id);
    }

    //Получить всех пользователей собаки
    public Collection<PersonDog> getAll() {
        logger.info("Was invoked method to get all personsDod");
        return repository.findAll();
    }

    // Получить пользователя собаки по chatId
    public Collection<PersonDog> getByChatId(Long chatId) {
        logger.info("Was invoked method to get a personsDog by chatId={}", chatId);
        return repository.findByChatId(chatId);
    }
}
