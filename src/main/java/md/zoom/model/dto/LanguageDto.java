package md.zoom.model.dto;

import lombok.Data;

@Data
public class LanguageDto {

    private Long id;

    private String value;

    private String image;

    private Boolean isEnabled;
}
