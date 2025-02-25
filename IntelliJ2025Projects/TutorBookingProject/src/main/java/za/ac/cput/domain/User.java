package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Embedded
    private Name name;
    private byte[] image;
    private String password;
    private String email;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    private Role role;

    public User() {
    }

   protected User(UserBuilder builder) {
        this.id = builder.id;
        this.name=builder.name;
        this.image=builder.image;
        this.password = builder.password;
        this.email = builder.email;
        this.phone = builder.phone;
        this.role = builder.role;
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.deepEquals(image, user.image) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, Arrays.hashCode(image), password, email, phone, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", image=" + Arrays.toString(image) +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                '}';
    }

    public static class UserBuilder {
        private int id;
        private Name name;
        private byte[] image;
        private String password;
        private String email;
        private String phone;
        private Role role;

        public UserBuilder() {
        }

        public UserBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder setRole(Role role) {
            this.role = role;
            return this;
        }
        public UserBuilder setImage(byte[] image) {
            this.image = image;
            return this;
        }
        public UserBuilder setName(Name name) {
            this.name=name;
            return this;
        }

        public UserBuilder copy(User user) {
            this.id = user.id;
            this.name = user.name;
            this.image = user.image;
            this.password = user.password;
            this.email = user.email;
            this.phone = user.phone;
            this.role = user.role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
