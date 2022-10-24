package com.liferay.samples.fbo.alpha.internal.graphql.query.v2_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.samples.fbo.alpha.dto.v2_0.Foo;
import com.liferay.samples.fbo.alpha.dto.v2_0.Goo;
import com.liferay.samples.fbo.alpha.resource.v2_0.FooResource;
import com.liferay.samples.fbo.alpha.resource.v2_0.GooResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Fabian-Liferay
 * @generated
 */
@Generated("")
public class Query {

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

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {foo{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public FooPage foo() throws Exception {
		return _applyComponentServiceObjects(
			_fooResourceComponentServiceObjects, this::_populateResourceContext,
			fooResource -> new FooPage(fooResource.getFooPage()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {foo(fooId: ___){description, id, name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Foo foo(@GraphQLName("fooId") Long fooId) throws Exception {
		return _applyComponentServiceObjects(
			_fooResourceComponentServiceObjects, this::_populateResourceContext,
			fooResource -> fooResource.getFoo(fooId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {fooGoos(fooId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public GooPage fooGoos(@GraphQLName("fooId") Long fooId) throws Exception {
		return _applyComponentServiceObjects(
			_gooResourceComponentServiceObjects, this::_populateResourceContext,
			gooResource -> new GooPage(gooResource.getFooGoosPage(fooId)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {goo(gooId: ___){description, fooId, id, name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Goo goo(@GraphQLName("gooId") Long gooId) throws Exception {
		return _applyComponentServiceObjects(
			_gooResourceComponentServiceObjects, this::_populateResourceContext,
			gooResource -> gooResource.getGoo(gooId));
	}

	@GraphQLTypeExtension(Goo.class)
	public class GetFooTypeExtension {

		public GetFooTypeExtension(Goo goo) {
			_goo = goo;
		}

		@GraphQLField
		public Foo foo() throws Exception {
			return _applyComponentServiceObjects(
				_fooResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				fooResource -> fooResource.getFoo(_goo.getFooId()));
		}

		private Goo _goo;

	}

	@GraphQLTypeExtension(Foo.class)
	public class GetFooGoosPageTypeExtension {

		public GetFooGoosPageTypeExtension(Foo foo) {
			_foo = foo;
		}

		@GraphQLField
		public GooPage goos() throws Exception {
			return _applyComponentServiceObjects(
				_gooResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				gooResource -> new GooPage(
					gooResource.getFooGoosPage(_foo.getId())));
		}

		private Foo _foo;

	}

	@GraphQLName("FooPage")
	public class FooPage {

		public FooPage(Page fooPage) {
			actions = fooPage.getActions();

			items = fooPage.getItems();
			lastPage = fooPage.getLastPage();
			page = fooPage.getPage();
			pageSize = fooPage.getPageSize();
			totalCount = fooPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Foo> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("GooPage")
	public class GooPage {

		public GooPage(Page gooPage) {
			actions = gooPage.getActions();

			items = gooPage.getItems();
			lastPage = gooPage.getLastPage();
			page = gooPage.getPage();
			pageSize = gooPage.getPageSize();
			totalCount = gooPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Goo> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}