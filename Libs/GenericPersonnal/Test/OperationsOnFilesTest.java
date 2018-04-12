package **********.utils.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.jdom.JDOMException;
import org.junit.Before;
import org.junit.Test;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import *****************************;
import *****************************;
import *****************************;

import utils.OperationsOnFiles;


public class OperationsOnFilesTest {

	OperationsOnFiles operationsOnFiles;
    Session session;
    Channel channel;
    ChannelSftp channelSftp;
    JSch jsch;
	ConnectTo***Servers connectTo***Servers;
		
	@Test
	public void testOperationCopyCSV() throws FileNotFoundException, SftpException, IOException, JDOMException, JSchException {
		//Given
        String inputFile = "temp/test/filedat.dat";
        String inputFolder = "/testfolder/";
        String fileDatName = "filedat.dat";
        jsch = new JSch();
	    ServerInformations serverInformations = connectToNNRServers.loadXmlConfig(**************************);
        session = jsch.getSession(serverInformations.getUser(), serverInformations.getHost(), serverInformations.getPort());
        session.setPassword(serverInformations.getPassword());
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        channel = session.openChannel("sftp");
		channel.connect();
		channelSftp = (ChannelSftp) channel;
		channelSftp.cd(inputFolder);
		operationsOnFiles = new OperationsOnFiles();
		
		//When
		operationsOnFiles.operationCopyCSV(inputFile, channelSftp.get(fileDatName));
		
		//Then
		File file = new File(inputFile);
		assertTrue(file.exists());
		operationsOnFiles.deleteCSVFile(inputFile);
	}
	
	@Test
	public void testChangeFileExtension() throws IOException{
		//Given
		String zipFileName = "filedat.dat";
		String outputFolder = "temp/test/";
		String csvFile = "fileCSV.csv";
		createTestFile(outputFolder+zipFileName);
		operationsOnFiles = new OperationsOnFiles();
		
		//When
		operationsOnFiles.changeFileExtensionToCSV(zipFileName, outputFolder);
		
		//Then
    	File file = new File(outputFolder+csvFile);
		assertTrue(file.exists());
		operationsOnFiles.deleteCSVFile(outputFolder+csvFile);
	}
	
	@Test
	public void testDeleteCSVFile() throws IOException {
		//Given
		String csvFileName = "temp/test/fileCSV.csv";
		createTestFile(csvFileName);
		operationsOnFiles = new OperationsOnFiles();
		
		//When
		operationsOnFiles.deleteCSVFile(csvFileName);
		
		//Then
    	File file = new File(csvFileName);
		assertTrue(!file.exists());		
	}
	
	/**
	 * Creates the test file.
	 *
	 * @param file the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*private void createTestFile(String file) throws IOException {
		File createdFile = new File(file);
		if(!createdFile.exists()){
			createdFile.createNewFile();
		}
	}

	@Test
	public void testCheckFileSizeNotNullisOK() {
		//Given
		String fileName = "temp/fileZIP.zip";
		operationsOnFiles = new OperationsOnFiles();
		boolean ret;

		//When
		ret = operationsOnFiles.checkFileSizeNotNull(fileName);
		
		//Then
		assertTrue(ret);
	}	

	@Test
	public void testCheckFileSizeNotNullisKO() {
		//Given
		String fileName = "temp/test/emptyFile.zip";
		operationsOnFiles = new OperationsOnFiles();
		boolean ret;

		//When
		ret = operationsOnFiles.checkFileSizeNotNull(fileName);
		
		//Then
		assertFalse(ret);
	}

}
