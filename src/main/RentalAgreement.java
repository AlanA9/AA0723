package main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentalAgreement {

    private final String toolCode;
    private final String toolType;
    private final String toolBrand;
    private final int rentalDays;
    private final LocalDate checkoutDate;
    private final LocalDate dueDate;
    private final double dailyRentalCharge;
    private final int chargeDays;
    private final double preDiscountCharge;
    private final int discountPercent;
    private final double discountAmount;
    private final double finalCharge;

    public RentalAgreement(String toolCode, String toolType, String toolBrand, int rentalDays, LocalDate checkoutDate,
                           LocalDate dueDate, double dailyRentalCharge, int chargeDays, double preDiscountCharge,
                           int discountPercent, double discountAmount, double finalCharge) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.dailyRentalCharge = dailyRentalCharge;
        this.chargeDays = chargeDays;
        this.preDiscountCharge = preDiscountCharge;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }

    public String getToolCode() {
        return toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public double getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public double getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getFinalCharge() {
        return finalCharge;
    }

    public static RentalAgreement makeRentalAgreement(Tool tool, int rentalDays, int discountPercent, LocalDate checkoutDate) {

            LocalDate dueDate = checkoutDate.plusDays(rentalDays);


            int chargeDays = calculateChargeDays(checkoutDate, dueDate, tool);

            double preDiscountCharge = chargeDays * tool.getDailyRentalCharge();
            double discountAmount = preDiscountCharge * discountPercent / 100;
            double finalCharge = preDiscountCharge - discountAmount;


            RentalAgreement rentalAgreement = new RentalAgreement(tool.getToolCode(), tool.getToolType(), tool.getBrand(), rentalDays, checkoutDate,
                    dueDate, tool.getDailyRentalCharge(), chargeDays, preDiscountCharge, discountPercent, discountAmount, finalCharge);

            return rentalAgreement;

    }
    private static int calculateChargeDays(LocalDate checkoutDate, LocalDate dueDate, Tool tool) {


        LocalDate independenceDay = LocalDate.of(checkoutDate.getYear(), 7, 4);
        if(independenceDay.getDayOfWeek() == DayOfWeek.SATURDAY) independenceDay = independenceDay.minusDays(1);
        if(independenceDay.getDayOfWeek() == DayOfWeek.SUNDAY) independenceDay = independenceDay.plusDays(1);
        LocalDate laborDay = LocalDate.of(checkoutDate.getYear(), 9, 1);
        while(laborDay.getDayOfWeek() != DayOfWeek.MONDAY){
            laborDay = laborDay.plusDays(1);
        }

        int chargeDays = (int) ChronoUnit.DAYS.between(checkoutDate, dueDate);
        LocalDate currentDate = checkoutDate;
        int weekendDays = 0;
        int holidays = 0;
        for(int i =0; i<chargeDays+1; i++) {
            if(currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) weekendDays++;
            if(currentDate.equals(independenceDay) || currentDate.equals(laborDay)) holidays++;
            currentDate = currentDate.plusDays(1);
        }

        if(!tool.isHolidayCharge()) chargeDays-=holidays;
        if(!tool.isWeekendCharge()) chargeDays-=weekendDays;

        return chargeDays;
    }





}
