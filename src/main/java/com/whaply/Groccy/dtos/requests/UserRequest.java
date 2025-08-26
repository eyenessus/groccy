package com.whaply.Groccy.dtos.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(@NotNull @Size(min = 2, max = 100) String username,
        @NotNull @Size(min = 2, max = 100) String name, @NotNull @Size(min = 6, max = 100) String password) {
}
