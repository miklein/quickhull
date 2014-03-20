package de.enteryourname.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;

import de.enteryourname.hs.algolab.convexhull.Point2D;

public class DefinedDataset implements Dataset {
	
	private ArrayList<Point2D> points = new ArrayList<Point2D>();

	@Override
	public void regeneratePoints(int amount) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Point2D> getPoints() {
		// TODO Auto-generated method stub
		return this.points;
	}
	
	public DefinedDataset(ArrayList<Point2D> points) {
		this.points = points;
	}
	
}
