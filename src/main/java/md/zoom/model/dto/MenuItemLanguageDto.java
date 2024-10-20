package md.zoom.model.dto;

import lombok.Data;

@Data
public class MenuItemLanguageDto {
    private Long id;

    private Long languageId;

    private String descriptions;

    private String value;
}
