package com.dk.mentoring.web.classloader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


public class Compiler
{

	//	private static final String RESOURCES = "D:\\Programs\\Eclipse\\workspace\\mentoring\\mentoringTask2\\weblayer\\src\\main\\resources";
	//	private static final String CLASSES = "D:\\Programs\\Eclipse\\workspace\\mentoring\\mentoringTask2\\weblayer\\target\\classes";

	public static void compile(final File file, final JavaFileObject... objects)
	{
		System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.8.0_111");
		final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		final DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		final StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, Locale.getDefault(), null);

		final Iterable<? extends JavaFileObject> compilationUnits = new ArrayList<JavaFileObject>(Arrays.asList(objects));

		String[] compileOptions = null;
		compileOptions = new String[]
		{ "-d", file.getAbsolutePath() };
		final Iterable compilationOptions = Arrays.asList(compileOptions);
		final JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, compilationOptions, null,
				compilationUnits);
		final boolean result = task.call();
		if (result)
		{
			System.out.println("Compilation was successful");
		}
		else
		{
			System.out.println("Compilation failed");
		}
		try
		{
			fileManager.close();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}

		for (final JavaFileObject object : objects)
		{
			final File newFile = new File(file.getAbsolutePath() + File.separatorChar + object.getName().replace(".java", ".test"));
			final File oldFile = new File(file.getAbsolutePath() + File.separatorChar + object.getName().replace(".java", ".class"));
			oldFile.renameTo(newFile);
		}
	}
}
