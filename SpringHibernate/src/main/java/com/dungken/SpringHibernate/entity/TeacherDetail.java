package com.dungken.SpringHibernate.entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.sql.Date;

@Entity
@Table(name = "teacher_detail")
public class TeacherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "identification_number")
    private String identificationNumber;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "address")
    private String address;
    @Column(name = "salary")
    private double salary;
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "ytb_channel")
    private String ytbChannel;
    @Lob
    @Column(name = "avatar")
    private Blob avatar;

    @OneToOne(mappedBy = "teacherDetail")
    private Teacher teacher;

    public TeacherDetail() {
    }

    public TeacherDetail(String identificationNumber, String phoneNumber, Date dateOfBirth, boolean gender, String address, double salary, String facebook, String ytbChannel, Blob avatar) {
        this.identificationNumber = identificationNumber;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.salary = salary;
        this.facebook = facebook;
        this.ytbChannel = ytbChannel;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getYtbChannel() {
        return ytbChannel;
    }

    public void setYtbChannel(String ytbChannel) {
        this.ytbChannel = ytbChannel;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "TeacherDetail{" +
                "id=" + id +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", facebook='" + facebook + '\'' +
                ", ytbChannel='" + ytbChannel + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
