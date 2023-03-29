package suhyun.core.order;

import suhyun.core.discount.DiscountPolicy;
import suhyun.core.discount.FixDiscountPolicy;
import suhyun.core.member.Member;
import suhyun.core.member.MemberRepository;
import suhyun.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
