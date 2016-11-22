package space.uom.guardians;

import static org.junit.Assert.*;

import static space.uom.guardians.GuardiansOfTheGalaxy.BULE;
import static tec.units.ri.unit.MetricPrefix.MICRO;
import static tec.units.ri.unit.Units.METRE;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

import org.junit.Test;

import tec.units.ri.quantity.Quantities;

public class GuardiansOfTheGalaxyTest {

    @Test
    public void testGamora() {
	//Gamora

	Quantity<Length> height = Quantities.getQuantity(224, MICRO(BULE)); // 1.7m
	Quantity<Length> inM = height.to(METRE);
	assertEquals(Double.valueOf(1.6999360000000001d), inM.getValue());
	
	//Weight: 2008 grets = 54kg 
    }
}
