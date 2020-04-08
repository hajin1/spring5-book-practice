package chap03.main.config;

import chap03.spring.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration 어노테이션을 붙여야 스프링 설정 클래스로 활용할 수 있다.
@Configuration
public class AppConf1 {

    // 이 메서드가 생성한 객체를 스프링 빈으로 설정
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

}
