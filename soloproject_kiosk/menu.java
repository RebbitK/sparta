package soloproject_kiosk;

public class menu {
    // 필수사항 메뉴클래스에 이름(menu_name)과 설명(menu_explanation)을 가지는 필드를 가지게 합니다.
    String menu_explanation,menu_name;

    //생성자로 메뉴이름과 메뉴설명을 받아와서 this.으로 필드에 넣습니다.
    public menu(String menu_name,String menu_explanation){
        this.menu_name = menu_name;
        this.menu_explanation =menu_explanation;
    }
    //받아온 이름과 설명을 print문으로 가공하여 출력시키는 view_menu()라는 메소드입니다.
    public void view_menu(){
        System.out.printf(" %-25s | %s \n",menu_name,menu_explanation);
    }
}
