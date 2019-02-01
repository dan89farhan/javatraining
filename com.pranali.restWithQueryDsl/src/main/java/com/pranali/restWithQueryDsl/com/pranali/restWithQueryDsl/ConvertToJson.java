package com.pranali.restWithQueryDsl.com.pranali.restWithQueryDsl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ConvertToJson {
	
	List<CategoryToJson> listOfCat;
	public ConvertToJson() {
	}
	
	public ConvertToJson(List<CategoryCascade> listOfObj) {
		super();
		System.out.println(listOfCat);
	}
	
	public List<CategoryToJson> createTree(List<CategoryCascade> listOfObj){
		Map<Integer, List<Integer>> parentChildMap = new HashMap<Integer, List<Integer>>();
		Map<Integer, CategoryCascade> objectMap = new HashMap<Integer, CategoryCascade>();;
		for(CategoryCascade c: listOfObj)
		{
			if(parentChildMap.containsKey(c.getParentId())){
				parentChildMap.get(c.getParentId()).add(c.getCategoryId());
			}
			else
			{
				List<Integer> catList = new ArrayList<Integer>();
				catList.add(c.getCategoryId());
				parentChildMap.put(c.getParentId(), catList);
			}
			objectMap.put(c.getCategoryId(), c);
		}
		System.out.println(parentChildMap);
		System.out.println(objectMap);
		
		List<CategoryToJson> listCatToJson = new ArrayList<CategoryToJson>();
		for(int i : parentChildMap.keySet()){
			if(i==0)
				continue;
			System.out.println(i);
			System.out.println(objectMap.get(i));
		 listCatToJson.add(createCategoryToJsonObject(objectMap.get(i), parentChildMap, objectMap));
		}
		
		System.out.println(listCatToJson);
		return listCatToJson;
	}

	public CategoryToJson createCategoryToJsonObject(CategoryCascade cat, Map<Integer,List<Integer>> parentChildMap, Map<Integer, CategoryCascade> objectMap){
		CategoryToJson catToJsonObj = new CategoryToJson(cat.getCategoryName(), !parentChildMap.containsKey(cat.getCategoryId()), new ArrayList<CategoryToJson>());
		if(parentChildMap.containsKey(cat.getCategoryId()))
		{
			for(int i : parentChildMap.get(cat.getCategoryId()))
			{
				CategoryToJson obj =  createCategoryToJsonObject(objectMap.get(i), parentChildMap, objectMap);
				catToJsonObj.getChildern().add(obj);
			}
		}
		System.out.println(catToJsonObj);
		return catToJsonObj;
		
	}

	public static void main(String args[])
	{
		new ConvertToJson();
	}
	
	

}
