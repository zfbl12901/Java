package **********;

import java.util.Date;

import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

// TODO: Auto-generated Javadoc
/**
 * The Class BOObject1CSV.
 */
@CsvDataType()
public class BOObject1CSV extends BOCSV{
	
	/** The string1. */
	@CsvField(pos = 1)
	private String string1;
	
	/** The string2. */
	@CsvField(pos = 2)
	private String string2;

	/** The name string3. */
	@CsvField(pos = 3)
	private String string3;

	/** The date1. */
	private Date date1;

	/** The date2. */
	private Date date2;
	

	/**
	 * Instantiates a new BO eurid CSV.
	 */
	public BOObject1CSV() {
		super();		
		super.string1 = null;
		super.string2 = null;
		this.string3 = null;
		super.date1 = null;
		super.date2 = null;
	}

	/**
	 * Instantiates a new BO object1 CSV.
	 *
	 * @param string1 the string1
	 * @param string2 the string2
	 * @param string3 the string3
	 * @param date1 the date1
	 * @param date2 the date2
	 */
	public BOObject1CSV(String string1, String string2, String string3, Date date1, Date date2) {
		super();
		super.string1 = string1;
		super.string2 = string2;
		this.string3 = string3;
		super.date1 = null;
		super.date2 = null;
	}

	/**
	 * Gets the string3.
	 *
	 * @return the string3
	 */
	public String getString3() {
		return string3;
	}

	/**
	 * Sets the string3.
	 *
	 * @param string3 the string3 to set
	 */
	public void setString3(String string3) {
		this.string3 = string3;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "BOObject1CSV [string1=" + super.string1 + ", string2=" + super.string2 + ", string3=" + this.string3 
				+ ", date1=" + super.date1 + ", date2=" + super.date2 + "]";
	}
			
}
