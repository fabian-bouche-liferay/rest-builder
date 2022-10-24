package com.liferay.samples.fbo.alpha.internal.graphql.mutation.v2_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.samples.fbo.alpha.dto.v2_0.Foo;
import com.liferay.samples.fbo.alpha.dto.v2_0.Goo;
import com.liferay.samples.fbo.alpha.resource.v2_0.FooResource;
import com.liferay.samples.fbo.alpha.resource.v2_0.GooResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Fabian-Liferay
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setFooResourceComponentServiceObjects(
		ComponentServiceObjects<FooResource>
			fooResourceComponentServiceObjects) {

		_fooResourceComponentServiceObjects =
			fooResourceComponentServiceObjects;
	}

	public static void setGooResourceComponentServiceObjects(
		ComponentServiceObjects<GooResource>
			gooResourceComponentServiceObjects) {

		_gooResourceComponentServiceObjects =
			gooResourceComponentServiceObjects;
	}

	@GraphQLField
	public Foo createFoo(@GraphQLName("foo") Foo foo) throws Exception {
		return _applyComponentServiceObjects(
			_fooResourceComponentServiceObjects, this::_populateResourceContext,
			fooResource -> fooResource.postFoo(foo));
	}

	@GraphQLField
	public Response createFooBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_fooResourceComponentServiceObjects, this::_populateResourceContext,
			fooResource -> fooResource.postFooBatch(callbackURL, object));
	}

	@GraphQLField
	public boolean deleteFoo(@GraphQLName("fooId") Long fooId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_fooResourceComponentServiceObjects, this::_populateResourceContext,
			fooResource -> fooResource.deleteFoo(fooId));

		return true;
	}

	@GraphQLField
	public Response deleteFooBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_fooResourceComponentServiceObjects, this::_populateResourceContext,
			fooResource -> fooResource.deleteFooBatch(callbackURL, object));
	}

	@GraphQLField
	public Foo patchFoo(
			@GraphQLName("fooId") Long fooId, @GraphQLName("foo") Foo foo)
		throws Exception {

		return _applyComponentServiceObjects(
			_fooResourceComponentServiceObjects, this::_populateResourceContext,
			fooResource -> fooResource.patchFoo(fooId, foo));
	}

	@GraphQLField
	public Foo updateFoo(
			@GraphQLName("fooId") Long fooId, @GraphQLName("foo") Foo foo)
		throws Exception {

		return _applyComponentServiceObjects(
			_fooResourceComponentServiceObjects, this::_populateResourceContext,
			fooResource -> fooResource.putFoo(fooId, foo));
	}

	@GraphQLField
	public Response updateFooBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_fooResourceComponentServiceObjects, this::_populateResourceContext,
			fooResource -> fooResource.putFooBatch(callbackURL, object));
	}

	@GraphQLField
	public Goo createFooGoo(
			@GraphQLName("fooId") Long fooId, @GraphQLName("goo") Goo goo)
		throws Exception {

		return _applyComponentServiceObjects(
			_gooResourceComponentServiceObjects, this::_populateResourceContext,
			gooResource -> gooResource.postFooGoo(fooId, goo));
	}

	@GraphQLField
	public Response createFooGooBatch(
			@GraphQLName("fooId") Long fooId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_gooResourceComponentServiceObjects, this::_populateResourceContext,
			gooResource -> gooResource.postFooGooBatch(
				fooId, callbackURL, object));
	}

	@GraphQLField
	public boolean deleteGoo(@GraphQLName("gooId") Long gooId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_gooResourceComponentServiceObjects, this::_populateResourceContext,
			gooResource -> gooResource.deleteGoo(gooId));

		return true;
	}

	@GraphQLField
	public Response deleteGooBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_gooResourceComponentServiceObjects, this::_populateResourceContext,
			gooResource -> gooResource.deleteGooBatch(callbackURL, object));
	}

	@GraphQLField
	public Goo patchGoo(
			@GraphQLName("gooId") Long gooId, @GraphQLName("goo") Goo goo)
		throws Exception {

		return _applyComponentServiceObjects(
			_gooResourceComponentServiceObjects, this::_populateResourceContext,
			gooResource -> gooResource.patchGoo(gooId, goo));
	}

	@GraphQLField
	public Goo updateGoo(
			@GraphQLName("gooId") Long gooId, @GraphQLName("goo") Goo goo)
		throws Exception {

		return _applyComponentServiceObjects(
			_gooResourceComponentServiceObjects, this::_populateResourceContext,
			gooResource -> gooResource.putGoo(gooId, goo));
	}

	@GraphQLField
	public Response updateGooBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_gooResourceComponentServiceObjects, this::_populateResourceContext,
			gooResource -> gooResource.putGooBatch(callbackURL, object));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(FooResource fooResource)
		throws Exception {

		fooResource.setContextAcceptLanguage(_acceptLanguage);
		fooResource.setContextCompany(_company);
		fooResource.setContextHttpServletRequest(_httpServletRequest);
		fooResource.setContextHttpServletResponse(_httpServletResponse);
		fooResource.setContextUriInfo(_uriInfo);
		fooResource.setContextUser(_user);
		fooResource.setGroupLocalService(_groupLocalService);
		fooResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(GooResource gooResource)
		throws Exception {

		gooResource.setContextAcceptLanguage(_acceptLanguage);
		gooResource.setContextCompany(_company);
		gooResource.setContextHttpServletRequest(_httpServletRequest);
		gooResource.setContextHttpServletResponse(_httpServletResponse);
		gooResource.setContextUriInfo(_uriInfo);
		gooResource.setContextUser(_user);
		gooResource.setGroupLocalService(_groupLocalService);
		gooResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<FooResource>
		_fooResourceComponentServiceObjects;
	private static ComponentServiceObjects<GooResource>
		_gooResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}