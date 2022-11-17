package com.example.gof.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TourPlan {
    private String title;
    private int nights;
    private int days;
    private LocalDate startDate;
    private String whereToStay;
    private List<DetailPlan> plans = new ArrayList<>();

    public void addPlan(int day, String plan){
        DetailPlan detailPlan = new DetailPlan(day, plan);
        plans.add(detailPlan);
    }

}
