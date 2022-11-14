package pro.sky.animal_shelter_by_nick.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Класс для обработки ошибки, если пользователь кошки не найден
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonCatNotFoundException extends RuntimeException {

    public PersonCatNotFoundException() {
        super("PersonCat is not found!");
    }
}
