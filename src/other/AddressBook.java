package other;

import exceptions.PersonNoAddressException;
import interfaces.Message;
import interfaces.StringEditor;
import person.Person;
import util.StoryObject;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;

public class AddressBook extends StoryObject{

    private static String city = "Мухосранск";

    private ArrayList<Address> addresses = new ArrayList<Address>();

    public AddressBook(String name, String description){
        super(name, description);
    }

    public static String getCity(){
        return city;
    }

    public static void setCity(String c){
        city = c;
    }

    public static class Address implements Message {
        private String description;
        private Person tenant;

        public Address(Person p, String description){
            this.tenant = p;
            this.description = description;
        }

        public String getDescription(){
            return description;
        }

        public Person getTenant(){
            return tenant;
        }

        public void setDescription(String description){
            this.description = description;
        }

        public void setTenant(Person tenant){
            this.tenant = tenant;
        }

        @Override
        public String toMessage(){
            return (new Formatter()).format("%s %s %s", getTenant(), getCity(), getDescription()).toString();
        }

        @Override
        public String toString() {
            return (new Formatter()).format("<%s> %s: %s %s", getClass().toString(), getTenant().getName() ,getDescription()).toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return Objects.equals(description, address.description) && Objects.equals(tenant, address.tenant);
        }

        @Override
        public int hashCode() {
            return Objects.hash(description, tenant);
        }
    }


    public Address getAddress(Person p) throws PersonNoAddressException{

        for (Address a : addresses) {
            if (a.tenant.equals(p)) {
                return a;
            }
        }
        throw new PersonNoAddressException("That person does not have address", p);
    }

    public void addAddress(Address a){
        addresses.add(a);
    }

    public void setAddresses(ArrayList<Address> a){
        addresses = a;
    }


    @Override
    public String toMessage() {
        class DollarEditor{
            public String dollarize(String string){
                StringEditor stringEditor = (String s) -> "$" + s + "$";
                return stringEditor.edit(string);
            }
        }

        return (new Formatter()).format("%s %s %s", getDescription(), getName(), (new DollarEditor()).dollarize(getCity())).toString();
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "addresses=" + addresses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return Objects.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addresses);
    }
}
