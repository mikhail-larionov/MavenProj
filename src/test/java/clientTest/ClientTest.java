package clientTest;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.larionov.connection.Connection;
import ru.vsu.larionov.connection.Hangars;

import java.io.IOException;
import java.net.Socket;

public class ClientTest {
    Connection connection = new Connection(new Socket("localhost", 3345));
    Hangars hangars = new Hangars();

    String trainString = "{\"type\":\"CARGO\",\"id\":null,\"numberOfCarriage\":3,\"maxSpeed\":null,\"locomotives\":[{\"weight\":10,\"manufacturer\":\"Ural\",\"width\":1,\"length\":24,\"type\":\"LOCOMOTIVE\",\"id\":null,\"trainId\":null,\"subType\":\"LOCOMOTIVE\",\"power\":100}],\"carriages\":[{\"weight\":10,\"manufacturer\":\"Ural\",\"width\":30,\"length\":100,\"type\":\"Cargo\",\"id\":null,\"trainId\":null,\"subType\":\"CLOSE_CARGO\",\"volume\":40},{\"weight\":10,\"manufacturer\":\"Ural\",\"width\":30,\"length\":100,\"type\":\"Cargo\",\"id\":null,\"trainId\":null,\"subType\":\"CLOSE_CARGO\",\"volume\":40}]}";
    String hangarString = "{\"hangars\":{\"0\":\"{\\\"type\\\":\\\"CARGO\\\",\\\"id\\\":null,\\\"numberOfCarriage\\\":3,\\\"maxSpeed\\\":null,\\\"locomotives\\\":[{\\\"weight\\\":10,\\\"manufacturer\\\":\\\"Ural\\\",\\\"width\\\":1,\\\"length\\\":24,\\\"type\\\":\\\"LOCOMOTIVE\\\",\\\"id\\\":null,\\\"trainId\\\":null,\\\"subType\\\":\\\"LOCOMOTIVE\\\",\\\"power\\\":100}],\\\"carriages\\\":[{\\\"weight\\\":10,\\\"manufacturer\\\":\\\"Ural\\\",\\\"width\\\":30,\\\"length\\\":100,\\\"type\\\":\\\"Cargo\\\",\\\"id\\\":null,\\\"trainId\\\":null,\\\"subType\\\":\\\"CLOSE_CARGO\\\",\\\"volume\\\":40},{\\\"weight\\\":10,\\\"manufacturer\\\":\\\"Ural\\\",\\\"width\\\":30,\\\"length\\\":100,\\\"type\\\":\\\"Cargo\\\",\\\"id\\\":null,\\\"trainId\\\":null,\\\"subType\\\":\\\"CLOSE_CARGO\\\",\\\"volume\\\":40}]}\"}}";

    public ClientTest() throws IOException {
    }
    @Test
    public void TestConnection() throws IOException {
        hangars.getHangars().put(0, trainString);
        String s = "";
        connection.send(trainString);
        boolean shouldToStop = true;
        while (shouldToStop){
            s = connection.receive();
            shouldToStop = false;
        }
        Assert.assertEquals(s, hangarString);
    }
}
