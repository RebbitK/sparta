package 계산기;
import java.util.*;
public class 계산기 {
    public static  void main(String args[]){
        Scanner 스캔 = new Scanner(System.in);
        System.out.println("피연산자 2개를 입력해 주세요.");
        double 피연산자1 = 스캔.nextDouble();
        스캔.nextLine();
        double 피연산자2 = 스캔.nextDouble();
        스캔.nextLine();
        String 연산자;
        while (true){
            System.out.println("연산자를 입력해주세요.");
            연산자 = 스캔.nextLine();
            switch (연산자){
                case "+":
                    계산 더하기계산 = new 계산(new 더하기());
                    System.out.printf(피연산자1+" + "+피연산자2+"= "+더하기계산.계산(피연산자1,피연산자2));
                    break;
                case "-":
                    계산 빼기계산 = new 계산(new 빼기());
                    System.out.printf(피연산자1+" - "+피연산자2+"= "+빼기계산.계산(피연산자1,피연산자2));
                    break;
                case "*":
                    계산 곱하기계산 = new 계산(new 곱하기());
                    System.out.printf(피연산자1+" x "+피연산자2+"= "+곱하기계산.계산(피연산자1,피연산자2));
                    break;
                case "/":
                    계산 나누기계산 = new 계산(new 나누기());
                    System.out.printf(피연산자1+" / "+피연산자2+"= "+나누기계산.계산(피연산자1,피연산자2));
                    break;
                default:
                    System.out.println("잘못된 연산자 입니다.");
                    continue;
            }
            break;
        }
    }

}
