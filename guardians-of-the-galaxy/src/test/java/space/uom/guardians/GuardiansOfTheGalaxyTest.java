/*
 *  Units of Measurement Spaces for Java
 *  Copyright (c) 2016, Werner Keil and others.
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
