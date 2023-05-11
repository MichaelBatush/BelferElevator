
package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Comparator;

import org.example.Belfer;


public class BelferTest {

Belfer Belfer = new Belfer();

//Belfer.getThree_Elevators()
    @Test
    void getClosestElevator() {
        Belfer belfer = new Belfer();
        BelferElevator e1 = belfer.getSpecificElevator(1);
        BelferElevator e2 = belfer.getSpecificElevator(2);
        BelferElevator e3 = belfer.getSpecificElevator(3);

        belfer.getClosestElevator(10, true);
        assertEquals
        belfer.getClosestElevator(3, true);
        belfer.getClosestElevator(7, false);

    }

    @Test
    void createStatusForElevators() {

    }




}


