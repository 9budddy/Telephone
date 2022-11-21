import java.util.Scanner;

public class TelephoneDriver {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char[] charArr;
        boolean bool;

        System.out.println("Please enter a 10 digit/letter phone number.");
        do {
            try {
                charArr = getCharArr(scan);
                bool = isLetterOrDigit(charArr);
            } catch (PhoneNumberOutOfRangeException e) {
                System.out.println(e.getStackTraceString());
                System.out.println("Please re-enter a 10 digit/letter phone number.");
                charArr = new char[0];
                bool = false;
            }
        } while (!bool);


        int[] intArr = new int[charArr.length];
        for(int i = 0; i < charArr.length; i++) {
            int temp = convertLetterToDigit(charArr[i]);
            if (temp == -1) {
                temp = Integer.parseInt(String.valueOf(charArr[i]));
            }
            intArr[i] = temp;
        }


        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < intArr.length; i++) {
            if (i == 0) {
                stringBuilder.append("(");
            } else if (i == 6) {
                stringBuilder.append("-");
            }

            stringBuilder.append(intArr[i]);

            if (i == 2) {
                stringBuilder.append(") ");
            }
        }
        System.out.println(stringBuilder);
    }


    public static int convertLetterToDigit(Character letter) {
        return switch (Character.toUpperCase(letter)) {
            case 'A', 'B', 'C' -> 2;
            case 'D', 'E', 'F' -> 3;
            case 'G', 'H', 'I' -> 4;
            case 'J', 'K', 'L' -> 5;
            case 'M', 'N', 'O' -> 6;
            case 'P', 'Q', 'R', 'S' -> 7;
            case 'T', 'U', 'V' -> 8;
            case 'W', 'X', 'Y', 'Z' -> 9;
            default -> -1;
        };
    }

    public static char[] getCharArr(Scanner scan) {

        char[] charArr;
        String input = scan.nextLine();
        charArr = input.toCharArray();

        if (charArr.length != 10)
            throw new PhoneNumberOutOfRangeException();
        return charArr;
    }

    public static boolean isLetterOrDigit(char[] charArr) {
        for (char c : charArr) {
            if (!Character.isLetterOrDigit(c)) {
                throw new PhoneNumberOutOfRangeException();
            }
        }
        return true;
    }
}
