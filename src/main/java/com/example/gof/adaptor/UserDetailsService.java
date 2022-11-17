package com.example.gof.adaptor;

public interface UserDetailsService {
    UserDetails loadUser(String username);
}
