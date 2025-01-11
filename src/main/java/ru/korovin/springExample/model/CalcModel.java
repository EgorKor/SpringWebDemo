package ru.korovin.springExample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CalcModel {
    private int num1;
    private int num2;
    private String operation;
}
