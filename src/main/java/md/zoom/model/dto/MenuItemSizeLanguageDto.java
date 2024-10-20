package md.zoom.model.dto;

import lombok.Data;
import lombok.ToString;
import md.zoom.model.entity.MenuItemSizeEntity;

@Data
@ToString
public class MenuItemSizeLanguageDto {

    private Long id;

    private String value;

    private Long languageId;
}
