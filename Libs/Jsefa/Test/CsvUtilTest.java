package *************.utils.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ***************.BOObject1CSV;

import utils.CsvUtil;

public class CsvUtilTest {

	@Test
	public void testOKReadCSVObject1toJavaObject() throws IOException {
		//Given
		UnZipTest testUnZipIt = new UnZipTest();
		testUnZipIt.testUnZipIt();
		String outputFile = "temp/Object1/Object1.csv";
		List<BOObject1CSV> listBOListObject1CSV = null;
		
		//When
		try {
			listBOListObject1CSV = (List<BOObject1CSV>) CsvUtil.convertCSVintoJavaObject(outputFile, BOObject1CSV.class, ',', 0);
		} catch (FileNotFoundException e) {
			System.out.println("[ERREUR] " + e);
		}
		
		//Then
		assertTrue(listBOListObject1CSV.size() == 4111);
	}

}
