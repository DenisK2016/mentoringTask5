package com.dk.mentoring.pattern.compositesample;

public class MainClass
{
	public static void main(final String[] args)
	{
		final Product product1 = new TrousersProduct("Trousers adidas");
		final Product product2 = new TrousersProduct("Trousers nike");
		final Product product3 = new TshirtProduct("T-shirt adidas");
		final Product product4 = new TshirtProduct("T-shirt nike");

		final CompositeProduct composite = new CompositeProduct();
		composite.addProduct(product1);
		composite.addProduct(product2);
		composite.addProduct(product3);
		composite.addProduct(product4);

		composite.print();
	}
}
