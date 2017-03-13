package com.dk.mentoring.pattern.prototype;

/**
 *
 */
public class SampleCarPrototype implements Cloneable
{
	private String wheel;
	private String steeringWheel;
	private String cabin;
	private String engine;
	private final Owner owner;

	public SampleCarPrototype(final String wheel, final String steeringWheel, final String cabin, final String engine,
			final Owner owner)
	{
		super();
		this.wheel = wheel;
		this.steeringWheel = steeringWheel;
		this.cabin = cabin;
		this.engine = engine;
		this.owner = owner;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		final Owner newOwner = new Owner();
		newOwner.setName(this.owner.getName());
		final SampleCarPrototype clone = new SampleCarPrototype(this.wheel, this.steeringWheel, this.cabin, this.engine, newOwner);
		return clone;
	}

	public String getWheel()
	{
		return wheel;
	}

	public void setWheel(final String wheel)
	{
		this.wheel = wheel;
	}

	public String getSteeringWheel()
	{
		return steeringWheel;
	}

	public void setSteeringWheel(final String steeringWheel)
	{
		this.steeringWheel = steeringWheel;
	}

	public String getCabin()
	{
		return cabin;
	}

	public void setCabin(final String cabin)
	{
		this.cabin = cabin;
	}

	public String getEngine()
	{
		return engine;
	}

	public void setEngine(final String engine)
	{
		this.engine = engine;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public String toString()
	{
		return "SampleCarPrototype [wheel=" + wheel + ", steeringWheel=" + steeringWheel + ", cabin=" + cabin + ", engine="
				+ engine + ", owner=" + owner + "]";
	}

}
