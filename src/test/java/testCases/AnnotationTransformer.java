package testCases;

import retryTest.RetryAnalyzer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import retryTest.RetryAnalyzer;

public class AnnotationTransformer implements IAnnotationTransformer{

	public void transformer(ITestAnnotation annotation, Class testClass, Constructor testConstructor,Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}