package com.liferay.samples.fbo.alpha.client.serdes.v1_0;

import com.liferay.samples.fbo.alpha.client.dto.v1_0.Goo;
import com.liferay.samples.fbo.alpha.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Fabian-Liferay
 * @generated
 */
@Generated("")
public class GooSerDes {

	public static Goo toDTO(String json) {
		GooJSONParser gooJSONParser = new GooJSONParser();

		return gooJSONParser.parseToDTO(json);
	}

	public static Goo[] toDTOs(String json) {
		GooJSONParser gooJSONParser = new GooJSONParser();

		return gooJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Goo goo) {
		if (goo == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (goo.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(goo.getDescription()));

			sb.append("\"");
		}

		if (goo.getFooId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fooId\": ");

			sb.append(goo.getFooId());
		}

		if (goo.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(goo.getId());
		}

		if (goo.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(goo.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		GooJSONParser gooJSONParser = new GooJSONParser();

		return gooJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Goo goo) {
		if (goo == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (goo.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(goo.getDescription()));
		}

		if (goo.getFooId() == null) {
			map.put("fooId", null);
		}
		else {
			map.put("fooId", String.valueOf(goo.getFooId()));
		}

		if (goo.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(goo.getId()));
		}

		if (goo.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(goo.getName()));
		}

		return map;
	}

	public static class GooJSONParser extends BaseJSONParser<Goo> {

		@Override
		protected Goo createDTO() {
			return new Goo();
		}

		@Override
		protected Goo[] createDTOArray(int size) {
			return new Goo[size];
		}

		@Override
		protected void setField(
			Goo goo, String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					goo.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fooId")) {
				if (jsonParserFieldValue != null) {
					goo.setFooId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					goo.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					goo.setName((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}