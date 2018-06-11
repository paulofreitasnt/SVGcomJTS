package com.ifpb.exemplojts.control;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

public class SvgFactory {

    public static String getSvg(Geometry geometria) {
        StringBuilder svg = new StringBuilder();

        Coordinate[] coordinates = geometria.getCoordinates();

        svg.append("M");
        svg.append((coordinates[0].x));
        svg.append(" ");
        svg.append((coordinates[0].y));

        svg.append(" ");

        for (Coordinate c : coordinates) {
            svg.append("L");
            svg.append(c.x);
            svg.append(" ");
            svg.append(c.y);
            svg.append(" ");
        }

        svg.append("Z");

        return svg.toString();
    }

}
