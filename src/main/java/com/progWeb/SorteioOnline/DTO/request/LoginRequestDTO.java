package com.progWeb.SorteioOnline.DTO.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequestDTO(@NotEmpty String email,
                              @NotEmpty String senha){}