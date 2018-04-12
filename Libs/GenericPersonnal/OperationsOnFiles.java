package utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

import com.jcraft.jsch.SftpException;

// TODO: Auto-generated Javadoc
/**
 * The Class OperationsOnFiles.
 */
public class OperationsOnFiles {
	
	/** The logger. */
	private static Logger logger = Logger.getLogger(OperationsOnFiles.class);

	/**
	 * operationCopyCSV : Copy du fichier CSV/ZIP en local.
	 *
	 * @param inputFile the input file
	 * @param inputStream the input stream
	 * @throws SftpException the sftp exception
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void operationCopyCSV(String inputFile, InputStream inputStream)
			throws SftpException, FileNotFoundException, IOException {
		logger.trace("OperationsOnFiles.operationCopyCSV() - start()");
		
		byte[] buffer = new byte[1024];
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		OutputStream os = new FileOutputStream(new File(inputFile));
		
		logger.debug("Retrieving zip file.");
		BufferedOutputStream bos = new BufferedOutputStream(os);
		int readCount;
		while ((readCount = bis.read(buffer)) > 0) {
			logger.debug("Writing: ");
			bos.write(buffer, 0, readCount);
		}
		bis.close();
		bos.close();
		
		logger.trace("OperationsOnFiles.operationCopyCSV() - End()");
	}

	/**
	 * Change file extension.
	 *
	 * @param fileName the file name
	 * @param outputFolder the output folder
	 */
	public void changeFileExtensionToCSV(String fileName, String outputFolder) {
		logger.trace("OperationsOnFiles.changeFileExtension() - start()");
		
		int lastDotIndex = fileName.lastIndexOf(".");
		
		String fileNewName = fileName.substring(0, lastDotIndex)  + ".csv";
		File fileToRename = new File(fileName);
		File fileWithNewName = new File(fileNewName);
		
    	if(fileToRename.exists() && !fileWithNewName.exists()){
    		fileToRename.renameTo(fileWithNewName);
    	} else if (!fileToRename.exists()) {
    		logger.error(" Le fichier a renomme est absent du repertoire, fichier : " + fileName);
    	} else if (fileWithNewName.exists()) {
    		logger.error(" Le fichier renomme est deja present dans le repertoire, fichier : " + fileNewName);
    	}
		
		logger.trace("OperationsOnFiles.changeFileExtension() - end()");
	}

	/**
	 * Delete CSV file.
	 *
	 * @param csvFileName the csv file name
	 */
	public void deleteCSVFile(String csvFileName) {
		logger.trace("OperationsOnFiles.deleteCSVFile() - start()");

		Path csvPath = Paths.get(csvFileName);
		try {
			Files.delete(csvPath);
		} catch (IOException e) {
			logger.error("Erreur sur la suppression du fichier.");
		}
		
		logger.trace("OperationsOnFiles.deleteCSVFile() - end()");
	}

	public boolean checkFileSizeNotNull(String fileName) {
		logger.info("Enter OperationsOnFiles.checkFileSize method.");
		File fileToCheck = new File(fileName);
		if(fileToCheck.length() == 0){
			logger.warn("OperationsOnFiles.checkFileSize : le fichier : " + fileName + " est vide.");
			return false;
		}
		logger.info("Finished OperationsOnFiles.checkFileSize method.");
		return true;
	}
	
}
