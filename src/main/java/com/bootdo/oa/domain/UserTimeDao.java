package com.bootdo.oa.domain;

/**
 * 获得用户学习时长
 */
public class UserTimeDao {
    /*
     * {"班级":"软件15-2班","关联课程数":4,
"年级":"2015级","项目部":"黑龙江工程",
"学号":"HLJGC20151675","学生姓名":"赵瑞峰",
"总学习时长m":0.0,"专业":"软件工程","区域":"S"},
     */
    //班级
    private String classe;
    //关联课程数
    private String course;
    //年级
    private String school;
    //项目部
    private String userId; //学号
    private String userName; //学生姓名
    private String studyTime; //总学习时长m
    private String major; //专业
    private String area; //区域

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
