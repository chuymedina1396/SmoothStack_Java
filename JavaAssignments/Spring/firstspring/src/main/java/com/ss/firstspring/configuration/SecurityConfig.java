
// package com.ss.firstspring.configuration;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



// @Configuration
// @EnableWebMvc
// public class SecurityConfig extends WebMvcConfigurerAdapter {
//     //We provide the data source for users using the below config method
//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("adminpass")).roles("ADMIN").and().withUser("aki").password(passwordEncoder().encode("akipass")).roles("USER");
//     }
//     //We provide request authorization in the below method
   

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         //Below line will allow any authenticated user to access any resource within the system
//         http.authorizeRequests().antMatchers("/api/global").permitAll()
//                 .antMatchers("/api/public").hasAuthority("ACCESS_PUBLIC")
//                 .antMatchers("/api/private").hasAnyAuthority("ACCESS_PRIVATE")
//                 .and().httpBasic();
//     }
//     @Bean
//     public PasswordEncoder passwordEncoder(){
//         return  new BCryptPasswordEncoder();
//     }
// }