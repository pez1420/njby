package com.njby;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/***
 * 页面前端排序功能模块
 * 
 * @author pez1420
 *
 */
public class Order implements Serializable {

	private static final long serialVersionUID = -2652336033549972886L;
	
	public enum Direction {
		asc, desc;

		public static Direction fromString(String value) {
			return valueOf(value.toLowerCase());
		}
	}
	
	private String property;
	private Direction direction = Direction.desc;

	public Order() { }

	public Order(String property, Direction direction) {
		this.property = property;
		this.direction = direction;
	}

	public static Order asc(String property) {
		return new Order(property, Direction.asc);
	}

	public static Order desc(String property) {
		return new Order(property, Direction.desc);
	}

	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Direction getDirection() {
		return this.direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		if (this == obj)
			return true;
		
		Order order = (Order) obj;
		return new EqualsBuilder()
				.append(getProperty(), order.getProperty())
				.append(getDirection(), order.getDirection()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(getProperty())
				.append(getDirection()).toHashCode();
	}
}
