package md.zoom.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class MenuItemDto {
    private Long id;

    private Long menuCategoryId;

    private String value;
    private Boolean isEnabled;
    private Long menuItemSizeId;

    private Double price;
    private Double size;
    private String image;
    private List<MenuItemLanguageDto> languages;
}
