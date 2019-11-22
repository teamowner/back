package com.owner.backproject.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Result {

    private int code;
    private String msg;
    private List<?> list;
    private Object object;
}
