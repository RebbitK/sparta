package soloproject_kiosk;

import java.util.ArrayList;
//product 객체를 받아와서 배열로 저장하는 역할 햄버거 같은 경우 세트는 가격에 +1.4를 해서 다른 주소에 저장
public class order_list {
    ArrayList<product> hamburger = new ArrayList<>();
    ArrayList<product> dissert = new ArrayList<>();
    ArrayList<product> side = new ArrayList<>();
    ArrayList<product> drink = new ArrayList<>();
    ArrayList<menu> main = new ArrayList<>();
    ArrayList<product> hamburger_set = new ArrayList<>();

    public order_list(){
        hamburger.add(new product("Big Mac","맥도날드 하면 가장 먼저 떠올리게 되는 대표적인 제품",5.5));
        hamburger.add(new product("McCrispy Shanghai Burger","겉은 바삭, 속은 부드러운 치킨 패티의 매콤함으로 입맛도 기분도 화끈하게!",5.5));
        hamburger.add(new product("1955 Burger","1955년 당시의 맛을 다시한번 재탄생!",5.5));
        hamburger.add(new product("Quarter Pounder Cheese","세계적으로 사랑받고 있는 맥도날드의 대표적인 프리미엄 버거",5.5));
        hamburger.add(new product("Bulgogi Burger","한국인의 입맛에 딱 맞는 불고기 소스에 잘 재운 패티의 조합!",3.1));
        dissert.add(new product("Taro Pie","달콤한 보랏빛 디저트!",1.8));
        dissert.add(new product("Oreo McFlurry","우유 듬뿍 신선한 아이스크림에 아삭아삭 오레오 쿠키가 가득!",3.3));
        dissert.add(new product("Ice Cream Cone","신선한 우유로 만든 부드러운 아이스크림 콘.",1.1));
        dissert.add(new product("Chocolate Sundae","신선한 우유로 만든 아이스크림에 달콤한 초콜렛 시럽이 입안 가득.",2.3));
        side.add(new product("Tomato Chicken Snack Wrap","상큼한 토마토와 바삭한 치킨의 조합!",3.0));
        side.add(new product("Coleslaw","크리미한 마요 드레싱과 여러 야채가 어우러져 아삭하게 씹히는 샐러드",1.9));
        side.add(new product("French Fries","맥도날드의 역사가 담긴 월드 클래스 후렌치 후라이",2.2));
        side.add(new product("McNuggets","바삭하고 촉촉한 치킨이 한 입에 쏙!",3.8));
        drink.add(new product("Coca-Cola","갈증해소 뿐만이 아니라 기분까지 상쾌하게! 코카-콜라",1.7));
        drink.add(new product("Sprite","청량함에 레몬, 라임향을 더한 시원함!",1.7));
        drink.add(new product("Fanta","톡 쏘는 오렌지 향!",1.7));
        main.add(new menu("Burgers","주문 즉시 바로 조리해 더욱 맛있는, 맥도날드의 다양한 버거"));
        main.add(new menu("Dessert","가볍게 즐길 수 있는 디저트 메뉴!"));
        main.add(new menu("Side","버거와 함께 푸짐하게 즐기는 사이드 메뉴"));
        main.add(new menu("Drink","언제나 즐겁게, 다양한 음료를 부담없이 즐기세요!"));
        main.add(new menu("Order","장바구니를 확인 후 주문합니다."));
        main.add(new menu("Cancel","진행중인 주문을 취소합니다."));
        for(product p: hamburger){
            hamburger_set.add(new product(p.menu_name+" set", p.menu_explanation, p.price+1.4));
        }
    }
}
