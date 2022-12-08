package com.example.allowcorsfromdatabase.config;

import com.example.allowcorsfromdatabase.entity.Cors;
import com.example.allowcorsfromdatabase.repository.CorsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.ORIGIN;

@Slf4j
@RequiredArgsConstructor

@Component
public class CorsFilter implements Filter {

    private final CorsRepository corsRepository;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String url = request.getHeader(ORIGIN);
        Optional<Cors> cors = corsRepository.findByUrl(url);
        log.info("Filter URL: {}", url);
        if (cors.isPresent() && cors.get().isAllowed()) {
            log.info("This request is allowed URL");
            HttpServletResponse response = (HttpServletResponse) resp;
            response.setHeader("Access-Control-Allow-Origin", request.getHeader(ORIGIN));
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS, GET, PUT, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
        }
        chain.doFilter(req, resp);
    }
}
