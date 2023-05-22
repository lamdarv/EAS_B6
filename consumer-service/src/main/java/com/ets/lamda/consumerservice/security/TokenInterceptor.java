package com.ets.lamda.consumerservice.security;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AccessTokenService accessTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            return true;
        }
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            Claims claims = accessTokenService.getClaims(token);
            request.setAttribute("userId", claims.get("userId"));
            request.setAttribute("userName", claims.getSubject());
            return true;
        } else {
            throw new UnauthorizedException("Authorization token is missing or invalid");
        }
    }

}
