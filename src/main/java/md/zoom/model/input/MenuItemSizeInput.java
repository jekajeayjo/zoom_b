package md.zoom.model.input;

import lombok.Data;
import lombok.ToString;
import md.zoom.model.entity.MenuItemLanguageEntity;

import java.util.List;

@Data
public class MenuItemSizeInput {

    private Long id;

    private String value;

    private List<MenuItemSizeLanguageInput> languages;
}
