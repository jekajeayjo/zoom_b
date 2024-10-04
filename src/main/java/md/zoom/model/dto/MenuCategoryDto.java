package md.zoom.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuCategoryDto {
    private Long id;

    private String value;

    private String image;

    private Boolean isEnabled;
    List<MenuCategoryLanguageDto> languages;
}
