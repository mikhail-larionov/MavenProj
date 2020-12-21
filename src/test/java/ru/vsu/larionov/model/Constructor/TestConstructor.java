package ru.vsu.larionov.model.Constructor;

import org.junit.Test;
import ru.vsu.larionov.model.Carriage.CargoCarriage.CloseCargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.OpenCargoCarriage;
import ru.vsu.larionov.model.Carriage.CargoCarriage.Tank;
import ru.vsu.larionov.model.Carriage.Carriage;
import ru.vsu.larionov.model.Carriage.Lokomotive.Locomotive;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.CoupeCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.LuxuryCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.RestaurantCarriage;
import ru.vsu.larionov.model.Carriage.PassangerCarriage.SitCarriage;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestConstructor {
    final BigDecimal DEFAULT_WEIGHT = BigDecimal.valueOf(25);
    final String DEFAULT_MANUFACTURE = "Ural";
    final BigDecimal DEFAULT_WIDTH = BigDecimal.valueOf(3.249);
    final BigDecimal DEFAULT_LENGTH = BigDecimal.valueOf(13);
    final BigDecimal DEFAULT_CARRYING = BigDecimal.valueOf(68);
    final BigDecimal DEFAULT_VOLUME = BigDecimal.valueOf(114);
    final BigDecimal DEFAULT_POWER = BigDecimal.valueOf(90);


    @Test
    public void testAddCoupeCarriage() throws SQLException {
        PassengerConstructor constructor = new PassengerConstructor();
        constructor.addCoupeCarriage(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH);
        Carriage coupeCarriage = constructor.getTrain().getCarriages().get(0);
        assertEquals(constructor.getTrain().getCarriages().get(0).getClass(), CoupeCarriage.class);
        assertEquals(coupeCarriage.getWeight(), DEFAULT_WEIGHT);
        assertEquals(coupeCarriage.getManufacturer(), DEFAULT_MANUFACTURE);
        assertEquals(coupeCarriage.getWidth(), DEFAULT_WIDTH);
        assertEquals(coupeCarriage.getLength(), DEFAULT_LENGTH);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidCoupeCarriage() throws SQLException {
        PassengerConstructor constructor = new PassengerConstructor();
        constructor.addCoupeCarriage(BigDecimal.valueOf(-4), " ", BigDecimal.TEN, BigDecimal.ZERO);
    }
    @Test
    public void testAddLuxuryCarriage() throws SQLException {
        PassengerConstructor constructor = new PassengerConstructor();
        constructor.addLuxuryCarriage(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH);
        Carriage luxuryCarriage = constructor.getTrain().getCarriages().get(0);
        assertEquals(constructor.getTrain().getCarriages().get(0).getClass(), LuxuryCarriage.class);
        assertEquals(luxuryCarriage.getWeight(), DEFAULT_WEIGHT);
        assertEquals(luxuryCarriage.getManufacturer(), DEFAULT_MANUFACTURE);
        assertEquals(luxuryCarriage.getWidth(), DEFAULT_WIDTH);
        assertEquals(luxuryCarriage.getLength(), DEFAULT_LENGTH);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidLuxuryCarriage() throws SQLException {
        PassengerConstructor constructor = new PassengerConstructor();
        constructor.addLuxuryCarriage(BigDecimal.valueOf(-4), " ", BigDecimal.TEN, BigDecimal.ZERO);
    }
    @Test
    public void testAddRestaurantCarriage() throws SQLException {
        PassengerConstructor constructor = new PassengerConstructor();
        constructor.addRestaurantCarriage(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH);
        Carriage restaurantCarriage = constructor.getTrain().getCarriages().get(0);
        assertEquals(constructor.getTrain().getCarriages().get(0).getClass(), RestaurantCarriage.class);
        assertEquals(restaurantCarriage.getWeight(), DEFAULT_WEIGHT);
        assertEquals(restaurantCarriage.getManufacturer(), DEFAULT_MANUFACTURE);
        assertEquals(restaurantCarriage.getWidth(), DEFAULT_WIDTH);
        assertEquals(restaurantCarriage.getLength(), DEFAULT_LENGTH);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidRestaurantCarriage() throws SQLException {
        PassengerConstructor constructor = new PassengerConstructor();
        constructor.addRestaurantCarriage(BigDecimal.valueOf(-4), " ", BigDecimal.TEN, BigDecimal.ZERO);
    }
    @Test
    public void testAddSitCarriage() throws SQLException {
        PassengerConstructor constructor = new PassengerConstructor();
        constructor.addSitCarriage(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH);
        Carriage sitCarriage = constructor.getTrain().getCarriages().get(0);
        assertEquals(constructor.getTrain().getCarriages().get(0).getClass(), SitCarriage.class);
        assertEquals(sitCarriage.getWeight(), DEFAULT_WEIGHT);
        assertEquals(sitCarriage.getManufacturer(), DEFAULT_MANUFACTURE);
        assertEquals(sitCarriage.getWidth(), DEFAULT_WIDTH);
        assertEquals(sitCarriage.getLength(), DEFAULT_LENGTH);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidSitCarriage() throws SQLException {
        PassengerConstructor constructor = new PassengerConstructor();
        constructor.addSitCarriage(BigDecimal.valueOf(-4), " ", BigDecimal.TEN, BigDecimal.ZERO);
    }
    @Test
    public void testAddCloseCargoCarriage() throws SQLException {
        CargoConstructor constructor = new CargoConstructor();

        constructor.addCloseCargoCarriage(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH,
                                            DEFAULT_CARRYING, DEFAULT_VOLUME);
        Carriage closeCargoCarriage = constructor.getTrain().getCarriages().get(0);
        assertEquals(constructor.getTrain().getCarriages().get(0).getClass(), CloseCargoCarriage.class);
        assertEquals(closeCargoCarriage.getWeight(), DEFAULT_WEIGHT);
        assertEquals(closeCargoCarriage.getManufacturer(), DEFAULT_MANUFACTURE);
        assertEquals(closeCargoCarriage.getWidth(), DEFAULT_WIDTH);
        assertEquals(closeCargoCarriage.getLength(), DEFAULT_LENGTH);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidCloseCargoCarriage() throws SQLException {
        CargoConstructor constructor = new CargoConstructor();
        constructor.addCloseCargoCarriage(BigDecimal.valueOf(-4), " ", BigDecimal.valueOf(-18), BigDecimal.ZERO, BigDecimal.valueOf(-9),BigDecimal.valueOf(-19) );
    }
    @Test
    public void testAddOpenCargoCarriage() throws SQLException {
        CargoConstructor constructor = new CargoConstructor();
        constructor.addOpenCargoCarriage(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH,
                DEFAULT_CARRYING, DEFAULT_VOLUME);
        Carriage openCargoCarriage = constructor.getTrain().getCarriages().get(0);
        assertEquals(constructor.getTrain().getCarriages().get(0).getClass(), OpenCargoCarriage.class);
        assertEquals(openCargoCarriage.getWeight(), DEFAULT_WEIGHT);
        assertEquals(openCargoCarriage.getManufacturer(), DEFAULT_MANUFACTURE);
        assertEquals(openCargoCarriage.getWidth(), DEFAULT_WIDTH);
        assertEquals(openCargoCarriage.getLength(), DEFAULT_LENGTH);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidOpenCargoCarriage() throws SQLException {
        CargoConstructor constructor = new CargoConstructor();
        constructor.addOpenCargoCarriage(BigDecimal.valueOf(-4), " ", BigDecimal.valueOf(-18), BigDecimal.ZERO, BigDecimal.valueOf(-9),BigDecimal.valueOf(-19) );
    }
    @Test
    public void testAddTank() throws SQLException {
        CargoConstructor constructor = new CargoConstructor();
        constructor.addTank(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH,
                DEFAULT_CARRYING, DEFAULT_VOLUME);
        Carriage tank = constructor.getTrain().getCarriages().get(0);
        assertEquals(constructor.getTrain().getCarriages().get(0).getClass(), Tank.class);
        assertEquals(tank.getWeight(), DEFAULT_WEIGHT);
        assertEquals(tank.getManufacturer(), DEFAULT_MANUFACTURE);
        assertEquals(tank.getWidth(), DEFAULT_WIDTH);
        assertEquals(tank.getLength(), DEFAULT_LENGTH);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidTank() throws SQLException {
        CargoConstructor constructor = new CargoConstructor();
        constructor.addTank(BigDecimal.valueOf(-4), " ", BigDecimal.valueOf(-18), BigDecimal.ZERO, BigDecimal.valueOf(-9),BigDecimal.valueOf(-19) );
    }
    @Test
    public void testAddLocomotive() throws SQLException {
        CargoConstructor constructor = new CargoConstructor();
        constructor.addLocomotive(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH, DEFAULT_POWER);
        Carriage locomotive = constructor.getTrain().getLocomotives().get(0);
        assertEquals(constructor.getTrain().getLocomotives().get(0).getClass(), Locomotive.class);
        assertEquals(locomotive.getWeight(), DEFAULT_WEIGHT);
        assertEquals(locomotive.getManufacturer(), DEFAULT_MANUFACTURE);
        assertEquals(locomotive.getWidth(), DEFAULT_WIDTH);
        assertEquals(locomotive.getLength(), DEFAULT_LENGTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidLocomotive() throws SQLException {
        CargoConstructor constructor = new CargoConstructor();
        constructor.addLocomotive(BigDecimal.valueOf(-4), " ", BigDecimal.valueOf(-18), BigDecimal.ZERO, BigDecimal.valueOf(-9) );
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddALotOfLocomotives() throws SQLException {
        CargoConstructor constructor = new CargoConstructor();
        for (int i = 0; i < 5; i++) {
            constructor.addLocomotive(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH, DEFAULT_POWER);
        }
    }

}
