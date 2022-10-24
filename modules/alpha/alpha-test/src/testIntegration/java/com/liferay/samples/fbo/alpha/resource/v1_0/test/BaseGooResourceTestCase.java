package com.liferay.samples.fbo.alpha.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.samples.fbo.alpha.client.dto.v1_0.Goo;
import com.liferay.samples.fbo.alpha.client.http.HttpInvoker;
import com.liferay.samples.fbo.alpha.client.pagination.Page;
import com.liferay.samples.fbo.alpha.client.resource.v1_0.GooResource;
import com.liferay.samples.fbo.alpha.client.serdes.v1_0.GooSerDes;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Fabian-Liferay
 * @generated
 */
@Generated("")
public abstract class BaseGooResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_gooResource.setContextCompany(testCompany);

		GooResource.Builder builder = GooResource.builder();

		gooResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Goo goo1 = randomGoo();

		String json = objectMapper.writeValueAsString(goo1);

		Goo goo2 = GooSerDes.toDTO(json);

		Assert.assertTrue(equals(goo1, goo2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Goo goo = randomGoo();

		String json1 = objectMapper.writeValueAsString(goo);
		String json2 = GooSerDes.toJSON(goo);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Goo goo = randomGoo();

		goo.setDescription(regex);
		goo.setName(regex);

		String json = GooSerDes.toJSON(goo);

		Assert.assertFalse(json.contains(regex));

		goo = GooSerDes.toDTO(json);

		Assert.assertEquals(regex, goo.getDescription());
		Assert.assertEquals(regex, goo.getName());
	}

	@Test
	public void testGetFooGoosPage() throws Exception {
		Long fooId = testGetFooGoosPage_getFooId();
		Long irrelevantFooId = testGetFooGoosPage_getIrrelevantFooId();

		Page<Goo> page = gooResource.getFooGoosPage(fooId);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantFooId != null) {
			Goo irrelevantGoo = testGetFooGoosPage_addGoo(
				irrelevantFooId, randomIrrelevantGoo());

			page = gooResource.getFooGoosPage(irrelevantFooId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantGoo), (List<Goo>)page.getItems());
			assertValid(page);
		}

		Goo goo1 = testGetFooGoosPage_addGoo(fooId, randomGoo());

		Goo goo2 = testGetFooGoosPage_addGoo(fooId, randomGoo());

		page = gooResource.getFooGoosPage(fooId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(goo1, goo2), (List<Goo>)page.getItems());
		assertValid(page);

		gooResource.deleteGoo(goo1.getId());

		gooResource.deleteGoo(goo2.getId());
	}

	protected Goo testGetFooGoosPage_addGoo(Long fooId, Goo goo)
		throws Exception {

		return gooResource.postFooGoo(fooId, goo);
	}

	protected Long testGetFooGoosPage_getFooId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetFooGoosPage_getIrrelevantFooId() throws Exception {
		return null;
	}

	@Test
	public void testPostFooGoo() throws Exception {
		Goo randomGoo = randomGoo();

		Goo postGoo = testPostFooGoo_addGoo(randomGoo);

		assertEquals(randomGoo, postGoo);
		assertValid(postGoo);
	}

	protected Goo testPostFooGoo_addGoo(Goo goo) throws Exception {
		return gooResource.postFooGoo(testGetFooGoosPage_getFooId(), goo);
	}

	@Test
	public void testDeleteGoo() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Goo goo = testDeleteGoo_addGoo();

		assertHttpResponseStatusCode(
			204, gooResource.deleteGooHttpResponse(goo.getId()));

		assertHttpResponseStatusCode(
			404, gooResource.getGooHttpResponse(goo.getId()));

		assertHttpResponseStatusCode(404, gooResource.getGooHttpResponse(0L));
	}

	protected Goo testDeleteGoo_addGoo() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteGoo() throws Exception {
		Goo goo = testGraphQLGoo_addGoo();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteGoo",
						new HashMap<String, Object>() {
							{
								put("gooId", goo.getId());
							}
						})),
				"JSONObject/data", "Object/deleteGoo"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"goo",
					new HashMap<String, Object>() {
						{
							put("gooId", goo.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetGoo() throws Exception {
		Goo postGoo = testGetGoo_addGoo();

		Goo getGoo = gooResource.getGoo(postGoo.getId());

		assertEquals(postGoo, getGoo);
		assertValid(getGoo);
	}

	protected Goo testGetGoo_addGoo() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetGoo() throws Exception {
		Goo goo = testGraphQLGoo_addGoo();

		Assert.assertTrue(
			equals(
				goo,
				GooSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"goo",
								new HashMap<String, Object>() {
									{
										put("gooId", goo.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/goo"))));
	}

	@Test
	public void testGraphQLGetGooNotFound() throws Exception {
		Long irrelevantGooId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"goo",
						new HashMap<String, Object>() {
							{
								put("gooId", irrelevantGooId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPatchGoo() throws Exception {
		Goo postGoo = testPatchGoo_addGoo();

		Goo randomPatchGoo = randomPatchGoo();

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Goo patchGoo = gooResource.patchGoo(postGoo.getId(), randomPatchGoo);

		Goo expectedPatchGoo = postGoo.clone();

		_beanUtilsBean.copyProperties(expectedPatchGoo, randomPatchGoo);

		Goo getGoo = gooResource.getGoo(patchGoo.getId());

		assertEquals(expectedPatchGoo, getGoo);
		assertValid(getGoo);
	}

	protected Goo testPatchGoo_addGoo() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutGoo() throws Exception {
		Goo postGoo = testPutGoo_addGoo();

		Goo randomGoo = randomGoo();

		Goo putGoo = gooResource.putGoo(postGoo.getId(), randomGoo);

		assertEquals(randomGoo, putGoo);
		assertValid(putGoo);

		Goo getGoo = gooResource.getGoo(putGoo.getId());

		assertEquals(randomGoo, getGoo);
		assertValid(getGoo);
	}

	protected Goo testPutGoo_addGoo() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Goo testGraphQLGoo_addGoo() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(Goo goo, List<Goo> goos) {
		boolean contains = false;

		for (Goo item : goos) {
			if (equals(goo, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(goos + " does not contain " + goo, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Goo goo1, Goo goo2) {
		Assert.assertTrue(goo1 + " does not equal " + goo2, equals(goo1, goo2));
	}

	protected void assertEquals(List<Goo> goos1, List<Goo> goos2) {
		Assert.assertEquals(goos1.size(), goos2.size());

		for (int i = 0; i < goos1.size(); i++) {
			Goo goo1 = goos1.get(i);
			Goo goo2 = goos2.get(i);

			assertEquals(goo1, goo2);
		}
	}

	protected void assertEqualsIgnoringOrder(List<Goo> goos1, List<Goo> goos2) {
		Assert.assertEquals(goos1.size(), goos2.size());

		for (Goo goo1 : goos1) {
			boolean contains = false;

			for (Goo goo2 : goos2) {
				if (equals(goo1, goo2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(goos2 + " does not contain " + goo1, contains);
		}
	}

	protected void assertValid(Goo goo) throws Exception {
		boolean valid = true;

		if (goo.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (goo.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fooId", additionalAssertFieldName)) {
				if (goo.getFooId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (goo.getName() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Goo> page) {
		boolean valid = false;

		java.util.Collection<Goo> goos = page.getItems();

		int size = goos.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.liferay.samples.fbo.alpha.dto.v1_0.Goo.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Goo goo1, Goo goo2) {
		if (goo1 == goo2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						goo1.getDescription(), goo2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fooId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(goo1.getFooId(), goo2.getFooId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(goo1.getId(), goo2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(goo1.getName(), goo2.getName())) {
					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_gooResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_gooResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Goo goo) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(goo.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fooId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(goo.getName()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Goo randomGoo() throws Exception {
		return new Goo() {
			{
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				fooId = RandomTestUtil.randomLong();
				id = RandomTestUtil.randomLong();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Goo randomIrrelevantGoo() throws Exception {
		Goo randomIrrelevantGoo = randomGoo();

		return randomIrrelevantGoo;
	}

	protected Goo randomPatchGoo() throws Exception {
		return randomGoo();
	}

	protected GooResource gooResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseGooResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.samples.fbo.alpha.resource.v1_0.GooResource
		_gooResource;

}