package com.system;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.lang.time.DateUtils;

import com.njby.utils.CommonAttributes;

public class DateEditor extends PropertyEditorSupport {
	private boolean emptyAsNull;  //是否允许为空
	private String dateFormat = "yyyy-MM-dd HH:mm:ss";

	public DateEditor(boolean emptyAsNull) {
		this.emptyAsNull = emptyAsNull;
	}

	public DateEditor(boolean emptyAsNull, String dateFormat) {
		this.emptyAsNull = emptyAsNull;
		this.dateFormat = dateFormat;
	}

	public String getAsText() {
		Date date = (Date) getValue();
		return date != null ? new SimpleDateFormat(this.dateFormat)
				.format(date) : "";
	}

	public void setAsText(String text) {
		if (text == null) {
			setValue(null);
		} else {
			String str = text.trim();
			if ((this.emptyAsNull) && ("".equals(str))) {
				setValue(null);
			} else {
				try {
					setValue(DateUtils.parseDate(str,
							CommonAttributes.DATE_PATTERNS));
				} catch (ParseException e) {
					setValue(null);
				}
			}
		}
	}
}
