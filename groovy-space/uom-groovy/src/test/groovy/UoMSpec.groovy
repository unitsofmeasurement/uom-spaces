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

import org.UoM.groovy.MonetaryAmountCategory
import org.UoM.groovy.NumberValueCategory
import org.UoM.moneta.Money
import org.UoM.moneta.spi.DefaultNumberValue
import spock.lang.Ignore
import spock.lang.Specification
import spock.util.mop.ConfineMetaClassChanges
import spock.util.mop.Use

import javax.money.CurrencyUnit
import javax.money.MonetaryAmount
import javax.money.Monetary
import javax.money.NumberValue

/**
 * Demonstrate and test UoM methods using the Groovy language.
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
        CurrencyUnit usDollar = Monetary.getCurrency("USD")

        then:
        usDollar.currencyCode == "USD"
    }

    def "create currency amount" () {
        when:
        MonetaryAmount tenUsDollar = Money.of(10, "USD")

        then:
        tenUsDollar.currency.currencyCode == "USD"
        tenUsDollar.number == 10
    }

    def "add MonetaryAmount objects with the add() method" () {
        when:
        MonetaryAmount amount1 = Money.of(10, "USD")
        MonetaryAmount amount2 = Money.of(1, "USD")
        MonetaryAmount sum = amount1.add(amount2)

        then:
        sum.number == 11
        sum == Money.of(11, "USD")
    }
}
