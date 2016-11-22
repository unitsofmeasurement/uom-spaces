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
    // Label adjustments for Hungarian system
    static {
	SimpleUnitFormat.getInstance().label(BULE, "bul");
	SimpleUnitFormat.getInstance().label(GRET, "grt");
    }
}
