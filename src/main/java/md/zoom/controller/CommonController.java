package md.zoom.controller;

import lombok.AllArgsConstructor;
import md.zoom.model.dto.AccountViewDto;
import md.zoom.model.dto.LanguageDto;
import md.zoom.service.CommonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
