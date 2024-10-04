package md.zoom.config.mapping;

import md.kobalt.security.user.JwtUserDetails;
import md.zoom.model.dto.*;
import md.zoom.model.entity.*;
import md.zoom.model.entity.view.AccountViewEntity;
import md.zoom.model.input.MenuCategoryInput;
import md.zoom.model.input.MenuItemInput;
import md.zoom.model.input.RegisterRequestExtended;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
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

}
