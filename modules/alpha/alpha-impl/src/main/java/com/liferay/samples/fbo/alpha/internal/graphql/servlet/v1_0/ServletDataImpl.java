package com.liferay.samples.fbo.alpha.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;
import com.liferay.samples.fbo.alpha.internal.graphql.mutation.v1_0.Mutation;
import com.liferay.samples.fbo.alpha.internal.graphql.query.v1_0.Query;
import com.liferay.samples.fbo.alpha.resource.v1_0.FooResource;
import com.liferay.samples.fbo.alpha.resource.v1_0.GooResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Fabian-Liferay
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setFooResourceComponentServiceObjects(
			_fooResourceComponentServiceObjects);
		Mutation.setGooResourceComponentServiceObjects(
			_gooResourceComponentServiceObjects);

		Query.setFooResourceComponentServiceObjects(
			_fooResourceComponentServiceObjects);
		Query.setGooResourceComponentServiceObjects(
			_gooResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/alpha-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<FooResource>
		_fooResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<GooResource>
		_gooResourceComponentServiceObjects;

}