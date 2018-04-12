package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class UnZip.
 */
public class UnZip {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(UnZip.class);
	
    /**
     * unZipIt : Decompression du fichier ZIP et recuperation repertoire definit (outputFolder).
     *
     * @param zipFileName the zip file name
     * @param outputFolder the output folder
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void unZipIntoFolder(String zipFileName, String outputFolder) throws IOException {
		logger.trace("UnZip.unZipIntoFolder() - start()");
        byte[] buffer = new byte[1024];
        File zilFile = new File(zipFileName);
        ZipArchiveInputStream zis = new ZipArchiveInputStream(new FileInputStream(zilFile));
        
        verifyUnZipFolder(outputFolder);
        
        ZipEntry zipEntry = zis.getNextZipEntry();
        while (zipEntry != null) {
        	final String fileName = zipEntry.getName();
        	File newFile = new File(outputFolder);
        	FileOutputStream fos = new FileOutputStream(newFile + "/" + fileName);
        	int len;
        	while ((len = zis.read(buffer)) > 0) {
        		fos.write(buffer, 0, len);
        	}
        	fos.close();
        	zipEntry = zis.getNextZipEntry();
        }
        zis.close();      
		logger.trace("UnZip.unZipIntoFolder() - end()");
    }

	/**
	 * verifyUnZipFolder : Creation du repertoire si non-existant.
	 *
	 * @param outputFolder the output folder
	 */
	private void verifyUnZipFolder(String outputFolder) {
		logger.trace("UnZip.verifyUnZipFolder() - start()");
		
    	File folder = new File(outputFolder);
    	if(!folder.exists()){
    		folder.mkdir();
    	}
    	
		logger.trace("UnZip.verifyUnZipFolder() - end()");
	}
        
}
