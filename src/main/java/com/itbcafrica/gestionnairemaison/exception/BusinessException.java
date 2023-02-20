package com.itbcafrica.gestionnairemaison.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusinessException extends RuntimeException {
    private List<ErrorModel> errors;
}
