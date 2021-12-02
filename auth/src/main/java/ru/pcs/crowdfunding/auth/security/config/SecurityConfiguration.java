package ru.pcs.crowdfunding.auth.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.pcs.crowdfunding.auth.repositories.AuthenticationInfosRepository;
import ru.pcs.crowdfunding.auth.repositories.AuthorizationInfosRepository;
import ru.pcs.crowdfunding.auth.security.filters.TokenAuthenticationFilter;
import ru.pcs.crowdfunding.auth.security.filters.TokenAuthorizationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    public static final String API = "/api";
    public static final String API_PING = API + "/ping";

    public static final String SIGN_UP_FILTER_PROCESSES_URL = API + "/signUp";
    public static final String SIGN_IN_FILTER_PROCESSES_URL = API + "/signIn";
    public static final String REFRESH_FILTER_PROCESSES_URL = API + "/refresh";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthenticationInfosRepository authenticationInfosRepository;

    @Autowired
    private AuthorizationInfosRepository authorizationInfosRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        TokenAuthenticationFilter tokenAuthenticationFilter = new TokenAuthenticationFilter(authenticationManagerBean(), objectMapper, authenticationInfosRepository, authorizationInfosRepository);
        tokenAuthenticationFilter.setFilterProcessesUrl("api/SignIn");
        http.authorizeRequests()
                .antMatchers(API_PING).permitAll()
                .antMatchers(SIGN_UP_FILTER_PROCESSES_URL).permitAll()
                .antMatchers(SIGN_IN_FILTER_PROCESSES_URL).permitAll()
                .antMatchers(REFRESH_FILTER_PROCESSES_URL).permitAll();

        http.addFilter(tokenAuthenticationFilter);
        http.addFilterBefore(new TokenAuthorizationFilter(authorizationInfosRepository, objectMapper),
                UsernamePasswordAuthenticationFilter.class);
    }
}
