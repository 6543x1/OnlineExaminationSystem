package com.jessie.onlineexaminationsystem.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectionsVO implements Serializable {
    List<Selections> selections;
    private int store;
}
