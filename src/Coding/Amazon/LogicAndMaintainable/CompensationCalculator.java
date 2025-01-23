package Coding.Amazon.LogicAndMaintainable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class CompensationCalculator {

    private int baseSalary;
    private int annualRSU;
    private int signOnBonus;
    private LocalDate startDate;

    public CompensationCalculator(int baseSalary, int annualRSU, int signOnBonus, LocalDate startDate) {
        this.baseSalary = baseSalary;
        this.annualRSU = annualRSU;
        this.signOnBonus = signOnBonus;
        this.startDate = startDate;
    }

    public Map<Integer, Integer> calculateIncome() {
        Map<Integer, Integer> incomeByYear = new HashMap<>();
        LocalDate currentDate = LocalDate.now();

        for (int year = startDate.getYear(); year <= currentDate.getYear(); year++) {
            LocalDate yearStart = LocalDate.of(year, 1, 1);
            LocalDate yearEnd = LocalDate.of(year, 12, 31);

            // Adjust start and end dates for partial years
            LocalDate actualStart = year == startDate.getYear() ? startDate : yearStart;
            LocalDate actualEnd = year == currentDate.getYear() ? currentDate : yearEnd;

            long monthsWorked = ChronoUnit.MONTHS.between(
                    actualStart.withDayOfMonth(1),
                    actualEnd.withDayOfMonth(1)
            ) + 1;

            int annualIncome = (baseSalary + annualRSU) * (int) monthsWorked / 12;

            // Include sign-on bonus for the first year
            if (year == startDate.getYear()) {
                annualIncome += signOnBonus;
            }

            incomeByYear.put(year, annualIncome);
        }

        return incomeByYear;
    }

    public static void main(String[] args) {
        int baseSalary = 120000;
        int annualRSU = 60000;
        int signOnBonus = 25000;
        LocalDate startDate = LocalDate.of(2021, 2, 15); // Example start date

        CompensationCalculator calculator = new CompensationCalculator(baseSalary, annualRSU, signOnBonus, startDate);
        Map<Integer, Integer> income = calculator.calculateIncome();

        for (Map.Entry<Integer, Integer> entry : income.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
