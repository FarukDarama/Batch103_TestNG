package techproed.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersRetryAnalyzer implements IAnnotationTransformer {
    //Bu sınıf olusturmamızın amacı tum failed test caseleri otomatik olarak bir kez daha run etmek

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        //Bu sınıf ListenersRetry util classına baglıdır
        annotation.setRetryAnalyzer(ListenersRetry.class);
    }
}
