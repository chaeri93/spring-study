package spring.core.singleton;

public class StatefulService {

    private int price; //상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
        this.price = price; // 여기가 문제!!
        // return price -> 로 해결
    }

    public int getPrice() {
        return price;
    }
}

// 공유 필드 조심 스프링 빈은 항상 무상태로 설계!!