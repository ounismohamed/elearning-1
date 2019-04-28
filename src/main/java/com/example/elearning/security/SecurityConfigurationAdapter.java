
package com.example.elearning.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        /*auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select identifiant as principal, motdepasse as credentials true from apprenant" +
                        "where identifiant=?")
                .usersByUsernameQuery("select identifiant as principal, motdepasse as credentials true from formateur\" +\n" +
                        "                        \"where identifiant=?");*/

        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("user")).roles("USER")
                .and()
                .withUser("admin").password(encoder.encode("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//http.csrf().disable()
        http
                .authorizeRequests()
                .antMatchers("/", "/accueil","/apropos","/inscription","/inscriptionApprenant").permitAll()
                .antMatchers("/admin","adminApprenants","/adminFormateurs").hasAnyRole("ADMIN")
                .antMatchers("/catalogue").hasAnyRole("USER,ADMIN")
                /*.anyRequest().authenticated()*/
                .and()
                .formLogin()
                .loginPage("/identification")
                .permitAll()
                .defaultSuccessUrl("/accueil")
                .and()
                .logout()
                .logoutSuccessUrl("/identification")
                .permitAll();

    }


}
