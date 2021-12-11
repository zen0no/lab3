import car.Car;
import enums.Action;
import enums.Brand;
import other.PetrolFirm;
import other.Shorty;
import other.StoryTeller;
import person.HateableStranger;
import person.PoliceCommissar;
import place.Bullpen;
import place.Street;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Car wantedCar = new Car("машина", "разыскиваемая", Brand.UNKNOWN);
        StoryTeller.tell(Action.NAME_WANTED_CAR_BRAND , wantedCar.getBrand());
        Street street = new Street("улица города");
        PetrolFirm firm = new PetrolFirm("фирма", "продающая автомобильный бензини", street);
        Bullpen bullpen = new Bullpen("кутузка");        HateableStranger sardanapal = new HateableStranger("Сарданапал", "некий");
        PoliceCommissar pshigel = new PoliceCommissar("Пшигель", "");
        Shorty shorty = new Shorty("коротышка", "какой-то");
        for (int i = 0; i < 10; i++) {


            Brand[] t = Brand.values();
            String[] ds = new String[]{"розовая", "красная", "синяя", "большая", "маленькая", "норм"};
            Random r = new Random();
            int in1 = r.nextInt(t.length - 1);
            int in2 = r.nextInt(ds.length);
            Car c = new Car("машина " + i, ds[in2], t[in1]);
            street.addMovable(c);

            StoryTeller.tell(c, Action.DRIVE_TO, street);

            if (wantedCar.getBrand() == Brand.UNKNOWN || wantedCar.getBrand() == c.getBrand()) {
                shorty.makeFuss(c);
                StoryTeller.tell(shorty, Action.DESTROY_TIRES, c);
            }
        }

        if (!firm.canSell()){
            StoryTeller.tell(firm, Action.IS_BROKEN);
        }

        sardanapal.blame(pshigel);
        StoryTeller.tell(sardanapal, Action.BLAME_FOR_MONEY_STEALING);
        StoryTeller.tell(pshigel, Action.WANT_TO_ARREST, sardanapal, Action.TO, bullpen);
        pshigel.makeVisit(sardanapal, bullpen);
    }
}