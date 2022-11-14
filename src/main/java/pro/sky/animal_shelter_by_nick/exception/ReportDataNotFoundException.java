package pro.sky.animal_shelter_by_nick.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Класс для обработки ошибки, если данные из отчета не найдены
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReportDataNotFoundException extends RuntimeException {

    public ReportDataNotFoundException() {
        super("Report is not found!");
    }
}
