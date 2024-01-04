package soloproject_kiosk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class basket {
    int num = 1;
    double fullsum=0;
    ArrayList<product> buy_list = new ArrayList<>();
    ArrayList<product> sold_out = new ArrayList<>();
    public void add_buy(product pro){
        buy_list.add(pro);
    }
    public void view_buy(){
        Map<product,Integer> check = new HashMap<>();
        double sum=0;
        for(product p : buy_list){
            Integer count = check.get(p);
            if(count == null){
                check.put(p,1);
            }
            else{
                check.put(p,count+1);
            }
            sum += p.price;
        }
        for(product key : check.keySet()){
            System.out.printf(" %-25s | W%.1f | %d개 | %s \n",key.menu_name,key.price, check.get(key),key.menu_explanation);
        }
        System.out.printf("\n[ Total ] \n W%.1f\n\n",sum);
        System.out.println("1. 주문            2. 메뉴판");
    }
    public void buyok(){
        for(product p: buy_list){
            fullsum += p.price;
            sold_out.add(p);
        }
    }
    public void view_sold(){
        System.out.println("[ 총 판매상품 목록 현황 ] \n현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");
        for(product p : sold_out){
            System.out.printf("- %-25s| W %.1f\n",p.menu_name,p.price);
        }
        System.out.printf("[ 총 판매금액 현황 ] \n 현재까지 총 판매된 금액은 [ W %.1f ] 입니다.\n1. 돌아가기 \n",fullsum);

    }

}
