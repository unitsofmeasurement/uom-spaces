/*
 *  Units of Measurement Spaces for Java
 *  Copyright (c) 2016-2019, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of Units of Measurement nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package space.uom.guardians;

import static org.junit.Assert.*;

import static space.uom.guardians.GuardiansOfTheGalaxy.*;
import static javax.measure.MetricPrefix.MICRO;
import static tech.units.indriya.unit.Units.*;

import java.math.BigDecimal;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tech.units.indriya.function.RationalNumber;
import tech.units.indriya.quantity.Quantities;
import org.junit.Test;

public class GuardiansOfTheGalaxyTest {

	@Test
	public void testGamora() {
		// Gamora

		Quantity<Length> height = Quantities.getQuantity(224, MICRO(BULE)); // 1.7m
		Quantity<Length> inM = height.to(METRE);
		assertEquals(RationalNumber.of(1.699936), inM.getValue());

		// Weight: 2008 grets = 54kg
		Quantity<Mass> weight = Quantities.getQuantity(2008, GRET);
		Quantity<Mass> inKg = weight.to(KILOGRAM);
		assertEquals(RationalNumber.of(54.216), inKg.getValue());
	}
	
	@Test
	public void testDrax() {
		// Drax

		Quantity<Length> height = Quantities.getQuantity(203, MICRO(BULE)); // 1.54m
		Quantity<Length> inM = height.to(METRE);
		assertEquals(RationalNumber.of(1.540567), inM.getValue());

		// Weight: 3892 grets = 105kg
		Quantity<Mass> weight = Quantities.getQuantity(3892, GRET);
		Quantity<Mass> inKg = weight.to(KILOGRAM);
		assertEquals(RationalNumber.of(105.084), inKg.getValue());
	}
	
	@Test
	public void testGroot() {
		// Groot

		Quantity<Length> height = Quantities.getQuantity(500, MICRO(BULE)); // 3.79m
		Quantity<Length> inM = height.to(METRE);
		assertEquals(RationalNumber.of(3.7945), inM.getValue());

		// Weight: 4258 grets = 114.96kg
		Quantity<Mass> weight = Quantities.getQuantity(4258, GRET);
		Quantity<Mass> inKg = weight.to(KILOGRAM);
		assertEquals(RationalNumber.of(114.966), inKg.getValue());
	}
	
	@Test
	public void testStarlord() {
		// Starlord

		Quantity<Length> height = Quantities.getQuantity(249, MICRO(BULE)); // 1.89m
		Quantity<Length> inM = height.to(METRE);
		assertEquals(RationalNumber.of(1.889661), inM.getValue());

		// Weight: 3235 grets = 87kg
		Quantity<Mass> weight = Quantities.getQuantity(3235, GRET);
		Quantity<Mass> inKg = weight.to(KILOGRAM);
		assertEquals(RationalNumber.of(87.345), inKg.getValue());
	}
	
	@Test
	public void testRocket() {
		// Rocket Raccoon

		Quantity<Length> height = Quantities.getQuantity(112, MICRO(BULE)); // 0.85m
		Quantity<Length> inM = height.to(METRE);
		assertEquals(RationalNumber.of(0.849968), inM.getValue());

		// Weight: 743.7 grets = 20kg
		Quantity<Mass> weight = Quantities.getQuantity(743.7, GRET);
		Quantity<Mass> inKg = weight.to(KILOGRAM);
		assertEquals(BigDecimal.valueOf(20.0799), inKg.getValue());
	}
	
	@Test
	public void testFatThor() {
		// Fat Thor

		Quantity<Length> height = Quantities.getQuantity(251, MICRO(BULE)); // 1.9m
		Quantity<Length> inM = height.to(METRE);
		assertEquals(RationalNumber.of(1.904839), inM.getValue());

		// Weight: 5050 grets = 136kg ~ 300lb
		Quantity<Mass> weight = Quantities.getQuantity(5050, GRET);
		Quantity<Mass> inKg = weight.to(KILOGRAM);
		assertEquals(RationalNumber.of(136.35), inKg.getValue());
	}
}
