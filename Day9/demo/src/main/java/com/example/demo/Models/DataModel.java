package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class DataModel {
    int code;
    String msg;
    Object data;
}
