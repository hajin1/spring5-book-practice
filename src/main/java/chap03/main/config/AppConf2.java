package chap03.main.config;

import chap03.spring.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration 어노테이션을 붙여야 스프링 설정 클래스로 활용할 수 있다.
@Configuration
public class AppConf2 {

    // 스프링의 자동 주입 기능, 해당 타입의 빈을 찾아서 필드에 할당함
    @Autowired
    private MemberDao memberDao;
//    @Autowired
//    private MemberPrinter memberPrinter;

    private MemberPrinter memberPrinter = new MemberPrinter(); // 빈이 아님

    // 이 메서드가 생성한 객체를 스프링 빈으로 설정
    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService(memberDao);
    }

    @Bean
    public MemberListPrinter memberListPrinter() {
        MemberListPrinter memberListPrinter = new MemberListPrinter(memberDao, memberPrinter);
        return memberListPrinter;
    }

    @Bean MemberInfoPrinter memberInfoPrinter() {
        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
        // setter 메서드를 사용해서 의존 주입을 하지 않아도
        // 스프링 컨테이너가 @Autowired를 붙인 필드에 자동으로 해당 타입의 빈 객체를 주입함
//        memberInfoPrinter.setMemberDao(memberDao);
//        memberInfoPrinter.setPrinter(memberPrinter);
        return memberInfoPrinter;
    }

    @Bean
    public ChangePasswordService changePasswordService() {
        ChangePasswordService changePasswordService = new ChangePasswordService();
//        changePasswordService.setMemberDao(memberDao);
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
