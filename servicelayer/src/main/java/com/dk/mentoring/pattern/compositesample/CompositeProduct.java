package com.dk.mentoring.pattern.compositesample;

import java.util.ArrayList;
import java.util.List;


public class CompositeProduct implements Product
{

	private final List<Product> products = new ArrayList<>();

	@Override
	public void print()
	{
		for (final Product product : products)
		{
			product.print();
		}
	}

	public void addProduct(final Product product)
	{
		this.products.add(product);
	}

	public void removeProduct(final Product product)
	{
		this.products.remove(product);
	}
}
