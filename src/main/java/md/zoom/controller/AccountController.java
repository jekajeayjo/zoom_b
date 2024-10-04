package md.zoom.controller;

import lombok.AllArgsConstructor;
import md.kobalt.security.model.dto.PageParamDto;
import md.zoom.model.dto.AccountDto;
import md.zoom.model.dto.AccountViewDto;
import md.zoom.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "account")
@RequestMapping("api/v1/account")
@AllArgsConstructor
@CrossOrigin
public class AccountController {

    private final AccountService accountService;

    @GetMapping(value = "/me")
    public ResponseEntity<AccountViewDto> getMyProfile() {
        return ResponseEntity.ok(accountService.getMyProfile());
    }

    //    @PreAuthorize("hasAuthority('Admin')")
//    @PutMapping(value = "/page")
//    public ResponseEntity<Page<AccountDto>> getAccounts(@RequestBody PageParamDto pageParamDto) {
//        return ResponseEntity.ok(accountService.accountsPage(pageParamDto));
//    }

    @PutMapping(value = "/page")
    public ResponseEntity<Page<AccountViewDto>> getAccounts(@RequestBody PageParamDto pageParamDto) {
        return ResponseEntity.ok(accountService.getAccountViewDtoPage(pageParamDto));
    }
}
