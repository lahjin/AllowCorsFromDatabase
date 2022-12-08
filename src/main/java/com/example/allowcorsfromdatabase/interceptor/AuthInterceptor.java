package com.example.allowcorsfromdatabase.interceptor;

import com.example.allowcorsfromdatabase.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RequiredArgsConstructor

@Component
public class AuthInterceptor implements HandlerInterceptor {

    private final AppUserRepository appUserRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(AUTHORIZATION);
        log.info("This request token is {}", token);
        if (!appUserRepository.existsByToken(token)) {
            response.setStatus(NOT_FOUND.value());
            throw new RuntimeException("token is not exist");
        }
        return true;
    }
}
