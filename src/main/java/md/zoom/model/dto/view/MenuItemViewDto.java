package md.zoom.model.dto.view;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MenuItemViewDto {

    private Long id;

    private Long menuItemId;

    private String image;

    private Long menuCategoryId;

    private Double price;

    private Long menItemSizeId;

    private String menuItemSizeValue;

    private String menuItemLanguageValue;

    private String descriptions;

    private Long languageId;

    private String languageValue;
}
