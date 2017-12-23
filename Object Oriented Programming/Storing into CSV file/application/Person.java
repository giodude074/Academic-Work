package application;

public class Person {
    public String name, email, phone;

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.name + "," + this.email + "," + this.phone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null)? 0: email.hashCode());
        result = prime * result + ((name == null)? 0: name.hashCode());
        result = prime * result + ((phone == null)? 0: phone.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object)
            return true;
        if(object == null)
            return false;
        if(getClass() != object.getClass())
            return false;

        Person person = (Person) object;
        if(email == null) {
            if(person.email != null)
                return false;
        } else if(!email.equals(person.email))
            return false;

        if(name == null) {
            if(person.name != null)
                return false;
        } else if(!name.equals(person.name))
            return false;

        if(phone == null) {
            if(person.phone != null)
                return false;
        } else if(!phone.equals(person.phone))
            return false;

        return true;
    }
}