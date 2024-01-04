package soloproject_kiosk;

public class product extends menu{
    double price;
    public product(String menu_name,String menu_explanation,double price){
        super(menu_name,menu_explanation);
        this.price = price;
    }

    @Override
    public void view_menu(){
        System.out.printf(" %-25s | W%.1f | %s \n",menu_name,price,menu_explanation);
    }
}
