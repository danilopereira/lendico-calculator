package com.danilopereira.service.annuity;

import com.danilopereira.service.annuity.dto.AnnuityRequest;

import java.math.BigDecimal;

public interface AnnuityCalculatorService {

    BigDecimal calculateAnnuity(AnnuityRequest annuityRequest);
}
