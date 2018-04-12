package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import net.sf.jsefa.Deserializer;
import net.sf.jsefa.common.lowlevel.filter.HeaderAndFooterFilter;
import net.sf.jsefa.csv.CsvIOFactory;
import net.sf.jsefa.csv.config.CsvConfiguration;

// TODO: Auto-generated Javadoc
/**
 * The Class CsvUtil.
 */
public class CsvUtil {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(CsvUtil.class);

	/**
	 * convertCSVintoJavaObject : Convertisseur generique des CSVs
	 * vers les objets java correspondant.
	 *
	 * @param <T> the generic type
	 * @param csvFile the csv file
	 * @param genrericCSVClass the genreric CSV class
	 * @param fieldDelimiter the field delimiter
	 * @param csvHeader the csv header
	 * @return the t
	 * @throws FileNotFoundException the file not found exception
	 */
	public static <T> T convertCSVintoJavaObject(String csvFile, Class<T> genrericCSVClass, char fieldDelimiter, int csvHeader) throws FileNotFoundException {
		logger.trace("CsvUtil.convertCSVintoJavaObject() - start()");
		
		T ListCSVObject = (T) new ArrayList<Object>();
		CsvConfiguration config = new CsvConfiguration();
		//Definition de la configuration pour extraction correcte du csv
		config.setFieldDelimiter(fieldDelimiter);
		config.setLineFilter(new HeaderAndFooterFilter(csvHeader, false, true));
		
		try {
			//Deserialisation vis a vis de la classe mise en parametre
			Deserializer deserializer = CsvIOFactory.createFactory(config, genrericCSVClass).createDeserializer();
			deserializer.open(new FileReader(csvFile));

			//Recuperation des informations directement dans la class(Objet) concernee
			while (deserializer.hasNext()) {
				T csvObject = deserializer.next();
				logger.debug("CSV Line = " + csvObject.toString());
			    ((ArrayList<Object>) ListCSVObject).add(csvObject);
			}
			
		} catch (Exception e) {
			logger.error("[ERREUR] probleme de recuperation des informations csv : " , e);
		    return null;
		}
		logger.trace("CsvUtil.convertCSVintoJavaObject() - end()");
		return ListCSVObject;
	}
	
}
