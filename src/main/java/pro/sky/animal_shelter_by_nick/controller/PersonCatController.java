package pro.sky.animal_shelter_by_nick.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import pro.sky.animal_shelter_by_nick.model.PersonCat;
import pro.sky.animal_shelter_by_nick.service.PersonCatService;

import java.util.Collection;

/**
 * Контроллер для работы с пользователем кошки
 */
@RestController
@RequestMapping("person-cat")
public class PersonCatController {

    private final PersonCatService service;

    public PersonCatController(PersonCatService service) {
        this.service = service;
    }
    @Operation(summary = "Получение пользователя кошки по id")
    @GetMapping("{id}")
    public PersonCat getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @Operation(summary = "Создание пользователя кошки")
    @PostMapping()
    public PersonCat save(@RequestBody PersonCat personCat) {
        return service.create(personCat);
    }

    @Operation(summary = "Изменение данных пользователя кошки")
    @PutMapping
    public PersonCat update(@RequestBody PersonCat personCat) {
        return service.update(personCat);
    }
    @Operation(summary = "Удаление пользователей кошки по id")
    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id) {
        service.removeById(id);
    }

    @Operation(summary = "Просмотр всех пользователей кошки", description = "Просмотр всех пользователей кошки, либо определенного пользователя кошки по chat_id")
    @GetMapping("all")
    public Collection<PersonCat> getAll(@RequestParam(required = false) Long chatId) {
        if (chatId != null) {
            return service.getByChatId(chatId);
        }
        return service.getAll();
    }
}
