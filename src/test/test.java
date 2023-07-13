package test;

import main.RentalAgreement;
import main.Tool;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;


public class test {



    @Test
    public void test1() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
        decimalFormat.setGroupingSize(3);

        int rentalDays =5;
        //Manually entering the charge days because if i use the same logic and the logic is flawed it would pass the test
        int chargeDays = 2;
        int discountPercent = 101;
        LocalDate checkoutDate = LocalDate.of(2015, 9, 03);
        Tool tool4 = new Tool("JAKR", "Jackhammer", "Ridgid", 2.99, false, false);
        RentalAgreement rentalAgreement = RentalAgreement.makeRentalAgreement(tool4, rentalDays, discountPercent, checkoutDate);

        double preDiscountCharge = chargeDays * tool4.getDailyRentalCharge();
        double discountAmount = preDiscountCharge * discountPercent / 100;
        double finalCharge = preDiscountCharge - discountAmount;

        assertEquals("Tool Code: " + tool4.getToolCode(),"Tool Code: " + rentalAgreement.getToolCode());
        assertEquals("Tool Type: " + tool4.getToolType(),"Tool Type: " + rentalAgreement.getToolType());
        assertEquals("Tool Brand: " + tool4.getBrand(),"Tool Brand: " + rentalAgreement.getToolBrand());
        assertEquals("Rental Days: " + rentalDays,"Rental Days: " + rentalAgreement.getRentalDays());
        assertEquals("Check Out Date: " + checkoutDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),"Check Out Date: " + rentalAgreement.getCheckoutDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        assertEquals("Due Date: " + checkoutDate.plusDays(rentalDays).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),"Due Date: " + rentalAgreement.getDueDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        assertEquals("Daily Rental Charge: $" + tool4.getDailyRentalCharge(),"Daily Rental Charge: $" + decimalFormat.format(rentalAgreement.getDailyRentalCharge()));
        assertEquals("Charge Days: " + chargeDays,"Charge Days: " + rentalAgreement.getChargeDays());
        assertEquals("Pre-discount Charge: $" + preDiscountCharge,"Pre-discount Charge: $" + decimalFormat.format(rentalAgreement.getPreDiscountCharge()));
        assertEquals("Discount Percent: " + discountPercent + "%","Discount Percent: " + rentalAgreement.getDiscountPercent() + "%");
        assertEquals("Discount Amount: $" + decimalFormat.format(discountAmount),"Discount Amount: $" + decimalFormat.format(rentalAgreement.getDiscountAmount()));
        assertEquals("Final Charge: $" + decimalFormat.format(finalCharge),"Final Charge: $" + decimalFormat.format(rentalAgreement.getFinalCharge()));

    }

    @Test
    public void test2() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");

        int rentalDays =3;
        int chargeDays = 2;
        int discountPercent = 10;
        LocalDate checkoutDate = LocalDate.of(2020, 07, 02);
        Tool tool2 = new Tool("LADW", "Ladder", "Werner", 1.99, true, false);
        RentalAgreement rentalAgreement = RentalAgreement.makeRentalAgreement(tool2, rentalDays, discountPercent, checkoutDate);

        double preDiscountCharge = chargeDays * tool2.getDailyRentalCharge();
        double discountAmount = preDiscountCharge * discountPercent / 100;
        double finalCharge = preDiscountCharge - discountAmount;

        assertEquals("Tool Code: " + tool2.getToolCode(),"Tool Code: " + rentalAgreement.getToolCode());
        assertEquals("Tool Type: " + tool2.getToolType(),"Tool Type: " + rentalAgreement.getToolType());
        assertEquals("Tool Brand: " + tool2.getBrand(),"Tool Brand: " + rentalAgreement.getToolBrand());
        assertEquals("Rental Days: " + rentalDays,"Rental Days: " + rentalAgreement.getRentalDays());
        assertEquals("Check Out Date: " + checkoutDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),"Check Out Date: " + rentalAgreement.getCheckoutDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        assertEquals("Due Date: " + checkoutDate.plusDays(rentalDays).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),"Due Date: " + rentalAgreement.getDueDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        assertEquals("Daily Rental Charge: $" + tool2.getDailyRentalCharge(),"Daily Rental Charge: $" + decimalFormat.format(rentalAgreement.getDailyRentalCharge()));
        assertEquals("Charge Days: " + chargeDays,"Charge Days: " + rentalAgreement.getChargeDays());
        assertEquals("Pre-discount Charge: $" + preDiscountCharge,"Pre-discount Charge: $" + decimalFormat.format(rentalAgreement.getPreDiscountCharge()));
        assertEquals("Discount Percent: " + discountPercent + "%","Discount Percent: " + rentalAgreement.getDiscountPercent() + "%");
        assertEquals("Discount Amount: $" + decimalFormat.format(discountAmount),"Discount Amount: $" + decimalFormat.format(rentalAgreement.getDiscountAmount()));
        assertEquals("Final Charge: $" + decimalFormat.format(finalCharge),"Final Charge: $" + decimalFormat.format(rentalAgreement.getFinalCharge()));

    }
    @Test
    public void test3() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");

        int rentalDays =5;
        int chargeDays = 3;
        int discountPercent = 25;
        LocalDate checkoutDate = LocalDate.of(2015, 07, 02);
        Tool tool1 = new Tool("CHNS", "Chainsaw", "Stihl", 1.49, false, true);
        RentalAgreement rentalAgreement = RentalAgreement.makeRentalAgreement(tool1, rentalDays, discountPercent, checkoutDate);

        double preDiscountCharge = chargeDays * tool1.getDailyRentalCharge();
        double discountAmount = preDiscountCharge * discountPercent / 100;
        double finalCharge = preDiscountCharge - discountAmount;

        assertEquals("Tool Code: " + tool1.getToolCode(),"Tool Code: " + rentalAgreement.getToolCode());
        assertEquals("Tool Type: " + tool1.getToolType(),"Tool Type: " + rentalAgreement.getToolType());
        assertEquals("Tool Brand: " + tool1.getBrand(),"Tool Brand: " + rentalAgreement.getToolBrand());
        assertEquals("Rental Days: " + rentalDays,"Rental Days: " + rentalAgreement.getRentalDays());
        assertEquals("Check Out Date: " + checkoutDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),"Check Out Date: " + rentalAgreement.getCheckoutDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        assertEquals("Due Date: " + checkoutDate.plusDays(rentalDays).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),"Due Date: " + rentalAgreement.getDueDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        assertEquals("Daily Rental Charge: $" + tool1.getDailyRentalCharge(),"Daily Rental Charge: $" + decimalFormat.format(rentalAgreement.getDailyRentalCharge()));
        assertEquals("Charge Days: " + chargeDays,"Charge Days: " + rentalAgreement.getChargeDays());
        assertEquals("Pre-discount Charge: $" + preDiscountCharge,"Pre-discount Charge: $" + decimalFormat.format(rentalAgreement.getPreDiscountCharge()));
        assertEquals("Discount Percent: " + discountPercent + "%","Discount Percent: " + rentalAgreement.getDiscountPercent() + "%");
        assertEquals("Discount Amount: $" + decimalFormat.format(discountAmount),"Discount Amount: $" + decimalFormat.format(rentalAgreement.getDiscountAmount()));
        assertEquals("Final Charge: $" + decimalFormat.format(finalCharge),"Final Charge: $" + decimalFormat.format(rentalAgreement.getFinalCharge()));

    }
    @Test
    public void test4() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");

        int rentalDays =6;
        int chargeDays = 3;
        int discountPercent = 0;
        LocalDate checkoutDate = LocalDate.of(2015, 9, 03);
        Tool tool3 = new Tool("JAKD", "Jackhammer", "DeWalt", 2.99, false, false);
        RentalAgreement rentalAgreement = RentalAgreement.makeRentalAgreement(tool3, rentalDays, discountPercent, checkoutDate);

        double preDiscountCharge = chargeDays * tool3.getDailyRentalCharge();
        double discountAmount = preDiscountCharge * discountPercent / 100;
        double finalCharge = preDiscountCharge - discountAmount;

        assertEquals("Tool Code: " + tool3.getToolCode(),"Tool Code: " + rentalAgreement.getToolCode());
        assertEquals("Tool Type: " + tool3.getToolType(),"Tool Type: " + rentalAgreement.getToolType());
        assertEquals("Tool Brand: " + tool3.getBrand(),"Tool Brand: " + rentalAgreement.getToolBrand());
        assertEquals("Rental Days: " + rentalDays,"Rental Days: " + rentalAgreement.getRentalDays());
        assertEquals("Check Out Date: " + checkoutDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),"Check Out Date: " + rentalAgreement.getCheckoutDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        assertEquals("Due Date: " + checkoutDate.plusDays(rentalDays).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),"Due Date: " + rentalAgreement.getDueDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        assertEquals("Daily Rental Charge: $" + tool3.getDailyRentalCharge(),"Daily Rental Charge: $" + decimalFormat.format(rentalAgreement.getDailyRentalCharge()));
        assertEquals("Charge Days: " + chargeDays,"Charge Days: " + rentalAgreement.getChargeDays());
        assertEquals("Pre-discount Charge: $" + preDiscountCharge,"Pre-discount Charge: $" + decimalFormat.format(rentalAgreement.getPreDiscountCharge()));
        assertEquals("Discount Percent: " + discountPercent + "%","Discount Percent: " + rentalAgreement.getDiscountPercent() + "%");
        assertEquals("Discount Amount: $" + decimalFormat.format(discountAmount),"Discount Amount: $" + decimalFormat.format(rentalAgreement.getDiscountAmount()));
        assertEquals("Final Charge: $" + decimalFormat.format(finalCharge),"Final Charge: $" + decimalFormat.format(rentalAgreement.getFinalCharge()));

    }
    @Test
    public void test5() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");

        int rentalDays =9;
        int chargeDays = 5;
        int discountPercent = 0;
        LocalDate checkoutDate = LocalDate.of(2015, 07, 02);
        Tool tool4 = new Tool("JAKR", "Jackhammer", "Ridgid", 2.99, false, false);
        RentalAgreement rentalAgreement = RentalAgreement.makeRentalAgreement(tool4, rentalDays, discountPercent, checkoutDate);


        double preDiscountCharge = BigDecimal.valueOf(chargeDays * tool4.getDailyRentalCharge()).setScale(3, RoundingMode.HALF_UP).doubleValue();


        double discountAmount = preDiscountCharge * discountPercent / 100;
        double finalCharge = preDiscountCharge - discountAmount;

        assertEquals("Tool Code: " + tool4.getToolCode(),"Tool Code: " + rentalAgreement.getToolCode());
        assertEquals("Tool Type: " + tool4.getToolType(),"Tool Type: " + rentalAgreement.getToolType());
        assertEquals("Tool Brand: " + tool4.getBrand(),"Tool Brand: " + rentalAgreement.getToolBrand());
        assertEquals("Rental Days: " + rentalDays,"Rental Days: " + rentalAgreement.getRentalDays());
        assertEquals("Check Out Date: " + checkoutDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),"Check Out Date: " + rentalAgreement.getCheckoutDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        assertEquals("Due Date: " + checkoutDate.plusDays(rentalDays).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),"Due Date: " + rentalAgreement.getDueDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        assertEquals("Daily Rental Charge: $" + tool4.getDailyRentalCharge(),"Daily Rental Charge: $" + decimalFormat.format(rentalAgreement.getDailyRentalCharge()));
        assertEquals("Charge Days: " + chargeDays,"Charge Days: " + rentalAgreement.getChargeDays());
        assertEquals("Pre-discount Charge: $" + preDiscountCharge,"Pre-discount Charge: $" + decimalFormat.format(rentalAgreement.getPreDiscountCharge()));
        assertEquals("Discount Percent: " + discountPercent + "%","Discount Percent: " + rentalAgreement.getDiscountPercent() + "%");
        assertEquals("Discount Amount: $" + decimalFormat.format(discountAmount),"Discount Amount: $" + decimalFormat.format(rentalAgreement.getDiscountAmount()));
        assertEquals("Final Charge: $" + decimalFormat.format(finalCharge),"Final Charge: $" + decimalFormat.format(rentalAgreement.getFinalCharge()));

    }
    @Test
    public void test6() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");

        int rentalDays =4;
        int chargeDays = 1;
        int discountPercent = 50;
        LocalDate checkoutDate = LocalDate.of(2020, 07, 02);
        Tool tool4 = new Tool("JAKR", "Jackhammer", "Ridgid", 2.99, false, false);
        RentalAgreement rentalAgreement = RentalAgreement.makeRentalAgreement(tool4, rentalDays, discountPercent, checkoutDate);

        double preDiscountCharge = chargeDays * tool4.getDailyRentalCharge();


        double discountAmount = preDiscountCharge * discountPercent / 100;
        double finalCharge = preDiscountCharge - discountAmount;

        assertEquals("Tool Code: " + tool4.getToolCode(),"Tool Code: " + rentalAgreement.getToolCode());
        assertEquals("Tool Type: " + tool4.getToolType(),"Tool Type: " + rentalAgreement.getToolType());
        assertEquals("Tool Brand: " + tool4.getBrand(),"Tool Brand: " + rentalAgreement.getToolBrand());
        assertEquals("Rental Days: " + rentalDays,"Rental Days: " + rentalAgreement.getRentalDays());
        assertEquals("Check Out Date: " + checkoutDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),"Check Out Date: " + rentalAgreement.getCheckoutDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        assertEquals("Due Date: " + checkoutDate.plusDays(rentalDays).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),"Due Date: " + rentalAgreement.getDueDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        assertEquals("Daily Rental Charge: $" + tool4.getDailyRentalCharge(),"Daily Rental Charge: $" + decimalFormat.format(rentalAgreement.getDailyRentalCharge()));
        assertEquals("Charge Days: " + chargeDays,"Charge Days: " + rentalAgreement.getChargeDays());
        assertEquals("Pre-discount Charge: $" + preDiscountCharge,"Pre-discount Charge: $" + decimalFormat.format(rentalAgreement.getPreDiscountCharge()));
        assertEquals("Discount Percent: " + discountPercent + "%","Discount Percent: " + rentalAgreement.getDiscountPercent() + "%");
        assertEquals("Discount Amount: $" + decimalFormat.format(discountAmount),"Discount Amount: $" + decimalFormat.format(rentalAgreement.getDiscountAmount()));
        assertEquals("Final Charge: $" + decimalFormat.format(finalCharge),"Final Charge: $" + decimalFormat.format(rentalAgreement.getFinalCharge()));

    }
}
