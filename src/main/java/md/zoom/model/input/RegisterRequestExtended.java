package md.zoom.model.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import md.kobalt.security.auth.RegisterRequest;

@Getter
@Setter
@ToString
public class RegisterRequestExtended extends RegisterRequest {
    private String userName;
}
