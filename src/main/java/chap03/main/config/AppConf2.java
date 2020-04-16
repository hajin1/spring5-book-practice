package chap03.main.config;

import chap03.spring.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration 어노테이션을 붙여야 스프링 설정 클래스로 활용할 수 있다.
@Configuration
public class AppConf2 {

    // 이 메서드가 생성한 객체를 스프링 빈으로 설정
    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService();
    }

    @Bean
    public MemberListPrinter memberListPrinter() {
        MemberListPrinter memberListPrinter = new MemberListPrinter();
        return memberListPrinter;
    }

    @Bean
    MemberInfoPrinter memberInfoPrinter() {
        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
        return memberInfoPrinter;
    }

    @Bean
    public ChangePasswordService changePasswordService() {
        ChangePasswordService changePasswordService = new ChangePasswordService();
        return changePasswordService;
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }

}
