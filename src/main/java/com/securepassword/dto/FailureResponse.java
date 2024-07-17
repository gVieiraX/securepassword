package com.securepassword.dto;

import java.util.List;

public record FailureResponse(
        List<String> failures
) {
}
