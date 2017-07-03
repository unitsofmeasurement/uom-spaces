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
import tec.units.ri.AbstractUnit
import spock.lang.Specification
import spock.util.mop.Use

import javax.measure.Quantity

/**
 * Tests Unit API and Groovy extensions with Spock.
 * @author Werner Keil
 */
@Use(UnitCategory)
class UoMGroovyDemoSpec extends Specification {

    def "Create two Quantitys and add them with + operator" () {
        when:
        def sum = 10.eur + 0.99.eur

        then:
        sum.number == 10.99
        sum.currency.currencyCode == "EUR"
        sum instanceof Quantity
        sum.class == Money.class
    }
	
	def "Create two Quantitys and subtract them with - operator" () {
		when:
		def diff = 10.eur - 1.99.eur

		then:
		diff.number == 8.00
		diff.currency.currencyCode == "EUR"
		diff instanceof Quantity
		diff.class == Quantity.class
	}

	
    def "m + kg throws exception" () {
        when:
        def sum = 1.m + 2.kg

        then:
        javax.measure.MeasurementException e = thrown()
        e.message == "Unit mismatch: Length/Mass"
    }

}