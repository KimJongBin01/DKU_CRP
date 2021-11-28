package Swing_myStudy;

public class member {
    private String Id;
    private String name;
    private String password;
    private String grade;

    public member(String name, String grade, String Id, String password){
        this.name = name;
        this.grade = grade;
        this.Id = Id;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.Id;
    }

    public String getPassword(){
        return this.password;
    }

    public String getGrade(){
        return this.grade;
    }
}
