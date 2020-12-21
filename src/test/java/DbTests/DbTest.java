package DbTests;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.larionov.db.DB;
import ru.vsu.larionov.model.Constructor.CargoConstructor;
import ru.vsu.larionov.model.Constructor.PassengerConstructor;
import ru.vsu.larionov.model.Train.Train;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public class DbTest {
    final BigDecimal DEFAULT_WEIGHT = BigDecimal.valueOf(25);
    final String DEFAULT_MANUFACTURE = "Ural";
    final BigDecimal DEFAULT_WIDTH = BigDecimal.valueOf(3.249);
    final BigDecimal DEFAULT_LENGTH = BigDecimal.valueOf(13);
    final BigDecimal DEFAULT_CARRYING = BigDecimal.valueOf(68);
    final BigDecimal DEFAULT_VOLUME = BigDecimal.valueOf(114);
    final BigDecimal DEFAULT_POWER = BigDecimal.valueOf(90);
    final Long id = 1606747240317L;
    final Long idForDeleting = 1606747479120L;

    @Test
    public void CargoCarriageAndTrainsAddingToDBTest() throws SQLException {
        DB db = new DB();
        CargoConstructor cargoConstructor = new CargoConstructor();
        cargoConstructor.addCloseCargoCarriage(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH, DEFAULT_CARRYING, DEFAULT_VOLUME);
        cargoConstructor.addOpenCargoCarriage(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH, DEFAULT_CARRYING, DEFAULT_VOLUME);
        cargoConstructor.addTank(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH, DEFAULT_CARRYING, DEFAULT_VOLUME);
        cargoConstructor.addLocomotive(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE,DEFAULT_WIDTH, DEFAULT_LENGTH, DEFAULT_POWER);
        cargoConstructor.createTrain();
        Assert.assertEquals(cargoConstructor.getTrain(), db.getTrainById(cargoConstructor.getTrain().getId()));
    }
    @Test
    public void PassengerCarriageAndTrainsAddingToDBTest() throws SQLException {
        DB db = new DB();
        PassengerConstructor passengerConstructor = new PassengerConstructor();
        passengerConstructor.addCoupeCarriage(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH);
        passengerConstructor.addLuxuryCarriage(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH);
        passengerConstructor.addSitCarriage(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH);
        passengerConstructor.addLocomotive(DEFAULT_WEIGHT, DEFAULT_MANUFACTURE, DEFAULT_WIDTH, DEFAULT_LENGTH, DEFAULT_POWER);
        passengerConstructor.createTrain();
        Assert.assertEquals(passengerConstructor.getTrain(), db.getTrainById(passengerConstructor.getTrain().getId()));
    }
    @Test
    public void getTrainFromDbByIdTest() throws SQLException {
        DB db = new DB();
        Train train = db.getTrainById(id);
        Assert.assertTrue(train.getNumberOfCarriage() > 3);
        Assert.assertFalse(train.getNumberOfCarriage() > 4);
    }
    @Test(expected = NullPointerException.class)
    public void getTrainFromDbWithInvalidIdTest() throws SQLException {
        DB db = new DB();
        Train train = db.getTrainById(id + 1);
    }
    @Test
    public void deleteTrainByIdTest() throws SQLException {
        DB db = new DB();
        Train train = db.getTrainById(idForDeleting);
        String msg = "Поезд не найден";
        String expMsg = null;
        db.deleteById(idForDeleting);
        try {
            Train train1 = db.getTrainById(idForDeleting);
        }
        catch (NullPointerException ex){
            expMsg = ex.getMessage();
        }
        Assert.assertEquals(msg, expMsg);
    }

}
