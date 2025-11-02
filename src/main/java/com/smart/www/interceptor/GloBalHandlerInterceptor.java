package com.smart.www.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class GloBalHandlerInterceptor implements HandlerInterceptor {

//    @Autowired
//    private JwtHelper jwtHelper;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader("token");
//        boolean expiration = jwtHelper.isExpiration(token);
//        if (!expiration){
//            //放行 没有过期
//            return true;
//        }
//        Result build = Result.build(null, ResultCodeEnum.NOTLOGIN);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writeValueAsString(request);
//        response.getWriter().print(s);
//        return false;
//    }
}
