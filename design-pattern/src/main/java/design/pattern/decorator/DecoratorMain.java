package design.pattern.decorator;

import java.util.Scanner;

// 커피 제조 방법
// 에스프레소 : 커피의 기본
//
// 아메리카노 : 에스프레서 + 물
// 라페라떼 : 에스프레소 + 스팀밀크
// 헤이즐넛 : 아메리카노 + 헤이즐넛 시럽
//
// 카페모카 : 카페라떼 + 초콜릿
// 카라멜 마끼아또 : 카페라떼 + 카라멜 시럽
public class DecoratorMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        IBeverage beverage = new Base();
        boolean done = false;

        while(!done) {
            System.out.println("음료 현재 가격 : " + beverage.getTotalPrice());
            System.out.print("선택 : 1:샷 추가 / 2:우유 추가 : ");

            switch(sc.nextInt()) {
                case 0:
                    done = true;
                    break;
                case 1:
                    beverage = new Espresso(beverage);
                    break;
                case 2:
                    beverage = new Milk(beverage);
                    break;
            }
        }

        System.out.println("총 음료 가격 : " + beverage.getTotalPrice());
        sc.close();
    }
}
