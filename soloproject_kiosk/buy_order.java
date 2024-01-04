package soloproject_kiosk;

import java.util.*;

public class buy_order {
    int num = 1; // 대기번호
    double fullsum=0; //총 매출
    ArrayList<product> buy_list = new ArrayList<>(); //장바구니안 상품 리스트
    ArrayList<product> sold_out = new ArrayList<>(); //판매한 상품 리스트
//구매목록에 상품을 추가시켜주는 메서드
    public void add_buy(product pro) {
        buy_list.add(pro);
    }
//구매목록에 삼품에 대한 인터페이스를 띄워주는 메서드
    public void view_buy() {
        Map<product,Integer> shopping_basket = new LinkedHashMap<>();
        double sum = 0;
        for(product p:buy_list){
            sum += p.price;
            shopping_basket.put(p,shopping_basket.getOrDefault(p,0)+1);
        }
        System.out.println("아래와 같이 주문 하시겠습니까? \n\n[ Orders ]");
        for(product key: shopping_basket.keySet()){
            System.out.printf(" %-30s | W%.1f | %d개 | %s \n", key.menu_name, key.price, shopping_basket.get(key), key.menu_explanation);
        }
        System.out.printf("\n[ Total ] \n W%.1f\n\n", sum);
        System.out.println("1. 주문            2. 메뉴판");

    }
    //구매 했을 때 장바구니 리스트 안에 있는 내용을 판매 리스트에 저장하고 총 판매금액에 더하며 장바구니를 비우는 메소드
    public void buyok(){
        for(product p: buy_list){
            fullsum += p.price;
            sold_out.add(p);
        }
        buy_list.clear();
    }
    //현재까지 판매된 금액과 상품을 띄워주는 메소드
    public void view_sold(){
        System.out.println("[ 총 판매상품 목록 현황 ] \n현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");
        for(product p : sold_out){
            System.out.printf("- %-25s| W %.1f\n",p.menu_name,p.price);
        }
        System.out.printf("[ 총 판매금액 현황 ] \n 현재까지 총 판매된 금액은 [ W %.1f ] 입니다.\n1. 돌아가기 \n",fullsum);

    }

}
