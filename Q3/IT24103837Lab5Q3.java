import java.util.Scanner;

public class IT24103837Lab5Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final double ROOM_CHARGE_PER_DAY = 48000.00;
        final double DISCOUNT_RATE_3_TO_4_DAYS = 0.10;
        final double DISCOUNT_RATE_5_OR_MORE_DAYS = 0.20;
        final int MIN_DAY = 1;
        final int MAX_DAY = 31;

        System.out.print("Enter Start Date (1-31): ");
        int startDate = input.nextInt();
        System.out.print("Enter End Date (1-31): ");
        int endDate = input.nextInt();

        if (startDate < MIN_DAY || startDate > MAX_DAY
                || endDate < MIN_DAY || endDate > MAX_DAY) {
            System.out.println("Error: Days must be between 1 and 31");
            input.close();
            return;
        }

        if (startDate >= endDate) {
            System.out.println("Error: Start Date must be less than End Date");
            input.close();
            return;
        }

        int daysReserved = endDate - startDate;
        double discountRate;
        if (daysReserved >= 5) {
            discountRate = DISCOUNT_RATE_5_OR_MORE_DAYS;
        } else if (daysReserved >= 3) {
            discountRate = DISCOUNT_RATE_3_TO_4_DAYS;
        } else {
            discountRate = 0.0;
        }

        double totalCharge = daysReserved * ROOM_CHARGE_PER_DAY;
        double totalAmount = totalCharge - totalCharge * discountRate;

        System.out.println();
        System.out.println("Room Charge Per Day: Rs. " + ROOM_CHARGE_PER_DAY + "/=");
        System.out.println("Number of Days Reserved: " + daysReserved);
        System.out.println("Total Amount to be Paid: " + totalAmount);

        input.close();
    }
}
