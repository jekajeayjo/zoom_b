package md.zoom.model.input;

import lombok.Data;

@Data
public class MenuItemLanguageInput {
    private Long id;
    private String value;
    private String descriptions;
    private Long languageId;
}
