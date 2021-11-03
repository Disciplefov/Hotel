import java.util.Scanner;

public class Hotel {
    Room [][] rooms = new Room[5][6];

    Hotel() {
        for (int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[i].length; j++) {
                rooms[i][j] = new Room((i + 1) * 1000 + j + 1);
            }
        }
    }

    public void show() {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j].room_num + "\t");
            }
            System.out.println();

            for (int j = 0; j < rooms[i].length; j++) {
                // Check if anybody living
                if (rooms[i][j].guest != null) {
                    System.out.print(rooms[i][j].guest.name + "\t");
                }
                else {
                    System.out.print(rooms[i][j].guest + "\t");
                }
            }
            System.out.println();
        }
    }

    //创建一个in方法，输入房间信息
    public void in() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int input_roomNum = scanner.nextInt();
            String input_guestName = scanner.next();
            String input_guestPhone = scanner.next();
            String input_guestIdCard = scanner.next();
            int i = input_roomNum / 1000 - 1;
            int j = input_roomNum % 10 - 1;
            if (rooms[i][j].guest != null) {
                System.out.println("Someone already lived in, please change to other room.");
            }
            else {
                rooms[i][j].guest = new Guest(input_guestName, input_guestPhone, input_guestIdCard);
                System.out.println("Book confirmed");
                break;
                }
            }
        }

        public void out() {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                int input_roomNum = scanner.nextInt();
                int i = input_roomNum / 1000 - 1;
                int j = input_roomNum % 10 - 1;
                if (rooms[i][j].guest != null) {
                    rooms[i][j].guest = new Guest(null, null, null);
                    System.out.println("Cancel successful");
                    break;
                }
                else {
                    System.out.println("Failed, Please re-enter.");
                }
            }
        }
        // Find the information of the room
        public void refer(int roomNum) {
            int i = roomNum / 1000 - 1;
            int j = roomNum % 10 - 1;
        if (rooms[i][j].guest != null) {
            System.out.println("Name : " + rooms[i][j].guest.name);
            System.out.println("Phone number : " + rooms[i][j].guest.phone);
            System.out.println("Id Card : " + rooms[i][j].guest.idCard);
        }
        else {
            System.out.println("The room is empty.");
        }
    }
}