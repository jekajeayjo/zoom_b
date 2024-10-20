package md.zoom.controller;

import lombok.AllArgsConstructor;
import md.kobalt.security.model.dto.PageParamDto;
import md.zoom.model.dto.LanguageDto;
import md.zoom.model.dto.MenuItemSizeDto;
import md.zoom.model.dto.MenuItemSizeShortDto;
import md.zoom.model.input.MenuItemSizeInput;
import md.zoom.service.CommonService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "common")
@RequestMapping("api/v1/common")
@AllArgsConstructor
@CrossOrigin
public class CommonController {

    private final CommonService commonService;

    @GetMapping(value = "/language-list")
    public ResponseEntity<List<LanguageDto>> getLanguageList() {
        return ResponseEntity.ok(commonService.getLanguageList());
    }

    @PostMapping(value = "/item-size")
    public ResponseEntity<Void> addItemSize(@RequestBody MenuItemSizeInput menuItemSizeInput) {
        commonService.addItemSize(menuItemSizeInput);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/item-size")
    public ResponseEntity<Void> updateItemSize(@RequestBody MenuItemSizeInput menuItemSizeInput) {
        commonService.updateItemSize(menuItemSizeInput);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/item-size-page")
    public ResponseEntity<Page<MenuItemSizeDto>> getItemSizePage(@RequestBody PageParamDto pageParamDto) {
        return ResponseEntity.ok(commonService.getItemSizePage(pageParamDto));
    }

    @GetMapping(value = "/item-size-list")
    public ResponseEntity<List<MenuItemSizeShortDto>> getItemSizeList() {
        return ResponseEntity.ok(commonService.getItemSizeList());
    }
}
