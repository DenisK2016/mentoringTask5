package com.dk.mentoring.web.classloader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;


@Controller
public class ClassGeneratorController
{

	private JavaFile carInterface;
	private JavaFile carAudi;
	private JavaFile carVW;
	final File file = new File("D:\\Programs\\Eclipse\\workspace\\mentoring\\mentoringTask2\\weblayer\\src\\main\\java");
	private final Map<String, String> classes = new HashMap<>();
	private String audiEngine = "";
	private String vwEngine = "";
	private Object vwObj;
	private Object audiObj;

	@RequestMapping("/car")
	public String interfaceGenerate(final Map<String, Object> map)
	{

		for (final Map.Entry<String, String> entry : classes.entrySet())
		{
			final String string = entry.getValue().replaceAll("\n", "<br>");
			map.put(entry.getKey(), string);
		}
		return "classGenerator";
	}

	@RequestMapping("/addcar/")
	public String addCarInterface()
	{
		final MethodSpec start = MethodSpec.methodBuilder("start").addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).build();
		final MethodSpec stop = MethodSpec.methodBuilder("stop").addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).build();
		final TypeSpec car = TypeSpec.interfaceBuilder("Car").addModifiers(Modifier.PUBLIC).addMethod(start).addMethod(stop)
				.build();
		this.carInterface = JavaFile.builder("com.dk.mentoring.javapoet.gen", car).build();
		if (!this.file.exists())
		{
			this.file.mkdirs();
		}
		try
		{
			this.carInterface.writeTo(this.file);
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
		this.classes.put("car", this.carInterface.toString());
		return "redirect:/car";
	}

	@RequestMapping("/audi/")
	public String audiGenerate()
	{
		final List<MethodSpec> methods = this.carInterface.typeSpec.methodSpecs;
		final List<MethodSpec> methodsImpl = new ArrayList<>();
		for (final MethodSpec method : methods)
		{
			if ("start".equals(method.name))
			{
				methodsImpl.add(MethodSpec.methodBuilder(method.name).addAnnotation(Override.class).addModifiers(Modifier.PUBLIC)
						.returns(method.returnType).addStatement("setEngine(\"start\")").build());
			}
			else if ("stop".equals(method.name))
			{
				methodsImpl.add(MethodSpec.methodBuilder(method.name).addAnnotation(Override.class).addModifiers(Modifier.PUBLIC)
						.returns(method.returnType).addStatement("setEngine(\"stop\")").build());
			}
		}

		methodsImpl.add(MethodSpec.methodBuilder("getEngine").addModifiers(Modifier.PUBLIC).returns(String.class)
				.addStatement("return this.engine").build());
		methodsImpl.add(MethodSpec.methodBuilder("setEngine").addModifiers(Modifier.PUBLIC)
				.addParameter(String.class, "engine", Modifier.FINAL).addStatement("this.engine = engine").build());
		final TypeSpec audi = TypeSpec.classBuilder("Audi")
				.addSuperinterface(ClassName.get(this.carInterface.packageName, this.carInterface.typeSpec.name))
				.addModifiers(Modifier.PUBLIC).addField(String.class, "engine", Modifier.PRIVATE).addMethods(methodsImpl).build();
		this.carAudi = JavaFile.builder("com.dk.mentoring.javapoet.gen.impl", audi).build();
		try
		{
			this.carAudi.writeTo(file);
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
		Compiler.compile(new File("D:\\Programs\\Eclipse\\workspace\\mentoring\\mentoringTask2\\weblayer\\src\\main\\resources"),
				this.carAudi.toJavaFileObject(), this.carInterface.toJavaFileObject());
		this.classes.put("audi", this.carAudi.toString());
		return "redirect:/car";
	}

	@RequestMapping("/vw/")
	public String vwGenerate()
	{
		final List<MethodSpec> methods = this.carInterface.typeSpec.methodSpecs;
		final List<MethodSpec> methodsImpl = new ArrayList<>();
		for (final MethodSpec method : methods)
		{
			if ("start".equals(method.name))
			{
				methodsImpl.add(MethodSpec.methodBuilder(method.name).addAnnotation(Override.class).addModifiers(Modifier.PUBLIC)
						.returns(method.returnType).addStatement("setEngine(\"start\")").build());
			}
			else if ("stop".equals(method.name))
			{
				methodsImpl.add(MethodSpec.methodBuilder(method.name).addAnnotation(Override.class).addModifiers(Modifier.PUBLIC)
						.returns(method.returnType).addStatement("setEngine(\"stop\")").build());
			}
		}
		methodsImpl.add(MethodSpec.methodBuilder("getEngine").addModifiers(Modifier.PUBLIC).returns(String.class)
				.addStatement("return this.engine").build());
		methodsImpl.add(MethodSpec.methodBuilder("setEngine").addModifiers(Modifier.PUBLIC)
				.addParameter(String.class, "engine", Modifier.FINAL).addStatement("this.engine = engine").build());
		final TypeSpec audi = TypeSpec.classBuilder("Volkswagen")
				.addSuperinterface(ClassName.get(this.carInterface.packageName, this.carInterface.typeSpec.name))
				.addModifiers(Modifier.PUBLIC).addField(String.class, "engine", Modifier.PRIVATE).addMethods(methodsImpl).build();
		this.carVW = JavaFile.builder("com.dk.mentoring.javapoet.gen.impl", audi).build();
		try
		{
			this.carVW.writeTo(file);
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
		Compiler.compile(new File("D:\\Programs\\Eclipse\\workspace\\mentoring\\mentoringTask2\\weblayer\\src\\main\\resources"),
				this.carVW.toJavaFileObject(), this.carInterface.toJavaFileObject());
		this.classes.put("vw", this.carVW.toString());
		return "redirect:/car";
	}

	@RequestMapping("/startAudi/")
	public String startAudi()
	{
		try
		{
			setAudiObject();
			this.audiEngine = performMethod("start", this.audiObj);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		this.classes.put("audiEngineStart", this.audiEngine);
		this.classes.put("audiEngineStop", "");
		return "redirect:/car";
	}

	@RequestMapping("/stopAudi/")
	public String stopAudi()
	{
		try
		{
			setAudiObject();
			this.audiEngine = performMethod("stop", this.audiObj);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		this.classes.put("audiEngineStart", "");
		this.classes.put("audiEngineStop", this.audiEngine);
		return "redirect:/car";
	}

	protected void setAudiObject() throws MalformedURLException, InstantiationException, IllegalAccessException,
			ClassNotFoundException
	{
		if (null == this.audiObj)
		{
			final CarTestClassLoader classLoader = new CarTestClassLoader(this.getClass().getClassLoader());
			this.audiObj = classLoader.loadClass("com.dk.mentoring.javapoet.gen.impl.Audi").newInstance();
		}
	}

	@RequestMapping("/startVW/")
	public String startVW()
	{
		try
		{
			setVolkswagenObject();
			this.vwEngine = performMethod("start", this.vwObj);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		this.classes.put("vwEngineStart", this.vwEngine);
		this.classes.put("vwEngineStop", "");
		return "redirect:/car";
	}

	@RequestMapping("/stopVW/")
	public String stopVW()
	{
		try
		{
			setVolkswagenObject();
			this.vwEngine = performMethod("stop", this.vwObj);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		this.classes.put("vwEngineStart", "");
		this.classes.put("vwEngineStop", this.vwEngine);
		return "redirect:/car";
	}

	protected void setVolkswagenObject() throws MalformedURLException, InstantiationException, IllegalAccessException,
			ClassNotFoundException
	{
		if (null == this.vwObj)
		{
			final CarTestClassLoader classLoader = new CarTestClassLoader(this.getClass().getClassLoader());
			this.vwObj = classLoader.loadClass("com.dk.mentoring.javapoet.gen.impl.Volkswagen").newInstance();
		}
	}

	protected String performMethod(final String methodName, final Object object) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException
	{
		object.getClass().getMethod(methodName).invoke(object);
		return (String) object.getClass().getMethod("getEngine").invoke(object);
	}
}
