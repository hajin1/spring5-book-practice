package chap03.main.config;

import chap03.spring.*;
import org.springframework.beans.factory.annotation.Qualifier;
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
    // printer() 메서드로 정의한 빈의 한정자는 빈 이름인 "printer"가 됨
    public MemberPrinter printer() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("mprinter") // 해당 빈의 한정값으로 "mprinter"를 지정
    public MemberPrinter printer2() {
        return new MemberPrinter();
    }

}
