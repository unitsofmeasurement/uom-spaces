/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363, Unit-API nor the names of their contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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
package tec.uom.demo.groovy

import javax.measure.Quantity
import tec.units.ri.quantity.NumberQuantity
import tec.units.ri.unit.Units
import space.uom.groovy.QuantityCategory

/**
 * Simple Demo of using Unit-RI from Groovy
 * <p>
 * Example of arithmetic using Quantities with operator overloading added
 * though Groovy Categories and the mixin() method
 * </p>
 * Note: (For now) most of the action is in the Spock tests.
 *
 * @author Werner Keil
 */
public class GroovyDemo {

    public static void main(String[] args) {

        // Still need to use .mixin here as long as Extensions in on same subproject/build as the demo class
        Quantity.mixin(QuantityCategory)

        def value1 = NumberQuantity.of(10, Units.KILOGRAM)
        def value2 = NumberQuantity.of(0.99, Units.GRAM)

        def sum = value1 + value2       // Add Quantity with '+' operator
        println "${value1} + ${value2} = ${sum}"
		
		def dif = value1 - value2		// Subtract Quantity with '-' operator
		println "${value1} - ${value2} = ${dif}"
		
		def value3 = NumberQuantity.of(1, Units.METRE)
//		def sum2 = value1 + value3 		// This won't work (must be of same unit)
		
		def mult = value1 * 3			// Multiply Quantity by 3 '/' operator
		println "${value1} * 3 = ${mult}"
		
		def div = value1 / 2			// Divide Quantity by 2 '/' operator
		println "${value1} / 2 = ${div}"
    }
}
