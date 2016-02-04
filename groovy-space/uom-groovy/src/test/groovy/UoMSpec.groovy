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

import space.uom.groovy.QuantityCategory
import space.uom.groovy.UnitCategory
import tec.units.ri.quantity.NumberQuantity
import tec.units.ri.quantity.Quantities
import tec.units.ri.unit.Units
import spock.lang.Ignore
import spock.lang.Specification
import spock.util.mop.ConfineMetaClassChanges
import spock.util.mop.Use

import javax.measure.Quantity
import javax.measure.Unit
import javax.measure.spi.Bootstrap

/**
 * Demonstrate and test Unit API methods using the Groovy language.
 *
 * Particular attention is paid to the issue of using Groovy operator overloading
 * to be able to write things like:
 *
 * { @code def sum = amount1 + amount2 }
 *
 *
 * Groovy Categories are used to support some of the operator methods used by Groovy for arithmetic.
 *
 */
class UoMSpec extends Specification {

    def "get currency unit" () {
        when:
        Unit len = Units.METRE

        then:
        len.symbol == "m"
    }

    def "create quantity amount" () {
        when:
        Quantity tenMetre = Quantities.getQuantity(10, Units.METRE)

        then:
        tenMetre.unit.symbol == "m"
        tenMetre.value == 10
    }

    def "add Quantity objects with the add() method" () {
        when:
        Quantity amount1 =  Quantities.getQuantity(10, Units.GRAM)
        Quantity amount2 =  Quantities.getQuantity(1,  Units.KILOGRAM)
        Quantity sum = amount1.add(amount2)

        then:
        sum.value == 1010
        sum == Quantities.getQuantity(1011, Units.GRAM)
    }
}
