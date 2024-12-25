package CommonMethods;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestRetryAnalyzerListener implements IAnnotationTransformer {

    /**
     * This method is used to transform the annotations at runtime. It's part of TestNG's
     * IAnnotationTransformer interface, which allows you to modify the behavior of annotations.
     *
     * In this case, it sets the retry logic for tests by attaching the TestRetryAnalyzer to
     * the `@Test` annotation at runtime.
     *
     * @param annotation The `@Test` annotation of the test method.
     * @param testClass The test class where the test method resides.
     * @param testConstructor The constructor for the test class.
     * @param testMethod The test method.
     * @param occurringClazz The class where the annotation is occurring (not usually used).
     */
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod, Class<?> occurringClazz) {
        // Attach the retry analyzer to the test method by setting the retry logic dynamically
        annotation.setRetryAnalyzer(TestRetryAnalyzer.class);
    }
}
