import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] 요리법 = new String[10];
        String 제목 = sc.nextLine();
        double 별점 = sc.nextDouble();
        sc.nextLine(); //개행문자 제거
        for(int i=0;i<10;i++){
            요리법[i] = sc.nextLine();
        }
        System.out.println("["+제목+"]");
        System.out.println("별점 : "+별점+" ("+별점*20+"%)");
        for(int i=0;i<10;i++){
            System.out.println((i+1)+". "+요리법[i]);
        }
    }
}