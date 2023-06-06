package HelloSpringBoot.config;

import HelloSpringBoot.service.implement.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;
import org.springframework.web.filter.CorsFilter;

import javax.sql.DataSource;

@EnableWebSecurity // 开启MVC Security安全支持
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource; // 2、JDBC身份认证
    @Autowired
    private UserDetailServiceImp userDetailServiceImp;


    // 设置身份验证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); // 加密器


        // 1、内存身份认证
        /*
        auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder).
                withUser("zw").password(bCryptPasswordEncoder.encode("123"))
                .roles("common")
                .and()
                .withUser("卡密尔").password(bCryptPasswordEncoder.encode("123")).roles("common");
        */
        // 2、JDBC身份认证
//        String userSql =  "select username,password,valid from t_customer " + "where username = ?";
//        String userauthoritySql = "select c.username,a.authority from t_customer c,t_authority a,"+
//                "t_customer_authority ca where ca.customer_id=c.id " +
//                "and ca.authority_id=a.id and c.username =?";
//        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder).
//                usersByUsernameQuery(userSql).authoritiesByUsernameQuery(userauthoritySql);

        // 3、userDetailService身份认证
        auth.userDetailsService(userDetailServiceImp).passwordEncoder(bCryptPasswordEncoder);

    }

    // 权限控制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        antMatchers("/").permitAll().
        http.authorizeRequests().
                antMatchers("/userLogin").permitAll().
                antMatchers("/login/**").permitAll()
//                antMatchers("/datail/common/**").hasAnyRole("student","teacher")
//                .antMatchers("/detail/vip/**").hasAnyRole("teacher")
                .antMatchers("/admin/**").hasAuthority("Admin")


                .anyRequest().authenticated(); //.and().formLogin();

        // 设置自定义登录页面
        http.formLogin().loginPage("/userLogin").usernameParameter("username").passwordParameter("passowrd")
                .defaultSuccessUrl("/").failureUrl("/userLogin?error");
        // 设置注销
        http.logout().logoutUrl("/mylogout").logoutSuccessUrl("/userLogin");

        // 记住我
        http.rememberMe().rememberMeParameter("remember-me").tokenValiditySeconds(30)
                .tokenRepository(tokenRepository());


//        关闭 csrf防护功能
//        http.csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/login/css/**", "/static/login/js/**");
    }

    @Bean
    public JdbcTokenRepositoryImpl tokenRepository(){
        JdbcTokenRepositoryImpl jr=new JdbcTokenRepositoryImpl();
        jr.setDataSource(dataSource);
        return jr;
    }
}
