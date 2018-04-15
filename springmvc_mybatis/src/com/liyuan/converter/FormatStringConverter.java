package com.liyuan.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class FormatStringConverter implements Converter<String,String>{

	@Override
	public String convert(String source) {
		
	
		return source.replace(" ", "");
	}

}
