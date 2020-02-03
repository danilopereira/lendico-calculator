package com.danilopereira.service.interest;

import java.math.BigDecimal;

public interface InterestCalculatorService {

    BigDecimal calculateInterest(BigDecimal amount, BigDecimal nominalRate);
}
