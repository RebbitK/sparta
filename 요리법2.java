import java.util.*;

public class 요리법2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> 리스트 = new ArrayList<String>();
        Set<String> 세트 = new HashSet<String>();
        Map<Integer,String> 맵 = new TreeMap<Integer,String>();
        String 자료구조;
        while(true){
            System.out.println("저장할 자료구조를 입력해주세요.");
            자료구조 = sc.nextLine();
            switch (자료구조){
                case "Map","List","Set" :
                    break;
                default:
                    System.out.println("잘못된 자료구조 입니다.");
                    continue;
            }
            break;
        }
        System.out.println("요리 제목을 입력해 주세요.");
        String 제목 = sc.nextLine();
        System.out.println("레시피를 입력해 주세요.");
        switch (자료구조){
            case "List" :
                for(int i=0;i<10;i++){
                    리스트.add(sc.nextLine());
                }
                break;
            case "Set" :
                for(int i=0;i<10;i++){
                    세트.add(sc.nextLine());
                }
                break;
            case "Map" :
                for(int i=0;i<10;i++){
                    맵.put(i,sc.nextLine());
                }
                break;
        }
        System.out.println("[ "+자료구조+" 으로 저장된 "+제목+" ]");
        switch (자료구조){
            case "List":
                for(int i=0;i<10;i++){
                    System.out.println((i+1)+". "+리스트.get(i));
                }
                break;
            case "Set":
                int num = 1;
                for(String 내용 : 세트){
                    System.out.println(num+". "+내용);
                    num++;
                }
                break;
            case "Map":
                for(int i=0;i<10;i++){
                    System.out.println((i+1)+". "+맵.get(i));
                }
        }
    }
}