package ru.hackeru.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "WORKER")
public class Worker {

    @Id @GeneratedValue
    @Column(name = "WORKER_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SALARY")
    private int salary;

    @Column(name = "AGE")
    private int age;

    @ManyToOne
    @JoinColumn(name="ADDRESS_ID")
    private Address home;

    @ManyToOne
    @JoinColumn(name="DEPARTMENT_ID")
    private Department work;

    public Worker() {

    }

    public Worker(String name, int salary, int age, Address home, Department work) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.home = home;
        this.work = work;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public Address getHome() {
        return home;
    }

    public Department getWork() {
        return work;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHome(Address homeID) {
        this.home = home;
    }

    public void setWork(Department work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", home=" + home +
                ", work=" + work +
                '}';
    }
}
