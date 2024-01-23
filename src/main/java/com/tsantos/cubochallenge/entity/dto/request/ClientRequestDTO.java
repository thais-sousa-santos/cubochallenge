package com.tsantos.cubochallenge.entity.dto.request;

import java.math.BigDecimal;

public record ClientRequestDTO(
        Long id,
        String firstName,
        String lastName,
        BigDecimal participation
) {}
