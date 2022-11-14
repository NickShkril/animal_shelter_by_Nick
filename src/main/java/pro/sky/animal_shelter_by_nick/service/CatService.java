package pro.sky.animal_shelter_by_nick.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.animal_shelter_by_nick.exception.CatNotFoundException;
import pro.sky.animal_shelter_by_nick.model.Cat;
import pro.sky.animal_shelter_by_nick.repository.CatRepository;

import java.util.Collection;

/**
 * Сервис содержащий методы для работы с кошками
 */

@Service
public class CatService {

    private final CatRepository repository;

    private final Logger logger = LoggerFactory.getLogger(CatService.class);

    public CatService(CatRepository repository) {
        this.repository = repository;
    }
    // Получить кошку по id
    public Cat getById(Long id) {
        logger.info("Was invoked method to get a cat by id={}", id);
        return repository.findById(id).orElseThrow(CatNotFoundException::new);
    }
    // Создать кошку
    public Cat create(Cat cat) {
        logger.info("Was invoked method to create a cat");
        return repository.save(cat);
    }
    // Обновить кошку
    public Cat update(Cat cat) {
        logger.info("Was invoked method to update a cat");
        if (cat.getId() != null) {
            if (getById(cat.getId()) != null) {
                return repository.save(cat);
            }
        }
        throw new CatNotFoundException();
    }
    // Получить всех кошек
    public Collection<Cat> getAll() {
        logger.info("Was invoked method to get all cats");
        return repository.findAll();
    }
    // Удалить кошку по id
    public void removeById(Long id) {
        logger.info("Was invoked method to remove a cat by id={}", id);
        repository.deleteById(id);
    }
}
