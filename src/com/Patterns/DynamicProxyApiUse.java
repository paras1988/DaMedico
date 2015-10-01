package com.Patterns;

// Proxy Pattern .. .could be used when you want to lazy-instantiate an object,
// or hide the fact that you're calling a remote service, or
// CONTROL ACCESS OF METHODS.
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class DynamicProxyApiUse {
	public static void main(final String[] args) {
		final SampleService s = (SampleService) AuditProxy.newInstance(new SampleServiceImpl());
		s.read();
	}
}

class AuditProxy implements InvocationHandler {

	private final Object obj;

	public static Object newInstance(final Object obj) {
		return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), new AuditProxy(obj));
	}

	public AuditProxy(final Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(final Object arg0, final Method arg1, final Object[] arg2)
			throws Throwable {
		System.out.println("Start: Inside invoke");
		return null;
	}

}

interface SampleService {

	Sample create(Sample sample);

	List<Sample> read();

	Sample find(int sampleId);

	Sample update(Sample s);
}

class SampleServiceImpl implements SampleService {

	@Override
	public Sample create(final Sample sample) {
		return null;
	}

	@Override
	public List<Sample> read() {
		return null;
	}

	@Override
	public Sample find(final int sampleId) {
		return null;
	}

	@Override
	public Sample update(final Sample s) {
		return null;
	}
}

class SampleService2 {
	SampleService s;

	public SampleService getS() {
		return s;
	}
}

class Sample {
}