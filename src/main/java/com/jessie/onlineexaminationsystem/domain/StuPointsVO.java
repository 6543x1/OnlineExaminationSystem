package com.jessie.onlineexaminationsystem.domain;

import lombok.Data;

@Data
public class StuPointsVO {
    Integer examID;
    Integer uid;
    Integer points;
    String name;
    String school;
    String profession;
    String no;

    @Override
    public String toString() {
        return "StuPointsVO{" +
                "examID=" + examID +
                ", uid=" + uid +
                ", points=" + points +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
