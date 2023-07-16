import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input;

        int vietnameseCharacterNumber;

        System.out.print("Nhập chuỗi chữ cái Latin: ");
        input = sc.nextLine();
        sc.close();

        if (filterInput(input)) {
            vietnameseCharacterNumber = countTelexVietnameseCharacters(input);
            System.out.println("Số lượng chữ cái Tiếng Việt theo kiểu gõ Telex trong chuỗi là: " + vietnameseCharacterNumber);
        } else {
            System.out.println("Nhập lại chuỗi");
        }

    }

    private static boolean filterInput(String input) {
        int i;

        for (i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i)) || Character.isWhitespace(input.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static int countTelexVietnameseCharacters(String input) {
        int count = 0;

        int i;

        for (i=0; i < input.length(); i++) {
            String str;
            if ((i + 2) > input.length()) {
                str = input.substring(i, i+1);
            } else {
                str = input.substring(i, i+2);
            }
            if (checkTelexVietnameseCharacters(str)) {
                count++;
                i++;
            }
        }

        return count;
    }

    private static boolean checkTelexVietnameseCharacters(String str) {
        return (str.compareTo("aw") == 0 || str.compareTo("aa") == 0 ||
                str.compareTo("dd") == 0 || str.compareTo("ee") == 0 ||
                str.compareTo("oo") == 0 || str.compareTo("ow") == 0 ||
                str.contains("w"));
    }

}
