package main;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class rentalToolApp {
    // Map to store the tool information
    private static Map<String, Tool> tools = new HashMap<>();


    public static void main(String[] args) {

            makeTools();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Tool Code: ");
            String toolCode = scanner.nextLine().toUpperCase();


            Tool tool = tools.get(toolCode);
            if (tool == null) {
                System.out.println("Invalid tool code.");
                return;
            }

            System.out.print("Rental Day Count: ");
            int rentalDays = scanner.nextInt();

            if (rentalDays < 1) {
                System.out.println("Rental day count should be 1 or greater.");
                return;
            }

            System.out.print("Discount Percent: ");
            int discountPercent = scanner.nextInt();

            if (discountPercent < 0 || discountPercent > 100) {
                System.out.println("Discount percent should be between 0 and 100.");
                return;
            }

            System.out.print("Check Out Date (MM/dd/yyyy): ");
            String checkoutDateStr = scanner.next();

            scanner.close();

            LocalDate checkoutDate;
            try {
                checkoutDate = LocalDate.parse(checkoutDateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            } catch (DateTimeParseException p) {
                System.out.println("Invalid date format.");
                return;
            }
            RentalAgreement rentalAgreement = RentalAgreement.makeRentalAgreement(tool, rentalDays, discountPercent, checkoutDate);

            DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");


            System.out.println("\nHere is the Rental Agreement:\n");
            System.out.println("Tool Code: " + rentalAgreement.getToolCode());
            System.out.println("Tool Type: " + rentalAgreement.getToolType());
            System.out.println("Tool Brand: " + rentalAgreement.getToolBrand());
            System.out.println("Rental Days: " + rentalAgreement.getRentalDays());
            System.out.println("Check Out Date: " + rentalAgreement.getCheckoutDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
            System.out.println("Due Date: " + rentalAgreement.getDueDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
            System.out.println("Daily Rental Charge: $" + decimalFormat.format(rentalAgreement.getDailyRentalCharge()));
            System.out.println("Charge Days: " + rentalAgreement.getChargeDays());
            System.out.println("Pre-discount Charge: $" + decimalFormat.format(rentalAgreement.getPreDiscountCharge()));
            System.out.println("Discount Percent: " + rentalAgreement.getDiscountPercent() + "%");
            System.out.println("Discount Amount: $" + decimalFormat.format(rentalAgreement.getDiscountAmount()));
            System.out.println("Final Charge: $" + decimalFormat.format(rentalAgreement.getFinalCharge()));
        }




    public static void makeTools() {
        Tool tool1 = new Tool("CHNS", "Chainsaw", "Stihl", 1.49, false, true);
        Tool tool2 = new Tool("LADW", "Ladder", "Werner", 1.99, true, false);
        Tool tool3 = new Tool("JAKD", "Jackhammer", "DeWalt", 2.99, false, false);
        Tool tool4 = new Tool("JAKR", "Jackhammer", "Ridgid", 2.99, false, false);

        tools.put(tool1.getToolCode(), tool1);
        tools.put(tool2.getToolCode(), tool2);
        tools.put(tool3.getToolCode(), tool3);
        tools.put(tool4.getToolCode(), tool4);

    }

}
