// package com.project.billing_software.config;

// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;

// @Component
// public class JwtFilter extends OncePerRequestFilter {

//     @Autowired
//     private JwtUtil jwtUtil;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//             throws ServletException, IOException {

//         String authorizationHeader = request.getHeader("Authorization");

//         String username = null;
//         String jwt = null;

//         if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//             jwt = authorizationHeader.substring(7);
//             username = jwtUtil.extractUsername(jwt);
//         }

//         if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             if (jwtUtil.validateToken(jwt, username)) {
//                 UsernamePasswordAuthenticationToken authToken = 
//                         new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
//                 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                 SecurityContextHolder.getContext().setAuthentication(authToken);
//             }
//         }

//         chain.doFilter(request, response);
//     }
// }