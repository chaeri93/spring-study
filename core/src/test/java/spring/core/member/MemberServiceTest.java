package spring.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.core.Appconfig;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        Appconfig appconfig = new Appconfig();
        memberService = appconfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memnerA", Grade.VIP);

        //when
        memberService.join(member);
        Member findmember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findmember);
    }
}
