package com.example.gof.builder;

import java.time.LocalDate;

public interface TourPlanBuilder {
    // TourPlanBuilder를 리턴타입으로 정의함으로써, 구현체 간 체이닝을 이룰 수 있음.
    // 연쇄적으로 호출을 하다가, 마지막에 필요로하는 타입(TourPlan)을 리턴하는 메소드를 호출.
    // 해당 메소드에서 벨리데이션 수행.
    TourPlanBuilder title(String title);
    TourPlanBuilder nightsAndDays(int nights, int days);
    TourPlanBuilder startDate(LocalDate localDate);
    TourPlanBuilder whereToStay(String whereToStay);
    TourPlanBuilder addPlan(int day, String plan);
    TourPlan getPlan();

}
