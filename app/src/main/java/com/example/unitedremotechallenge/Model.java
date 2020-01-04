package com.example.unitedremotechallenge;

public class Model {
    private String RepoName;
    private String owner;
    private String description;
    private String stars;


    public Model(){

    }

    public Model(String repoName, String owner,String description , String stars ) {
        this.RepoName = repoName;
        this.owner = owner;
        this.description = description;
        this.stars = stars;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public String getStars() {
        return stars;
    }

    public String getOwner() {
        return owner;
    }

    public String getRepoName() {
        return RepoName;
    }




    public void setRepoName(String repoName) {
        RepoName = repoName;
    }
}

