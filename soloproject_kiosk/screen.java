package soloproject_kiosk;
import java.util.*;
import java.lang.*;
public class screen {
    Scanner sc = new Scanner(System.in);
    order_list li = new order_list();
    buy_order buy = new buy_order();
    int choose;
    //메인화면을 나타내는 while문으로 계속 돌면서 사용자의 입력에 따라 맞는 화면을 띄워주는 메소드로 이동시켜주는 메소드
    public void main_screen(){
        while (true) {
            title();
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
            System.out.println("[ McDonald's MENU ]");
            //메인 화면 인터페이스를 생성해주는 for문
            for (int i = 0; i < li.main.size(); i++) {
                if (i == 4)
                    System.out.println("\n[ ORDER MENU ]");
                System.out.print(i + 1 + ".");
                li.main.get(i).view_menu();
            }
            //사용자의 입력에 따라 번호에 맞는 메서드로 이동시켜줍니다.
            while (true) {
                error_check();
                switch (choose) {
                    case 0:
                        buy.view_sold();
                        while (true){
                            error_check();
                            if (choose==1){
                            }else{
                                System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
                                continue;
                            }
                            break;
                        }
                        break;
                    case 1,2,3,4:
                        food_screen(li.foods.get(choose));
                        break;
                    case 5:
                        if(buy.buy_list.isEmpty()){
                            System.out.println("장바구니가 비어있습니다.");
                            break;
                        }
                        buy.view_buy();
                        while (true){
                            error_check();
                            switch (choose) {
                                case 1:
                                    order_complete();
                                    break;
                                case 2:
                                    break;
                                default:
                                    System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
                                    continue;
                            }
                            break;
                        }
                        break;
                    case 6:
                        System.out.println("진행하던 주문을 취소하시겠습니까?");
                        System.out.println("1.확인          2.취소");
                        while (true){
                            error_check();
                            switch (choose){
                                case 1:
                                    System.out.println("주문이 취소되었습니다.");
                                    buy.buy_list.clear();
                                    break;
                                case 2:
                                    break;
                                default:
                                    System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
                                    continue;
                            }
                            break;
                        }
                }
                break;
            }
        }
    }
    //order_list클래스에서 받아온 리스트들을 바탕으로 화면에 각 카테고리에 맞는 인터페이스를 띄우주는 메소드
    public void food_screen(List<product> food){
        title();
        protitle();
        for(int i =0;i<food.size();i++){
            System.out.print(i+1+".");
            food.get(i).view_menu();
        }
        while (true) {
            error_check();
            if(0<choose&&choose<=food.size()){
                if(food==li.hamburger){
                    choose_set(food.get(choose-1),choose-1);
                    break;
                }
                else{
                    single_buy(food.get(choose-1));
                    break;
                }
            }
            else{
                System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
            }
        }
    }
    //주문이 완료되었을 때 인터페이스를 띄우주고 3초 딜레이를 주는 메소드
    public void order_complete(){
        buy.buyok();
        System.out.println("주문이 완료되었습니다! \n");
        System.out.printf("대기번호는 [ %d ] 번 입니다.\n",buy.num);
        System.out.println("(3초후 메뉴판으로 돌아갑니다.");
        buy.num++;
        // 3초딜레이를 주는 코드 그냥쓰면 sleep에서 오류가 발생하기 때문에 try-catch문으로 이를 회피합니다.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
    //옵션에 대한 메서드 햄버거를 주문했을 때 세트옵션을 선택하는 인터페이스가 뜨고 세트로 변경하면 가격을 증감하여 장바구니에 저장합니다.
    public void choose_set(product pro,int num){
        pro.view_menu();
        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        System.out.printf("1. single( W %.1f )        2. Set( W %.1f )\n",pro.price,pro.price+1.4);
        while (true){
            error_check();
            switch (choose){
                case 1:
                    single_buy(pro);
                    break;
                case 2:
                    li.hamburger_set.get(num).view_menu();
                    basket(li.hamburger_set.get(num));
                    break;
                default:
                    System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
                    continue;
            }
            break;
        }
    }
    public void single_buy(product pro){
        pro.view_menu();
        basket(pro);
    }
    //선택한 상품을 장바구니에 추가시키는 메서드
    public void basket(product pro){
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인          2. 취소");
        while (true){
            error_check();
            switch (choose){
                case 1:
                    buy.add_buy(pro);
                    System.out.printf("%s가 장바구니에 추가되었습니다. \n",pro.menu_name);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
                    continue;
            }
            break;
        }
    }
    //사용자의 입력을 받아오고 만약 입력이 int타입이 아니면 잘못된 값임을 알려주고 다시 입력받는 메서드
    public void error_check(){
        while (true) {
            try {
                choose = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
            }
        }
    }
    //고정멘트를 띄우주는 메서드들
    public void title(){
        System.out.println("맥도날드에 오신것을 환영합니다.");
    }
    public void protitle(){
        System.out.println("아래에 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
    }

}
