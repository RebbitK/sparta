package soloproject;
import java.util.InputMismatchException;
import java.util.Scanner;
public class screen {
    Scanner sc = new Scanner(System.in);
    menu_list li = new menu_list();
    order or = new order();
    int choose;

    public void main_screen(){
        while (true) {
            title();
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
            System.out.println("[ McDonald's MENU ]");
            for (int i = 0; i < li.main.size(); i++) {
                if (i == 4)
                    System.out.println("\n[ ORDER MENU ]");
                System.out.print(i + 1 + ".");
                li.main.get(i).view_menu();
            }
            while (true) {
                error_check();
                switch (choose) {
                    case 0:
                        or.view_sold();
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
                    case 1:
                        hamburger_screen();
                        break;
                    case 2:
                        dessert_screen();
                        break;
                    case 3:
                        side_screen();
                        break;
                    case 4:
                        drink_screen();
                        break;
                    case 5:
                        or.view_buy();
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
                                    or.fullsum = 0;
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
    public void hamburger_screen(){
        title();
        protitle();
        for(int i =0;i<li.hamburger.size();i++){
            System.out.print(i+1+".");
            li.hamburger.get(i).view_menu();
        }
        while (true) {
            error_check();
            if(0<choose&&choose<=li.hamburger.size()){
                choose_set(li.hamburger.get(choose-1));
                break;
            }
            else{
                System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
            }
        }
    }
    public void dessert_screen(){
        title();
        protitle();
        for(int i =0;i<li.dissert.size();i++){
            System.out.print(i+1+".");
            li.dissert.get(i).view_menu();
        }
        while (true) {
            error_check();
            if(0<choose&&choose<=li.dissert.size()){
                basket(li.dissert.get(choose-1));
                break;
            }
            else{
                System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
            }
        }
    }
    public void side_screen(){
        title();
        protitle();
        for(int i =0;i<li.side.size();i++){
            System.out.print(i+1+".");
            li.side.get(i).view_menu();
        }
        while (true) {
            error_check();
            if(0<choose&&choose<=li.side.size()){
                basket(li.dissert.get(choose-1));
                break;
            }
            else{
                System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
            }
        }
    }
    public void drink_screen(){
        title();
        protitle();
        for(int i =0;i<li.drink.size();i++){
            System.out.print(i+1+".");
            li.drink.get(i).view_menu();
        }
        while (true) {
            error_check();
            if(0<choose&&choose<=li.drink.size()){
                basket(li.dissert.get(choose-1));
                break;
            }
            else{
                System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
            }
        }
    }
    public void order_complete(){
        or.buyok();
        System.out.println("주문이 완료되었습니다! \n");
        System.out.printf("대기번호는 [ %d ] 번 입니다.\n",or.num);
        System.out.println("(3초후 메뉴판으로 돌아갑니다.");
        or.num++;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
    public void order_screen(){
        System.out.println("아래와 같이 주문 하시겠습니까? \n\n [ Orders]");

    }
    public void choose_set(product pro){
        pro.view_menu();
        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        System.out.printf("1. single( W %.1f )        2. Set( W %.1f )\n",pro.price,pro.price+1.4);
        while (true){
            error_check();
            switch (choose){
                case 1:
                    pro.view_menu();
                    basket(pro);
                    break;
                case 2:
                    pro.price += 1.4;
                    pro.view_menu();
                    basket(pro);
                    pro.price -=1.4;
                    break;
                default:
                    System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
                    continue;
            }
            break;
        }
    }
    public void basket(product pro){
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인          2. 취소");
        while (true){
            error_check();
            switch (choose){
                case 1:
                    or.add_buy(pro);
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
    public void error_check(){
        while (true) {
            try {
                choose = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해 주세요.");
                continue;
            }
        }
    }
    public void title(){
        System.out.println("맥도날드에 오신것을 환영합니다.");
    }
    public void protitle(){
        System.out.println("아래에 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
    }
}
