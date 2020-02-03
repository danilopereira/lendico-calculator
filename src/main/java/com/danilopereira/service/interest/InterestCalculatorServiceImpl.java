package com.danilopereira.service.interest;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InterestCalculatorServiceImpl implements InterestCalculatorService {

    private final BigDecimal DAYS_IN_MONTH = new BigDecimal(30);
    private final BigDecimal DAYS_IN_YEAR = new BigDecimal(360);

    @Override
    public BigDecimal calculateInterest(BigDecimal amount, BigDecimal nominalRate) {
        nominalRate = nominalRate.divide(new BigDecimal(100));
        BigDecimal ratePerMonth = nominalRate.multiply(DAYS_IN_MONTH);
        BigDecimal amountPerMonth = amount.multiply(ratePerMonth);

        BigDecimal interest = amountPerMonth.divide(DAYS_IN_YEAR, BigDecimal.ROUND_HALF_UP);
        interest = interest.setScale(2, BigDecimal.ROUND_HALF_UP);

        return interest;
    }
}
