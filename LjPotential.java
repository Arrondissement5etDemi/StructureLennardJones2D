import java.util.*;
/**
A class that computes the Lennard-Jones potential
@author Haina Wang (Studio-Darboux-Carbonnier)
*/

public class LjPotential {
	public static double rc = 12.0;//cutoff distance
	static double urc = -0.0163169; //u(2.5)

	/** computes the LJ-potential given r, r0, e (see parameter descriptions)
 	@param r double, the internuclear distance variable
	@param r0 double, the minimum-energy internuclear distance
	@param e double, the depth of the energy well
	@return double, the LJ potential at internuclear distance r */
	public static double ljClassic(double r, double r0, double e) {
		double r0DivR = r0/r;
		double result = 4*e*(Math.pow(r0DivR,12)-Math.pow(r0DivR,6));
		return result;
	}

	/** computes the LJ-potential given r, and r0 and e are all set to 1
        @param r double, the internuclear distance variable
        @return double, the LJ potential at internuclear distance r */
        public static double lj(double r) {
		double pow2 = 1.0/(r*r);
		double pow6 = pow2*pow2*pow2;
		return 4*pow6*(pow6-1.0);
	}

	/**computes the force-shifted LJ potential as in Errington JCP 2003; cutoff dist = 2.5
 * 	@param r double, the scaled internuclear distance
 * 	@return double, the shifted force LJ potential in units of epsilon */
	public static double sflj(double r) {
		if (r >= rc) {
			return 0;
		}
		/** double uprc = 0.0389995; //u'(2.5), the derivative at rc*/
		double result = lj(r) - urc;
		return result;
	}
}
