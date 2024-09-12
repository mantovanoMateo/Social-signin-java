package com.oauth.user;

import com.oauth.httpClient.GoogleOauthClient;
import com.oauth.user.dto.AppleSiginInDto;
import com.oauth.user.dto.GoogleSignInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final GoogleOauthClient googleOauthClient;

    @PostMapping("/login/Google")
    public ResponseEntity<User> googleLogin(@RequestBody GoogleSignInDto googleSignInDto) throws IOException, InterruptedException {
        return this.userService.googleLogin(this.googleOauthClient.findGoogleOAuthUser(googleSignInDto.getToken()));
    }

    @PostMapping("/login/Apple")
    public ResponseEntity<User> appleLogin(@RequestBody AppleSiginInDto appleSiginInDto) {
        return this.userService.appleLogin(appleSiginInDto);
    }

}
