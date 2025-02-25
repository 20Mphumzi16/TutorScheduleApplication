package za.ac.cput.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Student")
public class Student extends User {
    private int yearOfStudy;

    public Student() {
    }

    private Student(StudentBuilder builder) {
        super(builder);
        this.yearOfStudy = builder.yearOfStudy;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", image=" + getImage() +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", role=" + getRole() +
                ", yearOfStudy=" + yearOfStudy +
                '}';
    }

    public static class StudentBuilder extends UserBuilder {
        private int yearOfStudy;

        public StudentBuilder() {
        }

        public StudentBuilder setYearOfStudy(int yearOfStudy) {
            this.yearOfStudy = yearOfStudy;
            return this;
        }

        @Override
        public StudentBuilder setId(int id) {
            super.setId(id);
            return this;
        }

        @Override
        public StudentBuilder setName(Name name) {
            super.setName(name);
            return this;
        }

        @Override
        public StudentBuilder setImage(byte[] image) {
            super.setImage(image);
            return this;
        }

        @Override
        public StudentBuilder setPassword(String password) {
            super.setPassword(password);
            return this;
        }

        @Override
        public StudentBuilder setEmail(String email) {
            super.setEmail(email);
            return this;
        }

        @Override
        public StudentBuilder setPhone(String phone) {
            super.setPhone(phone);
            return this;
        }

        @Override
        public StudentBuilder setRole(Role role) {
            super.setRole(role);
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
