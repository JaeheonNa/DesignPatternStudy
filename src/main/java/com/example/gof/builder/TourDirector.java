package com.example.gof.builder;

import java.time.LocalDate;

public class TourDirector {
    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder){
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan cancunTrip(){
        return tourPlanBuilder.title("칸쿤여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2022, 11, 7))
                .whereToStay("리조트")
                .addPlan(0, "체크인하고 짐 풀기")
                .addPlan(0, "저녁식사")
                .getPlan();
    }
}
