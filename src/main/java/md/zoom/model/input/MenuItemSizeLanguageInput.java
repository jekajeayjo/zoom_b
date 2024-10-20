package md.zoom.model.input;

import lombok.Data;

@Data
public class MenuItemSizeLanguageInput {

    private Long id;

    private String value;

    private Long menuItemSizeId;

    private Long languageId;
}
