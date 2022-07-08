package com.example.jwt_tokens.message;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.jwt_tokens.appuser.AppUser;
import com.example.jwt_tokens.appuser.AppUserRepository;
import com.example.jwt_tokens.appuser.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final AppUserRepository appUserRepository;

    public String sendMessage(Long receiverId, String text, HttpServletRequest request) {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        String token = authorizationHeader.substring("Bearer ".length());

        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);

        String username = decodedJWT.getSubject();

        AppUser appUser = appUserRepository.findByUserName(username)
                .orElseThrow(() -> new IllegalStateException("Cannot define user that send message"));

        messageRepository.save(new Message(text, appUser.getId(), receiverId));

        return "Message sent";
    }
}
