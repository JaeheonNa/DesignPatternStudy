package com.example.gof.adaptor;

public class AdaptorRunner {
    public static void run(){
        // 타겟 서비스(UserDetailsService)를 상속한 구현체(AccountUserDetailsService)에서
        // 레거시 서비스(AccountService)를 주입 받아 로직 처리.
        // 타겟 서비스의 리턴타입(UserDetails) 역시 구현체(AccountUserDetails)에서
        // 레거시 서비스의 리턴타입(Account)을 주입 받아 처리.
        LoginHandler loginHandler = new LoginHandler(new AccountUserDetailsService(new AccountService()));
        String username = loginHandler.login("najh0528", "najh0528");
        System.out.println(username);
        /*
        장점: 기존 코드(AccountService)를 변경하지 않고 원하는 인터페이스 구현체를 만들어 재사용. Opne Closed Principal
             기존 코드가 하던 일과 특정 인터페이스 구현체로 변환하는 작업을 각기 다른 클래스로 분리하여 관리할 수 있다.
        단점: 새 클래스가 생겨 복잡도가 증가할 수 있음. 경우에 따라서는 기존 코드가 해당 인터페이스를 구현하도록 수정하는 것이 좋은 선택이 될 수도 있음.
         */
    }
}
