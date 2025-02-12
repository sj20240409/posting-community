package com.myproject.postproject.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
class SecurityConfig  {


    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { auth ->
                auth
                    .anyRequest().permitAll()  // 모든 요청에 대해 접근 허용
            }
            .csrf { csrf ->
                csrf.disable()  // CSRF 보호 비활성화
            }
            .formLogin { formLogin ->
                formLogin.disable()  // 로그인 폼 비활성화
            }
            .httpBasic { httpBasic ->
                httpBasic.disable()  // 기본 HTTP 인증 비활성화
            }
            .logout { logout ->
                logout
                    .logoutUrl("/logout")  // 로그아웃 경로 설정
                    .logoutSuccessUrl("/login-page")  // 로그아웃 후 리다이렉트할 경로
                    .permitAll()  // 로그아웃 요청을 누구나 허용
            }

        return http.build()  // SecurityFilterChain 반환
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}