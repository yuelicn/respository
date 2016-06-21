package com.yl.myproject.annotation.blank;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredFieldValidator {
	/**
	 * 是否必填
	 * @return boolean
	 * @throws
	 * @author yue.li3 create to 2016年6月16日 下午3:22:55
	 */
	public boolean required() default true;

}
