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

import static tec.units.ri.unit.Units.*;

import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import tec.units.ri.AbstractSystemOfUnits;
import tec.units.ri.format.SimpleUnitFormat;

/**
 * <p>
 * This class contains units from the 'Guardians of the Galaxy' film.
 * </p>
 * <p>
 * 
 * @noextend This class is not intended to be extended by clients.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.1, $Date: 2016-11-23 $
 * @see <a href=
 *      "https://www.reddit.com/r/Marvel/comments/1ye9ty/i_calculated_the_heights_and_weights_of_the/">Reddit:
 *      I calculated the heights and weights of the Guardians Of The Galaxy</a>
 */
public final class GuardiansOfTheGalaxy extends AbstractSystemOfUnits {
    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private GuardiansOfTheGalaxy() {
    }

    /**
     * The singleton instance of {@code GuardiansOfTheGalaxy}.
     */
    private static final GuardiansOfTheGalaxy INSTANCE = new GuardiansOfTheGalaxy();

    @Override
    public String getName() {
	return "Units of measurement from 'Guardians of the Galaxy'";
    }

    /**
     * Adds a new unit not mapped to any specified quantity type.
     *
     * @param unit
     *            the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit) {
	INSTANCE.units.add(unit);
	return unit;
    }

    /**
     * <code>1 bule = 7589m</code> (standard name
     * <code>bul</code>).
     */
    public static final Unit<Length> BULE = addUnit(METRE.multiply(7589));

    /**
     * <code>1 gret = 0.027kg</code> (standard name
     * <code>grt</code>).
     */
    public static final Unit<Mass> GRET = addUnit(KILOGRAM.multiply(0.027));

    // //////////////////////////////////////////////////////////////////////////
    // Label adjustments for Guardian system
    static {
	SimpleUnitFormat.getInstance().label(BULE, "bul");
	SimpleUnitFormat.getInstance().label(GRET, "grt");
    }
}
