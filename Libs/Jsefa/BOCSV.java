package com.nordnet.synchronisedomaine.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Mother Class
 */
public class BOCSV {
	
	protected String string1;
	
	protected String String2;

	protected Date date1;

	protected Date date2;

	/** The formatter. */
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * Instantiates a new bocsv.
	 */
	public BOCSV() {
		super();
		this.string1 = null;
		this.String2 = null;
		this.date1 = null;
		this.date2 = null;
	}

	/**
	 * Instantiates a new bocsv.
	 *
	 * @param string1 ?
	 * @param String2 ?
	 * @param date1 ?
	 * @param date2 ?
	 */
	public BOCSV(String string1, String string2, Date date1, Date date2) {
		super();
		this.string1 = string1;
		this.string2 = string2;
		this.date1 = date1;
		this.date2 = date2;
	}
	/**
	 * Gets the string1.
	 *
	 * @return the String1
	 */
	public String getString1() {
		return string1;
	}

	/**
	 * Sets the String1.
	 *
	 * @param string1 the new string1
	 */
	public void setString1(String string1) {
		this.string1 = string1;
	}

	/**
	 * Gets the String2.
	 *
	 * @return the String2
	 */
	public String getString2() {
		return string2;
	}

	/**
	 * Sets the String2.
	 *
	 * @param status the String2 to set
	 */
	public void setString2(String string2) {
		this.string2 = string2;
	}

	/**
	 * Gets the date1.
	 *
	 * @return date1
	 */
	public Date getDate1() {
		return date1;
	}
	
	/**
	 * Gets the formated date1.
	 *
	 * @return date1 ?
	 */
	public String getFormatedDate1() {
		if(date1 == null) {
			return null;
		}else {
			return formatter.format(date1);
		}
	}

	/**
	 * Sets date1.
	 *
	 * @param date1 ?
	 */
	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	/**
	 * Gets the date2.
	 *
	 * @return the date2
	 */
	public Date getDate2() {
		return date2;
	}
	
	/**
	 * Gets the formated date2.
	 *
	 * @return dueDate formater pour BDD
	 */
	public String getFormatedDate2() {
		if(date2 == null) {
			return null;
		}else {
			return formatter.format(date2);
		}
	}

	/**
	 * Sets the date2.
	 *
	 * @param Date2 ?
	 */
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	
	
}
