package com.example.gof.builder;

import java.time.LocalDate;

public class BuilderRunner {

    public static void run(){

        // 빌더 패턴 적용 전.
        // 생성자의 수가 너무 많아진다는 단점이 있음.
        TourPlan tourPlan_1 = new TourPlan();
        tourPlan_1.setTitle("칸쿤 여행");
        tourPlan_1.setNights(2);
        tourPlan_1.setDays(3);
        tourPlan_1.setStartDate(LocalDate.of(2022, 11, 7));
        tourPlan_1.setWhereToStay("리조트");
        tourPlan_1.addPlan(0, "체크인 이후 짐 풀기");
        tourPlan_1.addPlan(0, "저녁 식사");
        tourPlan_1.addPlan(1, "조식 뷔페에서 식사");
        tourPlan_1.addPlan(1, "해변 산책");
        tourPlan_1.addPlan(1, "수영장 근처 음식점에서 점심 식사");
        tourPlan_1.addPlan(1, "리조트 수영장에서 놀기");
        tourPlan_1.addPlan(1, "BBQ 식당에서 스테이크 저녁");
        tourPlan_1.addPlan(2, "조식 뷔페에서 식사");
        tourPlan_1.addPlan(2, "체크아웃");

        System.out.println(tourPlan_1);


        // 빌더 패턴 적용.
        // 모든 메소드의 리턴타입이 TourpPlanBuilder이기 때문에 체이닝 가능.
        TourPlanBuilder builder = new DefaultTourBuilder();
        TourPlan tourPlan_2 = builder.title("칸쿤여행")
                                    .nightsAndDays(2, 3)
                                    .startDate(LocalDate.of(2022, 11, 7))
                                    .whereToStay("리조트")
                                    .addPlan(0, "체크인하고 짐 풀기")
                                    .addPlan(0, "저녁식사")
                                    .getPlan();
        System.out.println(tourPlan_2);


        //디렉터 사용 빌더 패턴 적용.
        TourDirector tourDirector  = new TourDirector(new DefaultTourBuilder());
        TourPlan tourPlan_3 = tourDirector.cancunTrip();
        System.out.println(tourPlan_3);

    }

}
