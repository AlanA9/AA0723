package main;

public class Tool {
    private String toolCode;
    private String toolType;
    private String brand;
    private double dailyRentalCharge;
    private boolean weekendCharge;
    private boolean holidayCharge;

    public Tool(String toolCode, String toolType, String brand, double dailyRentalCharge, boolean weekendCharge, boolean holidayCharge) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = brand;
        this.dailyRentalCharge = dailyRentalCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public String getToolCode() {
        return toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public String getBrand() {
        return brand;
    }

    public double getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public boolean isWeekendCharge() {
        return weekendCharge;
    }

    public boolean isHolidayCharge() {
        return holidayCharge;
    }


}
