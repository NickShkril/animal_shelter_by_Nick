package pro.sky.animal_shelter_by_nick.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import pro.sky.animal_shelter_by_nick.model.Cat;
import pro.sky.animal_shelter_by_nick.service.CatService;

import java.util.Collection;

/**
 * Контроллер для работы с кошками
 */
@RestController
@RequestMapping("cat")
public class CatController {

    private final CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    @Operation(summary = "Получение кошки по id")
    @GetMapping("{id}")
    public Cat getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Создание кошки")
    @PostMapping()
    public Cat save(@RequestBody Cat cat) {
        return service.create(cat);
    }

    @Operation(summary = "Изменение данных у кошки")
    @PutMapping()
    public Cat update(@RequestBody Cat cat) {
        return service.update(cat);
    }

    @Operation(summary = "Удаление кошки по id")
    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id) {
        service.removeById(id);
    }

    @Operation(summary = "Просмотр всех кошек")
    @GetMapping("all")
    public Collection<Cat> getAll() {
        return service.getAll();
    }
}
