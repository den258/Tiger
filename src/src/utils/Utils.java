package utils;

import consts.Consts;

public class Utils {

	public static Double getRadian(Integer intDegree) {

		return intDegree * ( Math.PI / 180 );

	}

	public static Double getRadian(Double dblDegree) {

		return dblDegree * ( Math.PI / 180.0 );

	}

	public static String getViewName(Integer intViewType) {

		String strReturn = new String();

		switch(intViewType) {

			case Consts.View.INT_FRONT:
				strReturn = "FRONT";
				break;

			case Consts.View.INT_SIDE:
				strReturn = "SIDE";
				break;

			case Consts.View.INT_TOP:
				strReturn = "TOP";
				break;

		}

		return strReturn;

	}

	public static Boolean isClose(Double dblOut, Double dblIn, Double dblError) {

		if (dblOut - dblError <= dblIn && dblIn <= dblOut + dblError) {
			return true;
		} else {
			return false;
		}

	}

}
