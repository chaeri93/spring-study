package spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
        // basePackages = "spring.core.member", // 탐색할 패키지 시작할 위치 지정
        // 지정하지 않으면 ComponentScan이 붙은 설정정보 클래스의 패키지가 시작위치 -> 설정정보 클래스의 위치를 프로젝트 최상단에 두기!!
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // @Component가 붙은 모든 클래스를 스프링 빈으로 등록
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository") // 수동등록 빈이 우선권 -> 오버라이딩
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
