package md.zoom.service;

import md.kobalt.security.model.dto.PageParamDto;
import md.zoom.model.dto.MenuCategoryDto;
import md.zoom.model.dto.MenuItemDto;
import md.zoom.model.input.MenuCategoryInput;
import md.zoom.model.input.MenuItemInput;
import org.springframework.data.domain.Page;

public interface MenuService {
    Page<MenuCategoryDto> getAllCategory(PageParamDto pageParamDto);

    void addCategory(MenuCategoryInput menuCategoryInput);

    void updateCategory(MenuCategoryInput menuCategoryInput);

    Page<MenuItemDto> getAllItem(PageParamDto pageParamDto);

    void addItem(MenuItemInput menuCategoryInput);

    void updateItem(MenuItemInput menuCategoryInput);

}
