import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("show Room   in Add   refer Guest   out Cancel   exist Exist");
            String input = scanner.next();
            String input_String = input;
            switch (input_String) {
                case "refer" :
                    System.out.println("Please enter the room number.");
                    int input_refer = scanner.nextInt();
                    hotel.refer(input_refer);
                    break;
                case "show" :
                    hotel.show();
                    break;
                case "in" :
                    System.out.println("Please enter the room number, name, phone and ID Card");
                    hotel.in();
                    break;
                case "out" :
                    System.out.println("Please exist room number.");
                    hotel.out();
                    break;
                case "exist" :
                    break;
                default :
                    System.out.println("ERROR! Please re-enter.");
            }
        }
    }
}
