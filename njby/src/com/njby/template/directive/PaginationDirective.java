package com.njby.template.directive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.njby.utils.FreemarkerUtils;


import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class PaginationDirective extends BaseDirective{
	private static final String PATTERN = "pattern";
	private static final String PAGE_NUMBER = "pageNumber";
	private static final String TOTAL_PAGES = "totalPages";
	private static final String SEGMENT_COUNT = "segmentCount";
	private static final String HAS_PREVIOUS = "hasPrevious";
	private static final String HAS_NEXT = "hasNext";
	private static final String IS_FIRST = "isFirst";
	private static final String IS_LAST = "isLast";
	private static final String PREVIOUS_PAGE_NUMBER = "previousPageNumber";
	private static final String NEXT_PAGE_NUMBER = "nextPageNumber";
	private static final String FIRST_PAGE_NUMBER = "firstPageNumber";
	private static final String LAST_PAGE_NUMBER = "lastPageNumber";
	private static final String SEGMENT = "segment";
	
	
	@SuppressWarnings("unchecked")
	public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, 
				TemplateModel[] loopVars,
				TemplateDirectiveBody body) throws TemplateException, IOException {

		if (!params.isEmpty()) {
			System.out.println("This directive doesn't allow parameters.");
		}

		if (loopVars.length != 0) {
			System.out.println("This directive doesn't allow loop variables.");
		}

		String pattern = (String) FreemarkerUtils.getParameter(PATTERN,
				String.class, params);
		Integer pageNumber = (Integer) FreemarkerUtils.getParameter(
				PAGE_NUMBER, Integer.class, params);
		Integer totalPages = (Integer) FreemarkerUtils.getParameter(
				TOTAL_PAGES, Integer.class, params);
		Integer segmentCount = (Integer) FreemarkerUtils.getParameter(
				SEGMENT_COUNT, Integer.class, params);
		
		if ((pageNumber == null) || (pageNumber.intValue() < 1)) {
			pageNumber = Integer.valueOf(1);
		}
		if ((totalPages == null) || (totalPages.intValue() < 1)) {
			totalPages = Integer.valueOf(1);
		}
		if ((segmentCount == null) || (segmentCount.intValue() < 1)) {
			segmentCount = Integer.valueOf(5);
		}

		boolean hasPrevious = pageNumber.intValue() > 1;
		boolean hasNext = pageNumber.intValue() < totalPages.intValue();
		boolean isFirst = pageNumber.intValue() == 1;
		boolean isLast = pageNumber.equals(totalPages);
		int i = pageNumber.intValue() - 1;
		int j = pageNumber.intValue() + 1;
		int k = 1;
		int m = totalPages.intValue();
		int n = pageNumber.intValue()
				- (int) Math.floor((segmentCount.intValue() - 1) / 2.0D);
		int i1 = pageNumber.intValue()
				+ (int) Math.ceil((segmentCount.intValue() - 1) / 2.0D);
		if (n < 1) {
			n = 1;
		}
		if (i1 > totalPages.intValue()) {
			i1 = totalPages.intValue();
		}
		ArrayList arrayList = new ArrayList();
		for (int i2 = n; i2 <= i1; i2++) {
			arrayList.add(Integer.valueOf(i2));
		}
		HashMap hashMap = new HashMap();
		hashMap.put(PATTERN, pattern);
		hashMap.put(PAGE_NUMBER, pageNumber);
		hashMap.put(TOTAL_PAGES, totalPages);
		hashMap.put(SEGMENT_COUNT, segmentCount);
		hashMap.put(HAS_PREVIOUS, Boolean.valueOf(hasPrevious));
		hashMap.put(HAS_NEXT, Boolean.valueOf(hasNext));
		hashMap.put(IS_FIRST, Boolean.valueOf(isFirst));
		hashMap.put(IS_LAST, Boolean.valueOf(isLast));
		hashMap.put(PREVIOUS_PAGE_NUMBER, Integer.valueOf(i));
		hashMap.put(NEXT_PAGE_NUMBER, Integer.valueOf(j));
		hashMap.put(FIRST_PAGE_NUMBER, Integer.valueOf(k));
		hashMap.put(LAST_PAGE_NUMBER, Integer.valueOf(m));
		hashMap.put(SEGMENT, arrayList);
		render(hashMap, env, body);

	}	
	
}
