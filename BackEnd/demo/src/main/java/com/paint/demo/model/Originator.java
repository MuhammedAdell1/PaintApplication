package com.paint.demo.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement(name = "originator")
@XmlAccessorType(XmlAccessType.FIELD)
public class Originator {

	@XmlElement(name = "shape")
	private ArrayList<Shape> shapes = new ArrayList<>();

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void addShape(Shape shape) {
		this.shapes.add(shape);
	}

	public ArrayList<Shape> get() throws CloneNotSupportedException {
		ArrayList<Shape> clonedShapes = new ArrayList<>();
    for (Shape shape : this.shapes)
      clonedShapes.add((Shape) shape.clone());
		return clonedShapes;
	}

	public Memento save() throws CloneNotSupportedException {
		return new Memento(this.get());
	}

	public void restore(Memento memento) {
		this.shapes = memento.shapes();
	}

	public void create() {
		this.shapes = new ArrayList<>();
  }
}
