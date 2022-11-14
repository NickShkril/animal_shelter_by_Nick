package pro.sky.animal_shelter_by_nick.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.animal_shelter_by_nick.exception.DogNotFoundException;
import pro.sky.animal_shelter_by_nick.model.Dog;
import pro.sky.animal_shelter_by_nick.repository.DogRepository;

import java.util.Collection;

/**
 * Сервис содержащий методы для работы с собаками
 */
@Service
public class DogService {

    private final DogRepository repository;

    private final Logger logger = LoggerFactory.getLogger(DogService.class);

    public DogService(DogRepository dogRepository) {
        this.repository = dogRepository;
    }

    // Получить собаку по id
    public Dog getById(Long id) {
        logger.info("Was invoked method to get a dog by id={}", id);
        return repository.findById(id).orElseThrow(DogNotFoundException::new);
    }

    // Создать собаку
    public Dog create(Dog dog) {
        logger.info("Was invoked method to create a dog");
        return repository.save(dog);
    }

    // Обновить собаку
    public Dog update(Dog dog) {
        logger.info("Was invoked method to update a dog");
        if (dog.getId() != null) {
            if (getById(dog.getId()) != null) {
                return repository.save(dog);
            }
        }
        throw new DogNotFoundException();
    }

    // Удалить собаку по id
    public void removeById(Long id) {
        logger.info("Was invoked method to remove a cat by id={}", id);
        repository.deleteById(id);
    }

    // Получить всех собак
    public Collection<Dog> getAll() {
        logger.info("Was invoked method to get all dogs");
        return repository.findAll();
    }
}
