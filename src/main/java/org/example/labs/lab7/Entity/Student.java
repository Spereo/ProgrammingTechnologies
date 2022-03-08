package org.example.labs.lab7.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student extends BaseEntity<Long> {
    private String name;
    private String surname;

    @Column(name = "group_id", insertable = false, updatable = false)
    private Long groupId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public Long getGroupId() { return groupId; }
    public Group getGroup() { return group; }

    public Student setName(String name) { this.name = name; return this; }
    public Student setSurname(String  surname) { this.surname = surname; return this; }
    public Student setGroupId(Long groupId) { this.groupId = groupId; return this; }
    public Student setGroup(Group group) { this.group = group; return this; }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", groupId=" + groupId +
                ", group=" + group +
                ", id=" + id +
                "} " + super.toString();
    }
}
