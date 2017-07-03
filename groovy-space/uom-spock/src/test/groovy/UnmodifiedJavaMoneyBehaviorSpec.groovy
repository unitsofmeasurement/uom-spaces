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
 
import org.javamoney.moneta.Money
import org.javamoney.moneta.spi.DefaultNumberValue
import spock.lang.Ignore
import spock.lang.Specification

import javax.measure.Quantity
import javax.money.NumberValue

/**
 * Demonstrate expected but undesirable behavior that can be remedied with Groovy
 * MetaClass changes.
 *
 * Particular attention is paid to the issue of using Groovy operator overloading
 * to be able to write things like:
 *
 * { @code def sum = amount1 + amount2 }
 *
 * Perhaps undesirable behavior should be indicated by a failing test,
 * but for now the tests are written to "specify" the undesirable behavior with
 * asserts in the "then" clauses.
 */
class UnmodifiedJavaMoneyBehaviorSpec extends Specification {

    def "Add currency amounts using Groovy operator overloading fails" () {
        when: "We add two MonetaryAmounts"
        MonetaryAmount amount1 = Money.of(10, "USD")
        MonetaryAmount amount2 = Money.of(1, "USD")
        def sum = amount1 + amount2

        then: "We get a MissingMethodException because JavaMoney uses add() not plus()"
        groovy.lang.MissingMethodException e = thrown()
        e.message != null
    }

    def "Add number values using Groovy MetaClass plus() method succeeds, but returns unexpected type" () {
        when:
        NumberValue value1 = Money.of(10, "USD").number
        NumberValue value2 = Money.of(1, "USD").number
        def sum = value1.plus(value2)

        then: "We get an Integer, although we expected (wanted) a NumberValue"
        sum == 11
        sum.class == Integer.class
    }

    def "Add number values using Groovy operator overloading succeeds, but returns unexpected type" () {
        when: "We add two NumberValues using the '+' operator and the Groovy Number.plus() method"
        NumberValue value1 = Money.of(10, "USD").number
        NumberValue value2 = Money.of(1, "USD").number
        def sum = value1 + value2

        then: "We get an Integer, although we expected (wanted) a NumberValue"
        sum == 11
        sum.class == Integer.class
    }

    def "Add number values using Groovy + operator incorrectly rounds to integer result" () {
        when: "We add two NumberValues using the '+' operator and the Groovy Number.plus() method"
        NumberValue value1 = Money.of(10, "USD").number
        NumberValue value2 = Money.of(0.99, "USD").number
        def sum = value1 + value2

        then: "We get an incorrect answer - rounded to Integer"
        sum == 10.00    // TODO: Fix this with either upstream changes and/or Groovy category
    }

    def "Add number values and convert from Integer to new NumberValue" () {
        when: "We add two NumberValues using the default Groovy Number.plus() method"
        NumberValue value1 = Money.of(10, "USD").number
        NumberValue value2 = Money.of(1, "USD").number
        def sumInteger = value1 + value2

        and: "We convert the type"
        def sum = DefaultNumberValue.of(sumInteger)

        then: "We get an implementation of NumberValue"
        sum == 11
        sum.class == DefaultNumberValue.class
    }
}
