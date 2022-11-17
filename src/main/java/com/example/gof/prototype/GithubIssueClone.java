package com.example.gof.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GithubIssueClone implements Cloneable{
    private int id;
    private String title;
    private GithubRepository repository;

    public GithubIssueClone(GithubRepository repository){
        this.repository = repository;
    }

    public String getUrl(){
        return String.format("https://github.com/%s/%s/issues/%d",
                repository.getUser(),
                repository.getName(),
                getId());
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        /* 깊은 복사를 하려면 아래와 같이 new를 통해 새로 객체를 만든 후 똑같이 세팅하여 리턴.
        GithubRepository githubRepository = new GithubRepository();
        githubRepository.setName(this.repository.getName());
        githubRepository.setUser(this.repository.getUser());

        GithubIssueClone githubIssueClone = new GithubIssueClone(githubRepository);
        githubIssueClone.setTitle(this.title);
        githubIssueClone.setId(this.id);

        return githubIssueClone;
         */

        // 얕은 복사
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubIssueClone that = (GithubIssueClone) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(repository, that.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, repository);
    }
}
