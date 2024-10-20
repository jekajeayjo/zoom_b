package md.zoom.controller;

import lombok.AllArgsConstructor;
import md.kobalt.security.model.dto.PageParamDto;
import md.zoom.model.dto.MenuCategoryDto;
import md.zoom.model.dto.MenuItemDto;
import md.zoom.model.input.MenuCategoryInput;
import md.zoom.model.input.MenuItemInput;
import md.zoom.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "menu")
@RequestMapping("api/v1/menu")
@AllArgsConstructor
@CrossOrigin
public class MenuController {

    private final MenuService menuService;


    @PutMapping(value = "/category-page")
    public ResponseEntity<Page<MenuCategoryDto>> getAllCategory(@RequestBody PageParamDto pageParamDto) {
        return ResponseEntity.ok(menuService.getAllCategory(pageParamDto));
    }

    @PostMapping(value = "/category")
    public ResponseEntity<Void> addCategory(@RequestBody MenuCategoryInput menuCategoryInput) {
        menuService.addCategory(menuCategoryInput);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/category")
    public ResponseEntity<Void> updateCategory(@RequestBody MenuCategoryInput menuCategoryInput) {
        menuService.updateCategory(menuCategoryInput);
        return ResponseEntity.ok().build();
    }


    @PutMapping(value = "/item-page")
    public ResponseEntity<Page<MenuItemDto>> getAllItem(@RequestBody PageParamDto pageParamDto) {

        return ResponseEntity.ok(menuService.getAllItem(pageParamDto));
    }

    @PostMapping(value = "/item")
    public ResponseEntity<Void> addItem(@RequestBody MenuItemInput menuItemInput) {
        menuService.addItem(menuItemInput);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/item")
    public ResponseEntity<Void> updateItem(@RequestBody MenuItemInput menuItemInput) {
        menuService.updateItem(menuItemInput);
        return ResponseEntity.ok().build();
    }

}
