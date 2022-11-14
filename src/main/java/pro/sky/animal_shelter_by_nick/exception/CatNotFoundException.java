package pro.sky.animal_shelter_by_nick.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Класс для обработки ошибки, если кошка не найдена
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CatNotFoundException extends RuntimeException {

    public CatNotFoundException() {
        super("Cat is not found!");
    }
}
