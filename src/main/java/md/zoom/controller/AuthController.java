package md.zoom.controller;

import lombok.AllArgsConstructor;
import md.kobalt.security.auth.AuthenticationRequest;
import md.kobalt.security.auth.AuthenticationResponse;
import md.zoom.model.input.RegisterRequestExtended;
import md.zoom.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "auth")
@RequestMapping("api/v1/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequestExtended request) {
        accountService.register(request);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(accountService.authenticate(request));
    }
}
