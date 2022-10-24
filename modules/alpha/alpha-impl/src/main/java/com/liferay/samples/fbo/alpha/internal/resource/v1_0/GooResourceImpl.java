package com.liferay.samples.fbo.alpha.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.samples.fbo.alpha.dto.v1_0.Foo;
import com.liferay.samples.fbo.alpha.dto.v1_0.Goo;
import com.liferay.samples.fbo.alpha.resource.v1_0.GooResource;

import java.util.Collection;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Fabian-Liferay
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/goo.properties",
	scope = ServiceScope.PROTOTYPE, service = GooResource.class
)
public class GooResourceImpl extends BaseGooResourceImpl {

	@Override
	public void setContextBatchUnsafeConsumer(
			UnsafeBiConsumer<Collection<Goo>, UnsafeConsumer<Goo, Exception>, Exception> contextBatchUnsafeConsumer) {
		this.contextBatchUnsafeConsumer = contextBatchUnsafeConsumer;
		
	}
	
	protected UnsafeBiConsumer
	<java.util.Collection<Goo>, UnsafeConsumer<Goo, Exception>,	 Exception> contextBatchUnsafeConsumer;
	
}