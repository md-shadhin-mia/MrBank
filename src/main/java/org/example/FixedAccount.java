package org.example;

import java.time.LocalDate;

public class FixedAccount extends SavingAccount{
    private final int FIXED_PERIOD; //in month
    private LocalDate startDate;
    private LocalDate endDate;
    public FixedAccount(String accountNumber, String accountHolder, double balance, int fixedPeriod, LocalDate startDate) {
        super(accountNumber, accountHolder, balance);
        FIXED_PERIOD = fixedPeriod;

        this.startDate = startDate;
        this.endDate = startDate.plusMonths(FIXED_PERIOD);
    }

    public int getFixedPeriod() {
        return FIXED_PERIOD;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }


    @Override
    public void withdraw(double amount) throws InsufficientFundsException {

        if (LocalDate.now().isBefore(endDate)){
            throw new IllegalStateException("You can't withdraw from fixed account without end the day");
        }
        super.withdraw(amount);
    }
}
