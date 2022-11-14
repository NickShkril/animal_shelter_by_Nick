package pro.sky.animal_shelter_by_nick.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.animal_shelter_by_nick.exception.PersonCatNotFoundException;
import pro.sky.animal_shelter_by_nick.model.PersonCat;
import pro.sky.animal_shelter_by_nick.repository.PersonCatRepository;

import java.util.Collection;

/**
 * Сервис содержащий методы для работы с пользователями кошки
 */

@Service
public class PersonCatService {
    private final PersonCatRepository repository;

    private final Logger logger = LoggerFactory.getLogger(PersonCatService.class);

    public PersonCatService(PersonCatRepository repository) {
        this.repository = repository;
    }

    // Получить пользователя кошки по id
    public PersonCat getById(Long id) {
        logger.info("Was invoked method to get a personCat by id={}", id);
        return repository.findById(id).orElseThrow(PersonCatNotFoundException::new);
    }

    // Создать пользователя кошки по id
    public PersonCat create(PersonCat personCat) {
        logger.info("Was invoked method to create a personCat");
        return repository.save(personCat);
    }

    // Обновить пользователя кошки по id
    public PersonCat update(PersonCat personCat) {
        logger.info("Was invoked method to update a personCat");
        if (personCat.getId() != null) {
            if (getById(personCat.getId()) != null) {
                return repository.save(personCat);
            }
        }
        throw new PersonCatNotFoundException();
    }

    // Удалить пользователя кошки по id
    public void removeById(Long id) {
        logger.info("Was invoked method to remove a personCat by id={}", id);
        repository.deleteById(id);
    }

    // получить всех пользователей кошки
    public Collection<PersonCat> getAll() {
        logger.info("Was invoked method to get all personsCat");
        return repository.findAll();
    }

    // Получить пользователя кошки по chatId
    public Collection<PersonCat> getByChatId(Long chatId) {
        logger.info("Was invoked method to get a personsCat by chatId={}", chatId);
        return repository.findByChatId(chatId);
    }
}
