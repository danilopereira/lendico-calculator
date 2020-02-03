package com.danilopereira.service.annuity.dto;

import com.danilopereira.dto.RepaymentRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AnnuityRequest {
    private BigDecimal amount;
    private BigDecimal nominalRate;
    private int duration;

    public AnnuityRequest(RepaymentRequest repaymentRequest){
        this.amount = repaymentRequest.getLoanAmount();
        this.nominalRate = repaymentRequest.getNominalRate();
        this.duration = repaymentRequest.getDuration();
    }
}
