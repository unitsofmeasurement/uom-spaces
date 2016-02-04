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
import spock.lang.Specification
import spock.lang.Unroll
import spock.util.mop.Use

import javax.measure.Unit

/**
 * Test of operators added by UnitCategory
 */
class UnitCategorySpec extends Specification {

    @Unroll
    def "#sum = #left  + #right (nv(#left.class) + nv(#right.class))" () {
        expect:
        sum == DefaultNumberValue.of(left) + DefaultNumberValue.of(right)

        where:
        left  | right  | sum
          10  |     1  |   11
          10G |     1G |   11
        10.1G |   0.9G |   11
        Integer.MAX_VALUE | Integer.MAX_VALUE | ((Long)Integer.MAX_VALUE) + Integer.MAX_VALUE
        Long.MAX_VALUE | Long.MAX_VALUE | new BigInteger(Long.MAX_VALUE) + new BigInteger(Long.MAX_VALUE)
    }

    @Unroll
    def "#sum = #left  + #right (nv(#left.class) + #right.class)" () {
        expect:
        sum == DefaultNumberValue.of(left) + right

        where:
        left  | right  | sum
        10  |     1  |   11
        10G |     1G |   11
        10.1G |   0.9G |   11
        Integer.MAX_VALUE | Integer.MAX_VALUE | ((Long)Integer.MAX_VALUE) + Integer.MAX_VALUE
        Long.MAX_VALUE | Long.MAX_VALUE | new BigInteger(Long.MAX_VALUE) + new BigInteger(Long.MAX_VALUE)
    }


    @Unroll
    def "#diff = #left  - #right (#left.class - #right.class)" () {
        expect:
        diff == DefaultNumberValue.of(left) - DefaultNumberValue.of(right)

        where:
        left  | right  | diff
          10  |     1  |    9
          10G |     1G |    9
         9.9G |   0.9G |    9
    }

}