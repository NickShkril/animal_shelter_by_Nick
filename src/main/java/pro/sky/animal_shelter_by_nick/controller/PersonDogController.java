package pro.sky.animal_shelter_by_nick.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import pro.sky.animal_shelter_by_nick.model.PersonDog;
import pro.sky.animal_shelter_by_nick.service.PersonDogService;

import java.util.Collection;
/**
 * Контроллер для работы с пользователем собаки
 */

@RestController
@RequestMapping("person-dog")
public class PersonDogController {

    private final PersonDogService service;

    public PersonDogController(PersonDogService service) {
        this.service = service;
    }

    @Operation(summary = "Получение пользователя по id")
    @GetMapping("{id}")
    public PersonDog getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Создание пользователя")
    @PostMapping
    public PersonDog save(@RequestBody PersonDog personDog) {
        return service.create(personDog);
    }

    @Operation(summary = "Изменение данных пользователя")
    @PutMapping
    public PersonDog update(@RequestBody PersonDog personDog) {
        return service.update(personDog);
    }

    @Operation(summary = "Удаление пользователей по id")
    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id) {
        service.removeById(id);
    }

    @Operation(summary = "Просмотр всех пользователей", description = "Просмотр всех пользователей, либо определенного пользователя по chat_id")
    @GetMapping("all")
    public Collection<PersonDog> getAll(@RequestParam(required = false) Long chatId) {
        if (chatId != null) {
            return service.getByChatId(chatId);
        }
        return service.getAll();
    }
}
