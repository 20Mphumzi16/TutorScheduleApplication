package za.ac.cput.domain;



import java.util.Objects;

public class Name {

    private String firstName;
    private String preferredName;
    private String lastName;

    protected Name() {
    }

    private Name(NameBuilder n) {
        this.firstName = n.firstName;
        this.preferredName = n.preferredName;
        this.lastName = n.lastName;

    }


    public String getFirstName() {
        return firstName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public String toString() {
        return "Name{" +

                "firstName='" + firstName + '\'' +
                ", preferredName='" + preferredName + '\'' +
                ", lastName='" + lastName + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) && Objects.equals(preferredName, name.preferredName) && Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, preferredName, lastName);
    }

    public static class NameBuilder {
        private String firstName;
        private String preferredName;
        private String lastName;


        public NameBuilder() {

        }

        public NameBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public NameBuilder setPreferredName(String preferredName) {
            this.preferredName = this.preferredName;
            return this;
        }


        public NameBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public NameBuilder copy(Name n) {
            this.firstName = n.firstName;
            this.preferredName = n.preferredName;
            this.lastName = n.lastName;
            return this;
        }

        public Name build() {

            return new Name(this);
        }
    }
}
