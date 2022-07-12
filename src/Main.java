import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner calc = new Scanner(System.in);

        System.out.println("Day of your birth: ");
        byte birthDay = calc.nextByte();
        System.out.println("Month of your birth: ");
        byte birthMonth = calc.nextByte();
        System.out.println("Year of your birth: ");
        short birthYear = calc.nextShort();

        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);

        System.out.println("Current date or other? (1 or 2): ");
        byte currentOrOther = calc.nextByte();
        if (currentOrOther == 1) {
            LocalDate now = LocalDate.now();
            printDate(birthDate, now);
        } else {
            System.out.println("Now day: ");
            byte nowDay = calc.nextByte();
            System.out.println("Now month: ");
            byte nowMonth = calc.nextByte();
            System.out.println("Now year: ");
            short nowYear = calc.nextShort();

            LocalDate other = LocalDate.of(nowYear, nowMonth, nowDay);
            printDate(birthDate, other);
        }
    }

    public static void printDate(LocalDate birthDay, LocalDate localDate) {
        int years = Period.between(birthDay, localDate).getYears();
        int months = Period.between(birthDay, localDate).getMonths();
        int days = Period.between(birthDay, localDate).getDays();

        System.out.println("Your age is " + years + " years " + months + " months " + days + " days!");
    }
}