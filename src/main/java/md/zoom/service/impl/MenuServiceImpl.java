package md.zoom.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.kobalt.security.model.dto.PageParamDto;
import md.kobalt.security.repository.specifiaction.FilterCriteria;
import md.zoom.config.mapping.AppMapper;
import md.zoom.model.dto.MenuCategoryDto;
import md.zoom.model.dto.MenuItemDto;
import md.zoom.model.entity.MenuCategoryEntity;
import md.zoom.model.entity.MenuCategoryLanguageEntity;
import md.zoom.model.entity.MenuItemEntity;
import md.zoom.model.entity.MenuItemLanguageEntity;
import md.zoom.model.input.MenuCategoryInput;
import md.zoom.model.input.MenuItemInput;
import md.zoom.repository.*;
import md.zoom.repository.spec.MenuCategorySpecification;
import md.zoom.repository.spec.MenuItemSpecification;
import md.zoom.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuServiceImpl implements MenuService {

    private final MenuCategoryRepository menuCategoryRepository;
    private final MenuItemRepository menuItemRepository;
    private final MenuCategoryLanguageRepository menuCategoryLanguageRepository;
    private final MenuItemLanguageRepository menuItemLanguageRepository;
    private final LanguageRepository languageRepository;
    private final AppMapper appMapper;


    @Override
    public Page<MenuCategoryDto> getAllCategory(PageParamDto pageParamDto) {
        Specification<MenuCategoryEntity> masterSpec = null;
        for (FilterCriteria filterCriteria : pageParamDto.getCriteria())
            masterSpec = Specification.where(masterSpec).and(new MenuCategorySpecification(filterCriteria));

        Page<MenuCategoryEntity> page = menuCategoryRepository.findAll(masterSpec, pageParamDto.getPageRequest());
        Page<MenuCategoryDto> pageDto = page.map(r -> {
            MenuCategoryDto menuCategoryDto = appMapper.map(r);
            List<MenuCategoryLanguageEntity> menuCategoryLanguageEntities = menuCategoryLanguageRepository.findByMenuCategoryId(r.getId());
            menuCategoryDto.setLanguages(menuCategoryLanguageEntities.stream().map(appMapper::map).toList());
            return menuCategoryDto;
        });
        return pageDto;
    }

    @Override
    public void addCategory(MenuCategoryInput menuCategoryInput) {
        MenuCategoryEntity menuCategoryEntity = appMapper.map(menuCategoryInput);

        List<MenuCategoryLanguageEntity> menuCategoryLanguageEntities = menuCategoryEntity.getLanguages();
        menuCategoryEntity.setLanguages(List.of());
        menuCategoryEntity = menuCategoryRepository.save(menuCategoryEntity);
        MenuCategoryEntity finalMenuCategoryEntity = menuCategoryEntity;
        menuCategoryLanguageEntities.forEach(menuCategoryLanguageEntity -> {
            menuCategoryLanguageEntity.setMenuCategoryId(finalMenuCategoryEntity.getId());
        });
        menuCategoryEntity.setLanguages(menuCategoryLanguageEntities);
        menuCategoryRepository.save(menuCategoryEntity);

    }

    @Override
    public void updateCategory(MenuCategoryInput menuCategoryInput) {
        MenuCategoryEntity menuCategoryEntity = menuCategoryRepository.findById(menuCategoryInput.getId()).orElseThrow();
        menuCategoryEntity = appMapper.map(menuCategoryInput, menuCategoryEntity);
        MenuCategoryEntity finalMenuCategoryEntity = menuCategoryEntity;
        menuCategoryEntity.getLanguages().forEach(menuCategoryLanguageEntity -> {
            menuCategoryLanguageEntity.setMenuCategoryId(finalMenuCategoryEntity.getId());
        });
        menuCategoryRepository.save(menuCategoryEntity);
    }

    @Override
    public Page<MenuItemDto> getAllItem(PageParamDto pageParamDto) {
        Specification<MenuItemEntity> masterSpec = null;
        for (FilterCriteria filterCriteria : pageParamDto.getCriteria())
            masterSpec = Specification.where(masterSpec).and(new MenuItemSpecification(filterCriteria));

        Page<MenuItemEntity> page = menuItemRepository.findAll(masterSpec, pageParamDto.getPageRequest());
        Page<MenuItemDto> pageDto = page.map(r -> {
            MenuItemDto menuItemDto = appMapper.map(r);
            List<MenuItemLanguageEntity> menuItemLanguageEntities = menuItemLanguageRepository.findByMenuItemId(r.getId());
            menuItemDto.setLanguages(menuItemLanguageEntities.stream().map(appMapper::map).toList());
            return menuItemDto;
        });
        return pageDto;
    }

    @Override
    public void addItem(MenuItemInput menuItemInput) {
        MenuItemEntity menuItemEntity = appMapper.map(menuItemInput);

        List<MenuItemLanguageEntity> menuItemLanguageEntities = menuItemEntity.getLanguages();
        menuItemEntity.setLanguages(List.of());
        menuItemEntity = menuItemRepository.save(menuItemEntity);
        MenuItemEntity finalMenuItemEntity = menuItemEntity;
        menuItemLanguageEntities.forEach(menuItemLanguageEntity -> {
            menuItemLanguageEntity.setMenuItemId(finalMenuItemEntity.getId());
        });
        menuItemEntity.setLanguages(menuItemLanguageEntities);
        menuItemRepository.save(menuItemEntity);
    }

    @Override
    public void updateItem(MenuItemInput menuItemInput) {
        MenuItemEntity menuItemEntity = menuItemRepository.findById(menuItemInput.getId()).orElseThrow();
        menuItemEntity = appMapper.map(menuItemInput, menuItemEntity);
        MenuItemEntity finalMenuItemEntity = menuItemEntity;
        menuItemEntity.getLanguages().forEach(menuItemLanguageEntity -> {
            menuItemLanguageEntity.setMenuItemId(finalMenuItemEntity.getId());
        });
        menuItemRepository.save(menuItemEntity);

    }

}
