package com.oauth.user;

import com.oauth.httpClient.OAuthUserData;
import com.oauth.user.dto.AppleSiginInDto;
import com.oauth.user.dto.GoogleSignInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<User> googleLogin(OAuthUserData oAuthUserData) {
        Optional<User> userOptional = this.userRepository.findByEmail(oAuthUserData.email());
        if (userOptional.isEmpty()) {
            User newUser = new User(
                    oAuthUserData.email(),
                    oAuthUserData.family_name(),
                    oAuthUserData.given_name(),
                    oAuthUserData.name(),
                    oAuthUserData.picture(),
                    oAuthUserData.verified_email(),
                    true,
                    false
            );

            return ResponseEntity.ok().body(this.userRepository.save(newUser));
        }

        if (!userOptional.get().getIsGoogleUser()) {
            //User has allready registered by other method
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(userOptional.get());
    }

    public ResponseEntity<User> appleLogin(AppleSiginInDto appleSiginInDto) {
        Optional<User> userOptional = this.userRepository.findByEmail(appleSiginInDto.getEmail());
        if (userOptional.isEmpty()) {
            User newUser = new User(
                    appleSiginInDto.getEmail(),
                    appleSiginInDto.getLastname(),
                    appleSiginInDto.getName(),
                    appleSiginInDto.getName(),
                    null,
                    null,
                    false,
                    true
            );

            return ResponseEntity.ok().body(this.userRepository.save(newUser));
        }

        if (!userOptional.get().getIsAppleUser()) {
            //User has allready registered by other method
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(userOptional.get());
    }
}
