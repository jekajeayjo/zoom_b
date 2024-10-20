package md.zoom.config;

import md.kobalt.security.user.JwtUserDetails;
import md.zoom.model.dto.*;
import md.zoom.model.dto.view.MenuCategoryViewDto;
import md.zoom.model.dto.view.MenuItemViewDto;
import md.zoom.model.entity.*;
import md.zoom.model.entity.view.AccountViewEntity;
import md.zoom.model.entity.view.MenuCategoryViewEntity;
import md.zoom.model.entity.view.MenuItemViewEntity;
import md.zoom.model.input.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.Arrays;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = {Arrays.class})
public interface AppMapper {

    @Mapping(target = "role", ignore = true)
    JwtUserDetails mapToDetails(AccountEntity obj);

    @Mapping(target = "role", source = "role.accountRoleName")
    AccountDto map(AccountEntity obj);

    AccountViewDto map(AccountViewEntity obj);

    AccountEntity map(RegisterRequestExtended input);

    MenuItemEntity map(MenuItemInput obj);

    MenuItemDto map(MenuItemEntity obj);

    @Mapping(target = "value", ignore = true)
    MenuItemEntity map(MenuItemInput input, @MappingTarget MenuItemEntity entity);

    MenuCategoryEntity map(MenuCategoryInput obj);

    MenuCategoryDto map(MenuCategoryEntity obj);

    MenuCategoryEntity map(MenuCategoryInput input, @MappingTarget MenuCategoryEntity entity);

    MenuCategoryLanguageDto map(MenuCategoryLanguageEntity obj);

    LanguageDto map(LanguageEntity obj);

    MenuItemLanguageDto map(MenuItemLanguageEntity obj);

    @Mapping(target = "menuItemSize.id", source = "menuItemSizeId")
    MenuItemSizeLanguageEntity map(MenuItemSizeLanguageInput obj);

    MenuItemSizeEntity map(MenuItemSizeInput obj);

    MenuItemSizeEntity map(MenuItemSizeInput obj, @MappingTarget MenuItemSizeEntity menuItemSizeEntity);

    MenuItemSizeDto map(MenuItemSizeEntity obj);

    MenuItemSizeShortDto mapToShort(MenuItemSizeEntity obj);

    MenuItemSizeLanguageDto map(MenuItemSizeLanguageEntity obj);

    MenuCategoryViewDto map(MenuCategoryViewEntity obj);

    MenuItemViewDto map(MenuItemViewEntity obj);

}
