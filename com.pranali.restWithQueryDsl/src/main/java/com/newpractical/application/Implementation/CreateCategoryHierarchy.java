package com.newpractical.application.Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CreateCategoryHierarchy {
	
	List<CategoryToJson> listOfCat;
	public CreateCategoryHierarchy() {
	}
	
	public CreateCategoryHierarchy(List<CategoryStructure> listOfObj) {
		super();
		System.out.println(listOfCat);
	}
	
	public List<CategoryToJson> createTree(List<CategoryStructure> listOfObj){
		Map<Integer, List<Integer>> parentChildMap = new HashMap<Integer, List<Integer>>();
		Map<Integer, CategoryStructure> objectMap = new HashMap<Integer, CategoryStructure>();;
		for(CategoryStructure c: listOfObj)
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

	public CategoryToJson createCategoryToJsonObject(CategoryStructure cat, Map<Integer,List<Integer>> parentChildMap, Map<Integer, CategoryStructure> objectMap){
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
		new CreateCategoryHierarchy();
	}
	
	

}
