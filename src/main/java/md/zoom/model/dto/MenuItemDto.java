package md.zoom.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuItemDto {
    private Long id;

    private Long menuCategoryId;

    private String value;
    private Boolean isEnabled;

    private String image;
    private List<MenuItemLanguageDto> languages;
}
