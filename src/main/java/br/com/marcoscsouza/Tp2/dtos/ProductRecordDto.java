package br.com.marcoscsouza.Tp2.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank  String name, @NotNull BigDecimal price) {
}
