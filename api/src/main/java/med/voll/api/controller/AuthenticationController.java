package med.voll.api.controller;

import med.voll.api.domain.user.UserDataRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity authenticate(UserDataRecord userData){
        var token = new UsernamePasswordAuthenticationToken(userData.username(), userData.password());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
