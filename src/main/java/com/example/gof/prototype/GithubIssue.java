package com.example.gof.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GithubIssue {
    private int id;
    private String title;
    private GithubRepository repository;

    public GithubIssue(GithubRepository repository){
        this.repository = repository;
    }

    public String getUrl(){
        return "https://github.com/" + repository.getUser()+ "/" + repository.getName() + "/issues/" + id;
    }
}
