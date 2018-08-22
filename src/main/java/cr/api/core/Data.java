package cr.api.core;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class Data {
	
	protected JSONObject data;
	
	public Data(JSONObject data) {
		this.data = data;
	}
	
	private <T> T retrieve(String name, boolean op) {
		if (op && !data.has(name))
			return null;
		return (T) data.get(name);
	}
	
	protected <T> T retrieve(String name) {
		return retrieve(name, false);
	}
	
	protected <T> T retrieveOp(String name) {
		return retrieve(name, true);
	}
	
	private <T extends Data> T retrieveData(String name, Class<T> type, boolean op) {
		try {
			if (retrieve(name, op) == null)
				return null;
			return type.getDeclaredConstructor(JSONObject.class).newInstance((JSONObject) retrieve(name));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected <T extends Data> T retrieveData(String name, Class<T> type) {
		return retrieveData(name, type, false);
	}
	
	protected <T extends Data> T retrieveDataOp(String name, Class<T> type) {
		return retrieveData(name, type, true);
	}
	
	private <T extends Data> List<T> retrieveList(String name, Class<T> type, boolean op) {
		if (op && !data.has(name))
			return null;
		JSONArray array = data.getJSONArray(name);
		List<T> list = new ArrayList<>();
		for (int i = 0; i < array.length(); i++) {
			try {
				list.add(type.getDeclaredConstructor(JSONObject.class).newInstance(array.getJSONObject(i)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	protected <T extends Data> List<T> retrieveList(String name, Class<T> type) {
		return retrieveList(name, type, false);
	}
	
	protected <T extends Data> List<T> retrieveListOp(String name, Class<T> type) {
		return retrieveList(name, type, true);
	}
	
	@Override
	public String toString() {
		return data.toString(4);
	}
	
}
