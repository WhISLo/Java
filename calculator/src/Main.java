import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String calc(String input) {
        String resString = "";
        int resInt = 0;
        boolean flagRomanInt1 = false;
        boolean flagRomanInt2 = false;
        int int1 = 0, int2 = 0;
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            resString = "throws Exception";
            return resString;
        }
        try {
            int1 = Integer.parseInt(parts[0]);
        }
        catch (NumberFormatException e) {
            flagRomanInt1 = true;
            switch (parts[0]) {
                case "I": int1 = 1; break;
                case "II": int1 = 2; break;
                case "III": int1 = 3; break;
                case "IV": int1 = 4; break;
                case "V": int1 = 5; break;
                case "VI": int1 = 6; break;
                case "VII": int1 = 7; break;
                case "VIII": int1 = 8; break;
                case "IX": int1 = 9; break;
                case "X": int1 = 10; break;
                default:
                    resString = "throws Exception";
            }
        }
        try {
            int2 = Integer.parseInt(parts[2]);
        }
        catch (NumberFormatException e) {
            flagRomanInt2 = true;
            switch (parts[2]) {
                case "I": int2 = 1; break;
                case "II": int2 = 2; break;
                case "III": int2 = 3; break;
                case "IV": int2 = 4; break;
                case "V": int2 = 5; break;
                case "VI": int2 = 6; break;
                case "VII": int2 = 7; break;
                case "VIII": int2 = 8; break;
                case "IX": int2 = 9; break;
                case "X": int2 = 10; break;
                default:
                    resString = "throws Exception";
            }
        }
        char operator = parts[1].charAt(0);
 //       if (flagRomanInt1 && flagRomanInt2) {
            switch (operator) {
                case '+':
                    resInt += int1 + int2;
                    break;
                case '-':
                    if ((flagRomanInt1 && flagRomanInt2) && int1 < int2) {
                        resString = "throws Exception";
                        break;
                    }
                    resInt += int1 - int2;
                    break;
                case '*':
                    resInt += int1 * int2;
                    break;
                case '/':
                    resInt += int1 / int2;
                    break;
                default:
                    resString = "throws Exception";
            }
            if ((flagRomanInt1 == true && flagRomanInt2 == false)||(flagRomanInt1 == false && flagRomanInt2 == true)){
            resString = "throws Exception";
        }
        if (flagRomanInt1 && flagRomanInt2){
                while (resInt != 0){
                    if (resInt == 100){
                        resString += 'C';
                    resInt -= 100;
                    return resString;
                    }
                    else if (resInt >= 90) {
                        resString += "XC";
                        resInt -= 90;
                    }
                    else if (resInt >= 50) {
                        resString += "L";
                        resInt -= 50;
                    }
                    else if (resInt >= 40) {
                        resString += "XL";
                        resInt -= 40;
                    }
                    else if (resInt >= 10) {
                        resString += "X";
                        resInt -= 10;
                    }
                    else if (resInt >= 9) {
                        resString += "IX";
                        resInt -= 9;
                    }
                    else if (resInt >= 5) {
                        resString += "V";
                        resInt -= 5;
                    }
                    else if (resInt >= 4) {
                        resString += "IV";
                        resInt -= 4;
                    }
                    else if (resInt >= 1) {
                        resString += "I";
                        resInt -= 1;
                    }
                }
            }
        else if (resString != "throws Exception") {
            resString += resInt;
        }
        return resString;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
}