/**
 * COPYRIGHT (C) 2016 Vamsi. 
 * 
 * @author Vamsi Dharmavarapu
 */
package com.jda.codehub.CodeHubServices.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.PrintingResultHandler;
import org.springframework.util.CollectionUtils;

// TODO: Auto-generated Javadoc
public class AbstractControllerTest {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Log.
	 * 
	 * @return the result handler
	 */
	protected ResultHandler log() {
		return new LoggerPrintingResultHandler();
	}

	private class LoggerPrintingResultHandler extends PrintingResultHandler {

		/**
		 * The Constructor.
		 */
		public LoggerPrintingResultHandler() {
			super(new ResultValuePrinter() {

				public void printHeading(String heading) {
					logger.debug(String.format("%20s:", heading));
				}

				public void printValue(String label, Object value) {
					if (value != null && value.getClass().isArray()) {
						value = CollectionUtils.arrayToList(value);
					}
					logger.debug(String.format("%20s = %s", label, value));
				}
			});
		}
	}

}
