package io.openems.core.utilities.power;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

public class PSmallerEqualLimitation extends Limitation {

	private Geometry rect;
	private Long p;

	public PSmallerEqualLimitation(SymmetricPower power) {
		super(power);
	}

	public void setP(Long p) {
		if (p != this.p) {
			if (p != null) {
				long pMin = power.getMaxApparentPower() * -1;
				long pMax = p;
				long qMin = power.getMaxApparentPower() * -1;
				long qMax = power.getMaxApparentPower();
				Coordinate[] coordinates = new Coordinate[] { new Coordinate(pMin, qMax), new Coordinate(pMin, qMin),
						new Coordinate(pMax, qMin), new Coordinate(pMax, qMax), new Coordinate(pMin, qMax) };
				rect = SymmetricPowerImpl.getFactory().createPolygon(coordinates);
			} else {
				rect = null;
			}
			this.p = p;
			notifyListeners();
		}
	}

	@Override
	public Geometry applyLimit(Geometry geometry) throws PowerException {
		if (rect != null) {
			Geometry newGeometry = geometry.intersection(this.rect);
			if (newGeometry.isEmpty()) {
				throw new PowerException(
						"The ActivePower limitation is too small! There needs to be at least one point after the limitation.");
			}
			return newGeometry;
		}
		return geometry;
	}

	@Override
	public String toString() {
		return "No activepower above "+p+".";
	}

}
