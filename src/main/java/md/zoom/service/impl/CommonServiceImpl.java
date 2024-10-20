package md.zoom.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.kobalt.security.model.dto.PageParamDto;
import md.kobalt.security.repository.specifiaction.FilterCriteria;
import md.zoom.config.AppMapper;
import md.zoom.model.dto.LanguageDto;
import md.zoom.model.dto.MenuItemSizeDto;
import md.zoom.model.dto.MenuItemSizeShortDto;
import md.zoom.model.entity.MenuItemSizeEntity;
import md.zoom.model.input.MenuItemSizeInput;
import md.zoom.repository.LanguageRepository;
import md.zoom.repository.MenuItemSizeRepository;
import md.zoom.repository.spec.MenuItemSizeSpecification;
import md.zoom.service.CommonService;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommonServiceImpl implements CommonService {
    private final AppMapper appMapper;

    private final LanguageRepository languageRepository;
    private final MenuItemSizeRepository menuItemSizeRepository;


    @Override
    public List<LanguageDto> getLanguageList() {
        return languageRepository.findAll().stream().map(appMapper::map).toList();
    }

    @Override
    @Transactional
    public void addItemSize(MenuItemSizeInput menuItemSizeInput) {
        MenuItemSizeEntity menuItemSizeEntity = appMapper.map(menuItemSizeInput);
        menuItemSizeEntity.getLanguages().forEach(r ->
        {
            r.setMenuItemSize(menuItemSizeEntity);
        });
        menuItemSizeRepository.save(menuItemSizeEntity);
    }

    @Override
    public void updateItemSize(MenuItemSizeInput menuItemSizeInput) {

        MenuItemSizeEntity menuItemSize = menuItemSizeRepository.findById(menuItemSizeInput.getId()).orElseThrow();
        MenuItemSizeEntity menuItemSizeEntityNew = appMapper.map(menuItemSizeInput, menuItemSize);
        menuItemSizeEntityNew.getLanguages().forEach(r -> r.setMenuItemSize(menuItemSize));
        menuItemSizeRepository.save(menuItemSizeEntityNew);
    }

    @Override
    public Page<MenuItemSizeDto> getItemSizePage(PageParamDto pageParamDto) {
        Specification<MenuItemSizeEntity> masterSpec = null;
        for (FilterCriteria filterCriteria : pageParamDto.getCriteria())
            masterSpec = Specification.where(masterSpec).and(new MenuItemSizeSpecification(filterCriteria));

        Page<MenuItemSizeEntity> page = menuItemSizeRepository.findAll(masterSpec, pageParamDto.getPageRequest());
        Page<MenuItemSizeDto> pageDto = page.map(r -> {
            MenuItemSizeDto menuItemSizeDto = appMapper.map(r);
//            List<MenuItem> menuCategoryLanguageEntities = menuCategoryLanguageRepository.findByMenuCategoryId(r.getId());
//            menuCategoryDto.setLanguages(menuCategoryLanguageEntities.stream().map(appMapper::map).toList());
            return menuItemSizeDto;
        });
        return pageDto;
    }

    @Override
    public List<MenuItemSizeShortDto> getItemSizeList() {
        return menuItemSizeRepository.findAll().stream().map(appMapper::mapToShort).toList();
    }
}
