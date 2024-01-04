package soloproject_kiosk;
//필수사항 상품클래스는 메뉴이름,설명,가격의 필드를 가지며, 이중 메뉴이름,설명은 메뉴클래스에서 상속받아야합니다.
public class product extends menu{
    double price;
    //생성자로 상속받은 메뉴이름,설명을 super()를 이용해서 받아오고 price는 this를 사용하여 받아옵니다.
    public product(String menu_name,String menu_explanation,double price){
        super(menu_name,menu_explanation);
        this.price = price;
    }

    // menu클래스에 있었던 view_menu를 override 하여 이름,설명,값에 대한 정보를 print문으로 가공한 메소드입니다.
    @Override
    public void view_menu(){
        System.out.printf(" %-30s | W%.1f | %s \n",menu_name,price,menu_explanation);
    }
}
