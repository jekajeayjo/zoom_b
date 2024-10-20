package md.zoom.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class MenuItemSizeDto {

    private Long id;

    private String value;

    private List<MenuItemSizeLanguageDto> languages;
}
