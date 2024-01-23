package spring.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.core.discount.DiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

//    @Autowired private MemberRepository memberRepository; 필드 의존관계 주입, 외부에서 변경이 불가능해 되도록이면 사용X, 테스트나 config할때 사용
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired(required = false) 수정자 주입
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

//    @Autowired // 생성자에서 의존관계 주입, 생략 가능
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    } -> RequiredArgsConstructor 로 대체 가능!!!

//    @Autowired 일반 메서드 주입
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemprice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemprice);
        return new Order(memberId, itemName, itemprice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
