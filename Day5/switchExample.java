public class switchExample {
    public static void main(String[] args) {
        char key = 'B';
        // w s a d

        switch (key) {
            case 'A':
                System.out.println("Move left");
                break;
            case 'D':
                System.out.println("Move Right");
                break;
            case 'W':
                System.out.println("Move Up");
                break;
            case 'S':
                System.out.println("Move Down");
                break;
            default:
                System.out.println("Wrong choice");
                break;
        }

    }
}
