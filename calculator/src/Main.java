import java.util.Scanner;

public class Main {
    public static String calc(String input) {
        String resString = "";
        int resInt = 0;
        boolean flagRomanInt1 = false;
        boolean flagRomanInt2 = false;
        int int1 = 0, int2 = 0;
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("throws Exception");
        }

        try {
            int1 = Integer.parseInt(parts[0]);
            if (int1 < 1 || int1 > 10) {
                throw new IllegalArgumentException("throws Exception");
            }
        } catch (NumberFormatException e) {
            flagRomanInt1 = true;
            int1 = romanToInt(parts[0]);
            if (int1 == -1) {
                throw new IllegalArgumentException("throws Exception");
            }
        }

        try {
            int2 = Integer.parseInt(parts[2]);
            if (int2 < 1 || int2 > 10) {
                throw new IllegalArgumentException("throws Exception");
            }
        } catch (NumberFormatException e) {
            flagRomanInt2 = true;
            int2 = romanToInt(parts[2]);
            if (int2 == -1) {
                throw new IllegalArgumentException("throws Exception");
            }
        }

        if (flagRomanInt1 != flagRomanInt2) {
            throw new IllegalArgumentException("throws Exception");
        }

        char operator = parts[1].charAt(0);
        switch (operator) {
            case '+':
                resInt = int1 + int2;
                break;
            case '-':
                if (flagRomanInt1 && int1 < int2) {
                    throw new IllegalArgumentException("throws Exception");
                }
                resInt = int1 - int2;
                break;
            case '*':
                resInt = int1 * int2;
                break;
            case '/':
                if (int2 == 0) {
                    throw new IllegalArgumentException("throws Exception");
                }
                resInt = int1 / int2;
                break;
            default:
                throw new IllegalArgumentException("throws Exception");
        }

        if (flagRomanInt1 && flagRomanInt2) {
            if (resInt < 1) {
                throw new IllegalArgumentException("throws Exception");
            }
            resString = intToRoman(resInt);
        } else {
            resString = Integer.toString(resInt);
        }

        return resString;
    }

    private static int romanToInt(String roman) {
        switch (roman) {
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
            default: return -1;
        }
    }

    private static String intToRoman(int number) {
        StringBuilder sb = new StringBuilder();
        while (number >= 100) {
            sb.append("C");
            number -= 100;
        }
        while (number >= 90) {
            sb.append("XC");
            number -= 90;
        }
        while (number >= 50) {
            sb.append("L");
            number -= 50;
        }
        while (number >= 40) {
            sb.append("XL");
            number -= 40;
        }
        while (number >= 10) {
            sb.append("X");
            number -= 10;
        }
        while (number >= 9) {
            sb.append("IX");
            number -= 9;
        }
        while (number >= 5) {
            sb.append("V");
            number -= 5;
        }
        while (number >= 4) {
            sb.append("IV");
            number -= 4;
        }
        while (number >= 1) {
            sb.append("I");
            number -= 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            System.out.println(calc(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
