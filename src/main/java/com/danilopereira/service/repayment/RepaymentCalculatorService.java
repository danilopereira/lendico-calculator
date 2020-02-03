package com.danilopereira.service.repayment;

import com.danilopereira.dto.RepaymentRequest;
import com.danilopereira.dto.RepaymentResponse;

import java.util.List;

public interface RepaymentCalculatorService {

    List<RepaymentResponse> calculateRepayment(RepaymentRequest repaymentRequest);
}
