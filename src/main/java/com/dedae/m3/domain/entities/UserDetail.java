package com.dedae.m3.domain.entities;

import com.dedae.m3.dto.UserDetailDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_detail")
public class UserDetail {
    @Id
    @SequenceGenerator(name = "user_detail_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_detail_sequence")
    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;
    private Date birthDay;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public UserDetail() {
    }

    public UserDetail(String firstName, String lastName, Integer age, Date birthDay, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDay = birthDay;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", firstName:" + firstName + '\'' +
                ", lastName:" + lastName + '\'' +
                ", age:" + age + '\'' +
                ", birtDay:" + birthDay + '}';
    }
}
