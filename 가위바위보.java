import java.util.*;
public class 가위바위보 {
    public static void main(String[] args){
        Scanner 스캔 = new Scanner(System.in);
        System.out.println("A 입력: ");
        String A입력 = 스캔.nextLine();
        System.out.println("B 입력: ");
        String B입력 = 스캔.nextLine();
        if(Objects.equals(A입력,B입력)){
            // 만약 둘 이 같다면 if문 안에 있는 코드를 실행
            System.out.println("비겼습니다.");
        } else if (A입력=="가위") {
            //if가 False면 else if의 조건을 비교 참이면 실행
            if(B입력=="바위"){
                //if문 안에 if문 사용 가능
                System.out.println("B가 이겼습니다.");
            } else if (B입력=="보") {
                System.out.println("A가 이겼습니다.");
            }
            else{
                System.out.println("B가 올바르지 않은 것을 냈습니다.");
            }
        }
        else if (A입력=="바위"){
            if(B입력=="가위"){
                System.out.println("A가 이겼습니다.");
            } else if (B입력=="보") {
                System.out.println("B가 이겼습니다.");
            }
            else{
                System.out.println("B가 올바르지 않은 것을 냈습니다.");
            }
        }
        else if (A입력=="보"){
            if(B입력=="주먹"){
                System.out.println("A가 이겼습니다.");
            } else if (B입력=="가위") {
                System.out.println("B가 이겼습니다.");
            }
            else{
                System.out.println("B가 올바르지 않은 것을 냈습니다.");
            }
        }
        else{
            System.out.println("A가 올바르지 않은 것을 냈습니다.");
        }
    }
}
