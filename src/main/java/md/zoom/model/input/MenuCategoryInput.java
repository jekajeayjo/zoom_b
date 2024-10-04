package md.zoom.model.input;

import lombok.Data;

import java.util.List;

@Data
public class MenuCategoryInput {
    private Long id;

    private String image;
    private String value;

    private Boolean isEnabled;

    private List<MenuCategoryLanguageInput> languages;
}
