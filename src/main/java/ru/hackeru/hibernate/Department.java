package ru.hackeru.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id @GeneratedValue
    @Column(name = "DEPARTMENT_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name="WORKER_ID")
    private Worker boss;

    public Department() {

    }

    public Department(String name, Worker boss) {
        this.name = name;
        this.boss = boss;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoss(Worker boss) {
        this.boss = boss;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Worker getBoss() {
        return boss;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", boss=" + boss.getName() +
                '}';
    }
}

