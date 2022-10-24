package com.liferay.samples.fbo.alpha.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.samples.fbo.alpha.dto.v1_0.Foo;
import com.liferay.samples.fbo.alpha.resource.v1_0.FooResource;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Fabian-Liferay
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/foo.properties",
	scope = ServiceScope.PROTOTYPE, service = FooResource.class
)
public class FooResourceImpl extends BaseFooResourceImpl {

	@Override
	public void setContextBatchUnsafeConsumer(
			UnsafeBiConsumer<Collection<Foo>, UnsafeConsumer<Foo, Exception>, Exception> contextBatchUnsafeConsumer) {
		this.contextBatchUnsafeConsumer = contextBatchUnsafeConsumer;
		
	}

	protected UnsafeBiConsumer
	<java.util.Collection<Foo>, UnsafeConsumer<Foo, Exception>,	 Exception> contextBatchUnsafeConsumer;

	@Override
	public Foo getFoo(@NotNull Long fooId) throws Exception {
		Foo foo = new Foo();
		foo.setId(fooId);
		foo.setDescription("Foo description");
		foo.setName("Foo name " + fooId);
		return foo;
	}
	
}