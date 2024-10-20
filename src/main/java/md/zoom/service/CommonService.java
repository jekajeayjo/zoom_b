package md.zoom.service;

import md.kobalt.security.model.dto.PageParamDto;
import md.zoom.model.dto.LanguageDto;
import md.zoom.model.dto.MenuItemSizeDto;
import md.zoom.model.dto.MenuItemSizeShortDto;
import md.zoom.model.input.MenuItemSizeInput;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommonService {

    List<LanguageDto> getLanguageList();

    void addItemSize(MenuItemSizeInput menuItemSizeInput);

    void updateItemSize(MenuItemSizeInput menuItemSizeInput);

    Page<MenuItemSizeDto> getItemSizePage(PageParamDto pageParamDto);

    List<MenuItemSizeShortDto> getItemSizeList();
}
