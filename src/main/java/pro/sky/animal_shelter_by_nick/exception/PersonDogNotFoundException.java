package pro.sky.animal_shelter_by_nick.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Класс для обработки ошибки, если пользователь собаки не найден
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonDogNotFoundException extends RuntimeException {

    public PersonDogNotFoundException() {
        super("PersonDog is not found!");
    }
}
