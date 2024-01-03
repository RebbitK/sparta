package soloproject;

public class menu {
    String menu_explanation,menu_name;


    public menu(String menu_name,String menu_explanation){
        this.menu_name = menu_name;
        this.menu_explanation =menu_explanation;
    }
    public void view_menu(){
        System.out.printf(" %-25s | %s \n",menu_name,menu_explanation);
    }
}
