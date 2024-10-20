package md.zoom.model.input;

import lombok.Data;

import java.util.List;

@Data
public class MenuItemInput {
    private Long id;
    private Long menuCategoryId;
    private String value;
    private Boolean isEnabled;
    private String image;
    private Long menuItemSizeId;

    private Double price;
    private Double size;
    private List<MenuItemLanguageInput> languages;
}
