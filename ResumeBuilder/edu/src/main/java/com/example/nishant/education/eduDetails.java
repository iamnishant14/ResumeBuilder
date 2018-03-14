package com.example.nishant.education;

/**
 * Created by nisha on 30-12-2017.
 */

public class eduDetails {
    private String schoolName;
    private String cumulativeGPA;
    private String branchRank;
    private String schoolSession;
    private String schoolBranch;

    public eduDetails(String sName,String cGPA,String bRank,String sSession,String sBranch){
        this.schoolName=sName;
        this.cumulativeGPA=cGPA;
        this.branchRank=bRank;
        this.schoolSession=sSession;
        this.schoolBranch=sBranch;
    }

    public String getSchoolName(){return this.schoolName;}
    public String getCumulativeGPA(){return this.cumulativeGPA;}
    public String getBranchRank(){return this.branchRank;}
    public String getSchoolSession(){return this.schoolSession;}
    public String getSchoolBranch(){return this.schoolBranch;}
}
