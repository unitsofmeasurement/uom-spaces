/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2017, Werner Keil and others.
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
import space.uom.groovy.QuantityCategory
import space.uom.groovy.UnitCategory
import tec.units.ri.quantity.NumberQuantity
import tec.units.ri.unit.Units.METRE
import tec.units.ri.unit.Units.KILOGRAM
import spock.lang.Specification
import spock.util.mop.Use


/**
 * Test of operators added by QuantityCategory
 */
class QuantityCategorySpec extends Specification {

    def "Quantity + Quantity = Quantity" () {
        when:
        def amount1 = NumberQuantity.of(10, METRE)
        def amount2 = NumberQuantity.of(1, METRE)
        def sum = amount1 + amount2

        then:
        sum.value == 11
        sum.unit == METRE
        sum.class == NumberQuantity.class
    }

    def "m + kg throws exception" () {
        when:
        def amount1 = NumberQuantity.of(10, METRE)
        def amount2 = NumberQuantity.of(1, KILOGRAM)
        def sum = amount1 + amount2

        then:
        javax.measure.MeasurementException e = thrown()
        e.message == "Currency mismatch: m/kg"
    }

}