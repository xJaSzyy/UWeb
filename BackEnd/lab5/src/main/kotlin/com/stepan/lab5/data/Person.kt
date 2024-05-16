package com.stepan.lab5.data

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Schema(description = "Информация о пользователе")
data class Person(

    @Schema(description = "Идентификатор")
    @Min(1)
    @NotNull
    val id: Int,

    @Schema(description = "Имя")
    @NotBlank
    @Size(min=1, max=100)
    val name: String
)
