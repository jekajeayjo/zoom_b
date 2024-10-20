package md.zoom.model.dto.view;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MenuCategoryViewDto {

    private Long id;

    private Long menuCategoryId;

    private String value;

    private Long languageId;

    private String languageName;

}
