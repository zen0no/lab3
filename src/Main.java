import car.Car;
import enums.Action;
import enums.Brand;
import exceptions.PersonNoAddressException;
import interfaces.Message;
import interfaces.Movable;
import interfaces.Patrol;
import other.AddressBook;
import other.PetrolFirm;
import person.Shorty;
import other.StoryTeller;
import person.PoliceCommissar;
import place.Bullpen;
import place.Place;
import place.Street;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Car wantedCar = new Car("машина", "разыскиваемая", Brand.UNKNOWN);
        Street street = new Street("улица города");
        PetrolFirm firm = new PetrolFirm("фирма", "продающая автомобильный бензини", street);
        Bullpen bullpen = new Bullpen("кутузка");

        AddressBook.setCity("Давелон");
        AddressBook addressBook = new AddressBook("адресная книга", "полная");
        Shorty sardanapal = new Shorty("Сарданапал", "некий");
        PoliceCommissar pshigel = new PoliceCommissar("Пшигель", "");
        addressBook.addAddress(new AddressBook.Address(pshigel, "старая комунналка на третьем этаже"));
        Shorty shorty = new Shorty("коротышка", "какой-то");
        addressBook.addAddress(new AddressBook.Address(
                new Shorty("билли батчер", "невысокий"), "новостройка в мурино"));
        addressBook.addAddress(new AddressBook.Address(
                new Shorty("куртка бэйн", "дырявый"), "200 км от города"));


        Patrol patrol = new Patrol() {
            @Override
            public void tryToInspect(Place place) {
                if (street.getMovables().contains(wantedCar)){
                        wantedCar.visit(bullpen);
                        StoryTeller.tell((Message) wantedCar, Action.ARREST);
                    }
                else{
                        StoryTeller.tell((Message) wantedCar, Action.CANT_ARREST);
                }
            }
        };

        wantedCar.visit(street);
        wantedCar.hideMoney(1000, "доллары");
        wantedCar.leave(street);


        for (int i = 0; i < 10; i++) {
            Brand[] t = Brand.values();
            String[] ds = new String[]{"розовая", "красная", "синяя", "большая", "маленькая", "норм"};
            Random r = new Random();
            int in1 = r.nextInt(t.length - 1);
            int in2 = r.nextInt(ds.length);
            Car c = new Car("машина " + i, ds[in2], t[in1]);
            c.visit(street);
            if (wantedCar.getBrand() == Brand.UNKNOWN || wantedCar.getBrand() == c.getBrand()) {
                shorty.makeFuss(c);
            }
        }
        patrol.tryToInspect(street);

        firm.canSell();

        sardanapal.blame(pshigel);
        pshigel.tryToArrest(addressBook, sardanapal, bullpen);
    }
}