package com.example.gof.adaptor;

public class AccountUserDetailsService implements UserDetailsService {
    AccountService accountService;

    public AccountUserDetailsService(AccountService accountService){
        this.accountService = accountService;
    }
    @Override
    public UserDetails loadUser(String username) {
        Account account = accountService.findAccountByUsername(username);
        return new AccountUserDetails(account);
    }
}
