package pro.sky.animal_shelter_by_nick.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Класс для обработки ошибки, если собака не найдена
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DogNotFoundException extends RuntimeException {

    public DogNotFoundException() {
        super("Dog is not found!");
    }
}
