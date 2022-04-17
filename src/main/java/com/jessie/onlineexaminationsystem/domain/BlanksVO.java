package com.jessie.onlineexaminationsystem.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BlanksVO implements Serializable {
    List<Blanks> blanks;
    Integer store;
}
