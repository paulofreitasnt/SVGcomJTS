package com.ifpb.exemplojts.control;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

public class ViewBox {

    private Geometry geom1;
    private Geometry geom2;

    public ViewBox(Geometry geom1, Geometry geom2) {
        this.geom1 = geom1;
        this.geom2 = geom2;
    }

    public String getViewBox() {
        Geometry uniao = geom1.union(geom2);
        Geometry envelope = uniao.getEnvelope();

        StringBuilder builder = new StringBuilder();
        
        builder.append(getXMin(envelope));
        builder.append(" ");
        builder.append(getYMin(envelope));
        builder.append(" ");
        builder.append(getXMax(envelope)-getXMin(envelope));
        builder.append(" ");
        builder.append(getYMax(envelope)-getYMin(envelope));
        
        return builder.toString();
        
    }

    private double getXMin(Geometry envelope) {
        Coordinate coordenadas[] = envelope.getCoordinates();

        double xMin = coordenadas[0].x;

        for (Coordinate c : coordenadas) {
            if (c.x < xMin) {
                xMin = c.x;
            }
        }
        return xMin;
    }

    private double getXMax(Geometry envelope) {
        Coordinate coordenadas[] = envelope.getCoordinates();

        double xMax = coordenadas[0].x;

        for (Coordinate c : coordenadas) {
            if (c.x > xMax) {
                xMax = c.x;
            }
        }
        return xMax;
    }

    private double getYMin(Geometry envelope) {
        Coordinate coordenadas[] = envelope.getCoordinates();

        double yMin = coordenadas[0].y;

        for (Coordinate c : coordenadas) {
            if (c.y < yMin) {
                yMin = c.y;
            }
        }
        return yMin;
    }

    private double getYMax(Geometry envelope) {
        Coordinate coordenadas[] = envelope.getCoordinates();

        double yMax = coordenadas[0].y;

        for (Coordinate c : coordenadas) {
            if (c.y > yMax) {
                yMax = c.y;
            }
        }
        return yMax;
    }

}
