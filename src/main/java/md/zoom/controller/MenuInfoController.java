package md.zoom.controller;

import lombok.AllArgsConstructor;
import md.kobalt.security.model.dto.PageParamDto;
import md.zoom.model.dto.MenuCategoryDto;
import md.zoom.model.dto.MenuItemDto;
import md.zoom.model.dto.view.MenuCategoryViewDto;
import md.zoom.model.dto.view.MenuItemViewDto;
import md.zoom.model.input.MenuCategoryInput;
import md.zoom.model.input.MenuItemInput;
import md.zoom.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "menu-info")
@RequestMapping("api/v1/menu-info")
@AllArgsConstructor
@CrossOrigin
public class MenuInfoController {

    private final MenuService menuService;


    @PutMapping(value = "/category-page")
    public ResponseEntity<Page<MenuCategoryViewDto>> getAllCategoryInfo(@RequestBody PageParamDto pageParamDto) {
        return ResponseEntity.ok(menuService.getAllCategoryInfo(pageParamDto));
    }


    @PutMapping(value = "/item-page")
    public ResponseEntity<Page<MenuItemViewDto>> getAllItem(@RequestBody PageParamDto pageParamDto) {
        return ResponseEntity.ok(menuService.getAllItemInfo(pageParamDto));
    }
}
